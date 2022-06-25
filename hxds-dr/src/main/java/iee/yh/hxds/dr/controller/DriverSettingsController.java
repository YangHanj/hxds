package iee.yh.hxds.dr.controller;

import iee.yh.common.util.R;
import iee.yh.hxds.dr.controller.form.SearchDriverSettingsForm;
import iee.yh.hxds.dr.service.DriverSettingsService;
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
 * @date 2022/6/25
 */
@RestController
@RequestMapping("/settings")
@Tag(name = "SrttingsController" ,description = "司机设置模块web接口")
public class DriverSettingsController {
    @Resource
    private DriverSettingsService driverSettingsService;

    @PostMapping("/searchDriverSettings")
    @Operation(summary = "查询司机的设置")
    public R searchDriverSettings(@RequestBody @Valid SearchDriverSettingsForm form) {
        HashMap map = driverSettingsService.searchDriverSettings(form.getDriverId());
        return R.ok().put("result", map);
    }
}
