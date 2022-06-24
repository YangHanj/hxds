package iee.yh.hxds.dr.controller;

import cn.hutool.core.bean.BeanUtil;
import iee.yh.common.util.R;
import iee.yh.hxds.dr.controller.form.CreateDriverFaceModelForm;
import iee.yh.hxds.dr.controller.form.LoginForm;
import iee.yh.hxds.dr.controller.form.RegisterNewDriverForm;
import iee.yh.hxds.dr.controller.form.UpdateDriverAuthForm;
import iee.yh.hxds.dr.service.DriverService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yanghan
 * @date 2022/6/19
 */
@RestController
@RequestMapping("/driver")
@Tag(name = "DriverController",description = "司机模块web接口")
public class DriverController {
    @Resource
    private DriverService driverService;

    @PostMapping("/registerNewDriver")
    @Operation(summary = "新司机注册")
    public R registerNewDriver(@RequestBody @Valid RegisterNewDriverForm from){
        Map param = BeanUtil.beanToMap(from);
        String userId = driverService.registerNewDriver(param);
        return R.ok().put("userId",userId);
    }

    @PostMapping("/updateDriverAuth")
    @Operation(summary = "更新实名认证信息")
    public R updateDriverAuth(@RequestBody @Valid UpdateDriverAuthForm form) {
        Map param = BeanUtil.beanToMap(form);
        int rows = driverService.updateDriverAuth(param);
        return R.ok().put("rows", rows);
    }

    @PostMapping("/createDriverFaceModel")
    @Operation(summary = "创建司机人脸模型归档")
    public R createDriverFaceModel(@RequestBody @Valid CreateDriverFaceModelForm form) {
        String result = driverService.createDriverFaceModel(form.getDriverId(), form.getPhoto());
        return R.ok().put("result", result);
    }

    @PostMapping("/login")
    @Operation(summary = "登陆系统")
    public R login(@RequestBody @Valid LoginForm form) {
        HashMap map = driverService.login(form.getCode());
        return R.ok().put("result", map);
    }
}
