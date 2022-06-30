package iee.yh.hxds.bff.customer.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yanghan
 * @date 2022/6/30
 */
@RestController
@RequestMapping("/charge")
@Tag(name = "ChargeRuleController", description = "代驾费用的Web接口")
public class ChargeRuleController {
    //TODO 规则引擎预估价格
}
