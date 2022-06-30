package iee.yh.hxds.bff.customer.controller.form;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author yanghan
 * @date 2022/6/30
 */
@Schema(description = "查询客户车辆的表单")
public class SearchCustomerCarListForm {

    @Schema(description = "客户ID")
    private Long customerId;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}

