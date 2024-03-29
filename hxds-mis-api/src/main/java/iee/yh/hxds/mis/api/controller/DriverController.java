package iee.yh.hxds.mis.api.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.annotation.SaMode;
import iee.yh.common.util.PageUtils;
import iee.yh.common.util.R;
import iee.yh.hxds.mis.api.controller.form.SearchDriverByPageForm;
import iee.yh.hxds.mis.api.controller.form.SearchDriverComprehensiveDataForm;
import iee.yh.hxds.mis.api.controller.form.UpdateDriverRealAuthForm;
import iee.yh.hxds.mis.api.service.DriverService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;

/**
 * @author yanghan
 * @date 2022/6/26
 */
@RestController
@RequestMapping("/driver")
@Tag(name = "DriverController", description = "司机管理Web接口")
public class DriverController {

    @Resource
    private DriverService driverService;

    @PostMapping("/searchDriverByPage")
    @SaCheckPermission(value = {"ROOT", "DRIVER:SELECT"}, mode = SaMode.OR)
    @Operation(summary = "查询司机分页记录")
    public R searchDriverByPage(@RequestBody @Valid SearchDriverByPageForm form) {
        PageUtils pageUtils = driverService.searchDriverByPage(form);
        return R.ok().put("result", pageUtils);
    }

    @PostMapping("/searchDriverComprehensiveData")
    @SaCheckPermission(value = {"ROOT", "DRIVER:SELECT"}, mode = SaMode.OR)
    @Operation(summary = "查询司机综合数据")
    public R searchDriverComprehensiveData(@RequestBody @Valid SearchDriverComprehensiveDataForm form) {
        HashMap map = driverService.searchDriverComprehensiveData(form.getRealAuth(), form.getDriverId());
        return R.ok().put("result", map);
    }

    @PostMapping("/updateDriverRealAuth")
    @SaCheckPermission(value = {"ROOT", "DRIVER:UPDATE"}, mode = SaMode.OR)
    @Operation(summary = "更新司机实名认证状态")
    public R updateDriverRealAuth(@RequestBody @Valid UpdateDriverRealAuthForm form) {
        int rows = driverService.updateDriverRealAuth(form);
        return R.ok().put("rows", rows);
    }
}

