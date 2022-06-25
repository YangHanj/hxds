package iee.yh.hxds.odr.service;

import java.util.HashMap;

/**
 * @author yanghan
 * @date 2022/6/25
 */
public interface OrderService {
    /**
     * 查询当日订单
     * @param driverId
     * @return
     */
    HashMap searchDriverTodayBusinessData(long driverId);
}
