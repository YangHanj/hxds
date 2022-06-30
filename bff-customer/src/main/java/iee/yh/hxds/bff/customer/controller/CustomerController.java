package iee.yh.hxds.bff.customer.controller;

import cn.dev33.satoken.stp.StpUtil;
import iee.yh.common.util.R;
import iee.yh.hxds.bff.customer.controller.form.*;
import iee.yh.hxds.bff.customer.service.CustomerCarService;
import iee.yh.hxds.bff.customer.service.CustomerService;
import iee.yh.hxds.bff.customer.service.impl.CustomerCarServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;

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
    @Resource
    private CustomerCarService customerCarService;

    @PostMapping("/registerNewCustomer")
    @Operation(summary = "注册新司机")
    public R registerNewCustomer(@RequestBody @Valid RegisterNewCustomerForm form) {
        long customerId = customerService.registerNewCustomer(form);
        StpUtil.login(customerId);
        String token = StpUtil.getTokenInfo().getTokenValue();
        return R.ok().put("token", token);
    }

    @PostMapping("/login")
    @Operation(summary = "登陆系统")
    public R login(@RequestBody @Valid LoginForm form) {
        Long customerId = customerService.login(form);
        if (customerId != null) {
            StpUtil.login(customerId);
            String token = StpUtil.getTokenInfo().getTokenValue();
            return R.ok().put("token", token);
        }
        return R.ok();
    }
}

