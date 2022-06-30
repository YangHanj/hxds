package iee.yh.hxds.odr.db.dao;

import iee.yh.hxds.odr.db.pojo.OrderBillEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderBillDao {
    /**
     * 插入账单
     * @param entity
     * @return
     */
    int insert(OrderBillEntity entity);
}




