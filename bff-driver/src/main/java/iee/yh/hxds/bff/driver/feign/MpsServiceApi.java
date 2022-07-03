package iee.yh.hxds.bff.driver.feign;

import iee.yh.common.util.R;
import iee.yh.hxds.bff.driver.controller.form.RemoveLocationCacheForm;
import iee.yh.hxds.bff.driver.controller.form.UpdateLocationCacheForm;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

/**
 * @author yanghan
 * @date 2022/7/1
 */
@FeignClient("hxds-mps")
public interface MpsServiceApi {
    @PostMapping("/driver/location/updateLocationCache")
    R updateLocationCache(UpdateLocationCacheForm form);

    @PostMapping("/driver/location/removeLocationCache")
    R removeLocationCache(RemoveLocationCacheForm form);
}
