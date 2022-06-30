package iee.yh.hxds.cst.service;

import iee.yh.hxds.cst.db.pojo.CustomerCarEntity;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author yanghan
 * @date 2022/6/30
 */
public interface CustomerCarService {
    /**
     * 添加车辆
     * @param entity
     * @return
     */
    void insertCustomerCar(CustomerCarEntity entity);

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
