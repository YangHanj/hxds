package iee.yh.hxds.bff.customer.service;

import iee.yh.hxds.bff.customer.controller.form.CreateNewOrderForm;

import java.util.HashMap;

/**
 * @author yanghan
 * @date 2022/6/30
 */
public interface OrderService {
    HashMap createNewOrder(CreateNewOrderForm form);
}
