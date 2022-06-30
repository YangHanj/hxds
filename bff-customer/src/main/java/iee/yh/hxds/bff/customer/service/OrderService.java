package iee.yh.hxds.bff.customer.service;

import iee.yh.hxds.bff.customer.controller.form.CreateNewOrderForm;

/**
 * @author yanghan
 * @date 2022/6/30
 */
public interface OrderService {
    int createNewOrder(CreateNewOrderForm form);
}
