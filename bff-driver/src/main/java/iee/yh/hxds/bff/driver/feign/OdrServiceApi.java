package iee.yh.hxds.bff.driver.feign;

import iee.yh.common.util.R;
import iee.yh.hxds.bff.driver.controller.form.SearchDriverTodayBusinessDataForm;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author yanghan
 * @date 2022/6/25
 */
@FeignClient(value = "hxds-odr")
public interface OdrServiceApi {
    @PostMapping("/order/searchDriverTodayBusinessData")
    R searchDriverTodayBusinessData(SearchDriverTodayBusinessDataForm form);
}
