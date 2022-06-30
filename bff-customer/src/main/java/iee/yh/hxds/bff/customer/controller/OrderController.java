package iee.yh.hxds.bff.customer.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import iee.yh.common.util.R;
import iee.yh.hxds.bff.customer.controller.form.CreateNewOrderForm;
import iee.yh.hxds.bff.customer.service.OrderService;
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
 * @date 2022/6/30
 */
@RestController
@RequestMapping("/order")
@Tag(name = "OrderController", description = "订单模块Web接口")
public class OrderController {
    @Resource
    private OrderService orderService;

    @PostMapping("/createNewOrder")
    @Operation(summary = "创建新订单")
    @SaCheckLogin
    public R createNewOrder(@RequestBody @Valid CreateNewOrderForm form) {
        Long customerId = StpUtil.getLoginIdAsLong();
        form.setCustomerId(customerId);
        int count = orderService.createNewOrder(form);
        return R.ok().put("count", count);
    }

}

