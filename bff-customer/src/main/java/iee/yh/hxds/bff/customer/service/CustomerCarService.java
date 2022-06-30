package iee.yh.hxds.bff.customer.service;

import iee.yh.hxds.bff.customer.controller.form.DeleteCustomerCarByIdForm;
import iee.yh.hxds.bff.customer.controller.form.InsertCustomerCarForm;
import iee.yh.hxds.bff.customer.controller.form.SearchCustomerCarListForm;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author yanghan
 * @date 2022/6/30
 */
public interface CustomerCarService {
    void insertCustomerCar(InsertCustomerCarForm form);

    ArrayList<HashMap> searchCustomerCarList(SearchCustomerCarListForm form);

    int deleteCustomerCarById(DeleteCustomerCarByIdForm form);
}
