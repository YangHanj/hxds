package iee.yh.hxds.mps.service.impl;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import iee.yh.common.exception.HxdsException;
import iee.yh.hxds.mps.service.MapService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;

/**
 * @author yanghan
 * @date 2022/6/29
 */
@Service
public class MapServiceImpl implements MapService {
    //预估里程的API地址
    private String distanceUrl = "https://apis.map.qq.com/ws/distance/v1/matrix/";
    //路径规划API地址
    private String directionUrl = "https://apis.map.qq.com/ws/direction/v1/driving/";

    private Logger log = LoggerFactory.getLogger(MapServiceImpl.class);

    @Value("${tencent.map.key}")
    private String key;

    public HashMap estimateOrderMileageAndMinute(String mode,
                                                 String startPlaceLatitude,
                                                 String startPlaceLongitude,
                                                 String endPlaceLatitude,
                                                 String endPlaceLongitude) {
        HttpRequest req = new HttpRequest(distanceUrl);
        req.form("mode", mode);
        req.form("from", startPlaceLatitude + "," + startPlaceLongitude);
        req.form("to", endPlaceLatitude + "," + endPlaceLongitude);
        req.form("key", key);
        HttpResponse resp = req.execute();
        JSONObject json = JSONUtil.parseObj(resp.body());
        int status = json.getInt("status");
        String message = json.getStr("message");
        log.info(message);
        if (status != 0) {
            log.error(message);
            throw new HxdsException("预估里程异常：" + message);
        }
        JSONArray rows = json.getJSONObject("result").getJSONArray("rows");
        JSONObject element = rows.get(0, JSONObject.class).getJSONArray("elements").get(0, JSONObject.class);
        int distance = element.getInt("distance");
        String mileage = new BigDecimal(distance).divide(new BigDecimal(1000)).toString();
        int duration = element.getInt("duration");
        String temp = new BigDecimal(duration).divide(new BigDecimal(60), 0, RoundingMode.CEILING).toString();
        int minute = Integer.parseInt(temp);

        HashMap map = new HashMap() {{
            put("mileage", mileage);
            put("minute", minute);
        }};
        return map;
    }

    @Override
    public HashMap calculateDriveLine(String startPlaceLatitude,
                                      String startPlaceLongitude,
                                      String endPlaceLatitude,
                                      String endPlaceLongitude) {
        HttpRequest req = new HttpRequest(directionUrl);
        req.form("from", startPlaceLatitude + "," + startPlaceLongitude);
        req.form("to", endPlaceLatitude + "," + endPlaceLongitude);
        req.form("key", key);

        HttpResponse resp = req.execute();
        JSONObject json = JSONUtil.parseObj(resp.body());
        int status = json.getInt("status");
        if (status != 0) {
            throw new HxdsException("执行异常");
        }
        JSONObject result = json.getJSONObject("result");
        HashMap map = result.toBean(HashMap.class);
        return map;
    }

}
