package iee.yh.hxds.bff.driver.feign;

import iee.yh.common.util.R;
import iee.yh.hxds.bff.driver.controller.form.CreateDriverFaceModelForm;
import iee.yh.hxds.bff.driver.controller.form.LoginForm;
import iee.yh.hxds.bff.driver.controller.form.RegisterNewDriverForm;
import iee.yh.hxds.bff.driver.controller.form.UpdateDriverAuthForm;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;


/**
 * @author yanghan
 * @date 2022/6/20
 */
@FeignClient(value = "hxds-dr")
public interface DrServiceApi {

    @PostMapping("/driver/registerNewDriver")
    R registerNewDriver(RegisterNewDriverForm from);

    @PostMapping("/driver/updateDriverAuth")
    R updateDriverAuth(UpdateDriverAuthForm form);

    @PostMapping("/driver/createDriverFaceModel")
    R createDriverFaceModel(CreateDriverFaceModelForm form);

    @PostMapping("/driver/login")
    R login(LoginForm form);
}
