package iee.yh.hxds.dr.service.impl;

import cn.hutool.core.map.MapUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import iee.yh.hxds.dr.db.dao.DriverSettingsDao;
import iee.yh.hxds.dr.service.DriverSettingsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @author yanghan
 * @date 2022/6/25
 */
@Service
public class DriverSettingsServiceImpl implements DriverSettingsService {

    @Resource
    private DriverSettingsDao driverSettingsDao;

    @Override
    public HashMap searchDriverSettings(long driverId) {
        String settings = driverSettingsDao.searchDriverSettings(driverId);
        HashMap map = JSONUtil.parseObj(settings).toBean(HashMap.class);
        boolean bool = MapUtil.getInt(map, "listenService") == 1 ? true : false;
        map.replace("listenService",bool);
        bool = MapUtil.getInt(map, "autoAccpet") == 1 ? true : false;
        map.replace("autoAccept", bool);
        return map;
    }
}
