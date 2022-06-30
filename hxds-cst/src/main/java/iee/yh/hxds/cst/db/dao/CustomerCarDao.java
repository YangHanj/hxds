package iee.yh.hxds.cst.db.dao;

import iee.yh.hxds.cst.db.pojo.CustomerCarEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.HashMap;

@Mapper
public interface CustomerCarDao {
    /**
     * 添加车辆
     * @param entity
     * @return
     */
    int insert(CustomerCarEntity entity);

    /**
     * 返回用户车辆
     * @param customerId
     * @return
     */
    ArrayList<HashMap> searchCustomerCarList(long customerId);

    /**
     * 删除用户车辆
     * @param id
     * @return
     */
    int deleteCustomerCarById(long id);
}




