package iee.yh.hxds.bff.driver.service;

import iee.yh.hxds.bff.driver.controller.form.ClearNewOrderQueueForm;
import iee.yh.hxds.bff.driver.controller.form.ReceiveNewOrderMessageForm;

import java.util.ArrayList;

/**
 * @author yanghan
 * @date 2022/7/2
 */
public interface NewOrderMessageService {

    void clearNewOrderQueue(ClearNewOrderQueueForm form);


    ArrayList receiveNewOrderMessage(ReceiveNewOrderMessageForm form);
}
