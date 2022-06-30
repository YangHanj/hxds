package iee.yh.hxds.odr.service;

import iee.yh.hxds.odr.db.pojo.OrderBillEntity;
import iee.yh.hxds.odr.db.pojo.OrderEntity;

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

    /**
     * 创建订单以及账单
     * @param orderEntity
     * @param billEntity
     * @return
     */
    String insertOrder(OrderEntity orderEntity, OrderBillEntity billEntity);


}
