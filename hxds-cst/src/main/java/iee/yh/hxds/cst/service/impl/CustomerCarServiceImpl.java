package iee.yh.hxds.cst.service.impl;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import iee.yh.hxds.cst.db.dao.CustomerCarDao;
import iee.yh.hxds.cst.db.pojo.CustomerCarEntity;
import iee.yh.hxds.cst.service.CustomerCarService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author yanghan
 * @date 2022/6/30
 */
@Service
public class CustomerCarServiceImpl implements CustomerCarService {
    @Resource
    private CustomerCarDao customerCarDao;
    @Override
    @Transactional
    @LcnTransaction
    public void insertCustomerCar(CustomerCarEntity entity) {
        customerCarDao.insert(entity);
    }

    @Override
    public ArrayList<HashMap> searchCustomerCarList(long customerId) {
        return customerCarDao.searchCustomerCarList(customerId);
    }

    @Override
    @Transactional
    @LcnTransaction
    public int deleteCustomerCarById(long id) {
        return customerCarDao.deleteCustomerCarById(id);
    }
}
