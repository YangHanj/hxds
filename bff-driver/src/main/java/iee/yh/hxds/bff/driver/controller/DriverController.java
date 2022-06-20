package iee.yh.hxds.bff.driver.controller;

import cn.dev33.satoken.stp.StpUtil;
import iee.yh.common.util.R;
import iee.yh.hxds.bff.driver.controller.form.RegisterNewDriverForm;
import iee.yh.hxds.bff.driver.service.DriverService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author yanghan
 * @date 2022/6/20
 */
@RestController
@RequestMapping("/driver")
@Tag(name = "DriverController", description = "司机模块Web接口")
public class DriverController {
    @Resource
    private DriverService driverService;

    @PostMapping("/registerNewDriver")
    @Operation(summary = "司机注册")
    public R registerNewDriver(@Valid @RequestBody RegisterNewDriverForm form){
        long driverId = driverService.registerNewDriver(form);
        // 在saToken上面执行登录，缓存userId，拿到令牌
        StpUtil.login(driverId);
        // 生成token加密令牌
        String token = StpUtil.getTokenInfo().getTokenValue();
        return R.ok().put("token",token);
    }
}
