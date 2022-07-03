package iee.yh.hxds.bff.driver.service.impl;

import iee.yh.common.util.R;
import iee.yh.hxds.bff.driver.controller.form.ClearNewOrderQueueForm;
import iee.yh.hxds.bff.driver.controller.form.ReceiveNewOrderMessageForm;
import iee.yh.hxds.bff.driver.feign.SnmServiceApi;
import iee.yh.hxds.bff.driver.service.NewOrderMessageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * @author yanghan
 * @date 2022/7/2
 */
@Service
public class NewOrderMessageServiceImpl implements NewOrderMessageService {
    @Resource
    private SnmServiceApi snmServiceApi;

    @Override
    public void clearNewOrderQueue(ClearNewOrderQueueForm form) {
        snmServiceApi.clearNewOrderQueue(form);
    }

    @Override
    public ArrayList receiveNewOrderMessage(ReceiveNewOrderMessageForm form) {
        R r = snmServiceApi.receiveNewOrderMessage(form);
        ArrayList  result = (ArrayList) r.get("result");
        return result;
    }
}

