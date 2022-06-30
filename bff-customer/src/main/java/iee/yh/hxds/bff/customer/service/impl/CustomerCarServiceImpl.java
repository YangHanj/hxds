package iee.yh.hxds.bff.customer.service.impl;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import iee.yh.hxds.bff.customer.controller.form.DeleteCustomerCarByIdForm;
import iee.yh.hxds.bff.customer.controller.form.InsertCustomerCarForm;
import iee.yh.hxds.bff.customer.controller.form.SearchCustomerCarListForm;
import iee.yh.hxds.bff.customer.feign.CstServiceApi;
import iee.yh.hxds.bff.customer.service.CustomerCarService;
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
    private CstServiceApi cstServiceApi;
    @Override
    @Transactional
    @LcnTransaction
    public void insertCustomerCar(InsertCustomerCarForm form) {
        cstServiceApi.insertCustomerCar(form);
    }

    @Override
    public ArrayList<HashMap> searchCustomerCarList(SearchCustomerCarListForm form) {
        return (ArrayList<HashMap>) cstServiceApi.searchCustomerCarList(form).get("result");
    }

    @Override
    @Transactional
    @LcnTransaction
    public int deleteCustomerCarById(DeleteCustomerCarByIdForm form) {
        return (int)cstServiceApi.deleteCustomerCarById(form).get("rows");
    }
}
