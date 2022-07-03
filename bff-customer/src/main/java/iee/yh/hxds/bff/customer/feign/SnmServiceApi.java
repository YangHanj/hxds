package iee.yh.hxds.bff.customer.feign;

import iee.yh.common.util.R;
import iee.yh.hxds.bff.customer.controller.form.SendNewOrderMessageForm;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author yanghan
 * @date 2022/7/2
 */
@FeignClient(value = "hxds-snm")
public interface SnmServiceApi {
    @PostMapping("/message/order/new/sendNewOrderMessageAsync")
    R sendNewOrderMessageAsync(SendNewOrderMessageForm form);
}

