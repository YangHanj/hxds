package iee.yh.hxds.bff.customer.service;

import iee.yh.hxds.bff.customer.controller.form.*;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author yanghan
 * @date 2022/6/29
 */
public interface CustomerService {
    long registerNewCustomer(RegisterNewCustomerForm form);
    Long login(LoginForm form);


}
