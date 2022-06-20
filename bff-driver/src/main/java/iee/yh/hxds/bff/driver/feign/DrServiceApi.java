package iee.yh.hxds.bff.driver.feign;

import iee.yh.common.util.R;
import iee.yh.hxds.bff.driver.controller.form.RegisterNewDriverForm;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

/**
 * @author yanghan
 * @date 2022/6/20
 */
@FeignClient(value = "hxds-dr")
public interface DrServiceApi {

    @PostMapping("/deiver/registerNewDriver")
    R registerNewDriver(RegisterNewDriverForm from);
}
