package iee.yh.hxds.dr.controller.form;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author yanghan
 * @date 2022/6/28
 */
@Schema(description = "查询司机")
public class SearchDriverRealSummaryForm {
    @NotNull(message = "driverId不能为空")
    @Min(message = "deiverId不能小于1",value = 1)
    @Schema(description = "司机ID")
    private Long driverId;

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }
}
