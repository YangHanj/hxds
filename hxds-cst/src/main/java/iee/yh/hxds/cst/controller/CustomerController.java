package iee.yh.hxds.cst.controller;

import cn.hutool.core.bean.BeanUtil;
import iee.yh.common.util.R;
import iee.yh.hxds.cst.controller.form.LoginForm;
import iee.yh.hxds.cst.controller.form.RegisterNewCustomerForm;
import iee.yh.hxds.cst.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Map;

/**
 * @author yanghan
 * @date 2022/6/29
 */
@RestController
@RequestMapping("/customer")
@Tag(name = "CustomerController", description = "客户Web接口")
public class CustomerController {
    @Resource
    private CustomerService customerService;

    @PostMapping("/registerNewCustomer")
    @Operation(summary = "注册新司机")
    public R registerNewCustomer(@RequestBody @Valid RegisterNewCustomerForm form) {
        Map param = BeanUtil.beanToMap(form);
        String userId = customerService.registerNewCustomer(param);
        return R.ok().put("userId", userId);
    }

    @PostMapping("/login")
    @Operation(summary = "登陆系统")
    public R login(@RequestBody @Valid LoginForm form) {
        String userId = customerService.login(form.getCode());
        return R.ok().put("userId", userId);
    }
}
