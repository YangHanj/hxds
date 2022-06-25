package iee.yh.hxds.odr.service.impl;

import cn.hutool.core.map.MapUtil;
import iee.yh.hxds.odr.db.dao.OrderDao;
import iee.yh.hxds.odr.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @author yanghan
 * @date 2022/6/25
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Override
    public HashMap searchDriverTodayBusinessData(long driverId) {
        HashMap result = orderDao.searchDriverTodayBusinessData(driverId);
        String duration = MapUtil.getStr(result, "duration");
        if (duration == null){
            duration = "0";
        }
        result.replace("duration",duration);

        String income = MapUtil.getStr(result, "income");
        if (income == null){
            income = "0.00";
        }
        result.replace("income",income);
        return result;
    }
}
