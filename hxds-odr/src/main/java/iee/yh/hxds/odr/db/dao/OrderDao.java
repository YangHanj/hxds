package iee.yh.hxds.odr.db.dao;

import iee.yh.hxds.odr.db.pojo.OrderEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.Map;

@Mapper
public interface OrderDao {
    /**
     * 查询当日订单
     * @param driverId
     * @return
     */
    HashMap searchDriverTodayBusinessData(long driverId);

    /**
     * 插入订单
     * @param entity
     * @return
     */
    int insert(OrderEntity entity);

    /**
     * 查询订单
     * @param uuid
     * @return
     */
    String searchOrderIdByUUID(String uuid);

    /**
     * 修改订单
     * @param param
     * @return
     */
    int acceptNewOrder(Map param);
}




