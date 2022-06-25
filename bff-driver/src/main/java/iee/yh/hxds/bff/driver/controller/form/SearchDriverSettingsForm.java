package iee.yh.hxds.bff.driver.controller.form;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * @author yanghan
 * @date 2022/6/25
 */
@Schema(description = "查询司机设置")
public class SearchDriverSettingsForm {
    @Schema(description = "司机ID")
    private Long driverId;

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }
}
