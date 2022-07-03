package iee.yh.hxds.bff.customer.feign;

import iee.yh.common.util.R;
import iee.yh.hxds.bff.customer.controller.form.EstimateOrderMileageAndMinuteForm;
import iee.yh.hxds.bff.customer.controller.form.SearchBefittingDriverAboutOrderForm;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author yanghan
 * @date 2022/6/30
 */
@FeignClient(value = "hxds-mps")
public interface MpsServiceApi {
    @PostMapping("/map/estimateOrderMileageAndMinute")
    R estimateOrderMileageAndMinute(EstimateOrderMileageAndMinuteForm form);

    @PostMapping("/driver/location/searchBefittingDriverAboutOrder")
    R searchBefittingDriverAboutOrder(SearchBefittingDriverAboutOrderForm form);
}


