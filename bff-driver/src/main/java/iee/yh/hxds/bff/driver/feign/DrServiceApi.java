package iee.yh.hxds.bff.driver.feign;

import iee.yh.common.util.R;
import iee.yh.hxds.bff.driver.controller.form.*;
import io.swagger.v3.oas.annotations.Operation;
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

    @PostMapping("/driver/registerNewDriver")
    R registerNewDriver(RegisterNewDriverForm from);

    @PostMapping("/driver/updateDriverAuth")
    R updateDriverAuth(UpdateDriverAuthForm form);

    @PostMapping("/driver/createDriverFaceModel")
    R createDriverFaceModel(CreateDriverFaceModelForm form);

    @PostMapping("/driver/login")
    R login(LoginForm form);

    @PostMapping("/driver/searchDriverBaseInfo")
    R searchDriverBaseInfo(SearchDriverBaseInfoForm form);

    @PostMapping("/driver/searchDriverAuth")
    R searchDriverAuth(SearchDriverAuthForm form);

    @PostMapping("/settings/searchDriverSettings")
    R searchDriverSettings(SearchDriverSettingsForm form);
}
