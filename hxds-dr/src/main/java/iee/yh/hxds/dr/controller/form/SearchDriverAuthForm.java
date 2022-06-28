package iee.yh.hxds.dr.controller.form;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author yanghan
 * @date 2022/6/27
 */
@Schema(description = "查询司机认证信息表单")
public class SearchDriverAuthForm {

    @Min(value = 1,message = "driverId不能小于1")
    @NotNull(message = "driverId不能为空")
    @Schema(description = "司机ID")
    private Long driverId;

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }
}
