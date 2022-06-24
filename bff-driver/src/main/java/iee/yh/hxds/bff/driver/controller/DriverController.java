package iee.yh.hxds.bff.driver.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.map.MapUtil;
import iee.yh.common.util.R;
import iee.yh.hxds.bff.driver.controller.form.CreateDriverFaceModelForm;
import iee.yh.hxds.bff.driver.controller.form.LoginForm;
import iee.yh.hxds.bff.driver.controller.form.RegisterNewDriverForm;
import iee.yh.hxds.bff.driver.controller.form.UpdateDriverAuthForm;
import iee.yh.hxds.bff.driver.service.DriverService;
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

    @PostMapping("/updateDriverAuth")
    @Operation(summary = "更新实名认证信息")
    @SaCheckLogin
    public R updateDriverAuth(@RequestBody @Valid UpdateDriverAuthForm form) {
        // 根据session中的令牌获取ID
        long driverId = StpUtil.getLoginIdAsLong();
        form.setDriverId(driverId);
        int rows = driverService.updateDriverAuth(form);
        return R.ok().put("rows", rows);
    }

    @PostMapping("/createDriverFaceModel")
    @Operation(summary = "创建司机人脸模型归档")
    @SaCheckLogin
    public R createDriverFaceModel(@RequestBody @Valid CreateDriverFaceModelForm form) {
        // 根据session中的令牌获取ID
        long driverId = StpUtil.getLoginIdAsLong();
        form.setDriverId(driverId);
        String result = driverService.createDriverFaceModel(form);
        return R.ok().put("result", result);
    }

    @PostMapping("/login")
    @Operation(summary = "司机登录")
    public R login(@RequestBody @Valid LoginForm form){
        HashMap map = driverService.login(form);
        if (map != null){
            Long driverId = MapUtil.getLong(map, "id");
            byte realAuth = Byte.parseByte(MapUtil.getStr(map, "realAuth"));
            boolean archive = MapUtil.getBool(map,"archive");
            StpUtil.login(driverId);
            String token = StpUtil.getTokenInfo().getTokenValue();
            // 返回用户的信息
            /**
             * 1、token令牌，标识已经登录
             * 2、是否认证
             * 3、是否存储面部信息
             */
            return R.ok().put("token",token).put("realAuth",realAuth).put("archive",archive);
        }
        return R.ok();
    }
}
