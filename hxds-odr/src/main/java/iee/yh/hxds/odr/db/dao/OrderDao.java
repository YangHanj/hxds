package iee.yh.hxds.odr.db.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

@Mapper
public interface OrderDao {
    /**
     * 查询当日订单
     * @param driverId
     * @return
     */
    HashMap searchDriverTodayBusinessData(long driverId);
}




