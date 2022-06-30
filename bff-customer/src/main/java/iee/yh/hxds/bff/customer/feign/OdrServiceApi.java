package iee.yh.hxds.bff.customer.feign;

import iee.yh.common.util.R;
import iee.yh.hxds.bff.customer.controller.form.InsertOrderForm;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

/**
 * @author yanghan
 * @date 2022/6/30
 */
@FeignClient("hxds-odr")
public interface OdrServiceApi {
    @PostMapping("/order/insertOrder")
    R insertOrder(InsertOrderForm form);
}
