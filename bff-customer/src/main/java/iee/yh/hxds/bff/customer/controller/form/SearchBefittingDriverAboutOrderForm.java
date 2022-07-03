package iee.yh.hxds.bff.customer.controller.form;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * @author yanghan
 * @date 2022/7/1
 */
@Schema(description = "查询符合某个订单接单的司机列表的表单")
public class SearchBefittingDriverAboutOrderForm {
    @NotBlank(message = "startPlaceLatitude不能为空")
    @Pattern(regexp = "^(([1-8]\\d?)|([1-8]\\d))(\\.\\d{1,18})|90|0(\\.\\d{1,18})?$", message = "startPlaceLatitude内容不正确")
    @Schema(description = "订单起点的纬度")
    private String startPlaceLatitude;

    @NotBlank(message = "startPlaceLongitude不能为空")
    @Pattern(regexp = "^(([1-9]\\d?)|(1[0-7]\\d))(\\.\\d{1,18})|180|0(\\.\\d{1,18})?$", message = "startPlaceLongitude内容不正确")
    @Schema(description = "订单起点的经度")
    private String startPlaceLongitude;

    @NotBlank(message = "endPlaceLatitude不能为空")
    @Pattern(regexp = "^(([1-8]\\d?)|([1-8]\\d))(\\.\\d{1,18})|90|0(\\.\\d{1,18})?$", message = "endPlaceLatitude内容不正确")
    @Schema(description = "订单终点的纬度")
    private String endPlaceLatitude;

    @NotBlank(message = "endPlaceLongitude不能为空")
    @Pattern(regexp = "^(([1-9]\\d?)|(1[0-7]\\d))(\\.\\d{1,18})|180|0(\\.\\d{1,18})?$", message = "endPlaceLongitude内容不正确")
    @Schema(description = "订单起点的经度")
    private String endPlaceLongitude;

    @NotBlank(message = "mileage不能为空")
    @Pattern(regexp = "^[1-9]\\d*\\.\\d+$|^0\\.\\d*[1-9]\\d*$|^[1-9]\\d*$", message = "mileage内容不正确")
    @Schema(description = "预估里程")
    private String mileage;

    public String getStartPlaceLatitude() {
        return startPlaceLatitude;
    }

    public void setStartPlaceLatitude(String startPlaceLatitude) {
        this.startPlaceLatitude = startPlaceLatitude;
    }

    public String getStartPlaceLongitude() {
        return startPlaceLongitude;
    }

    public void setStartPlaceLongitude(String startPlaceLongitude) {
        this.startPlaceLongitude = startPlaceLongitude;
    }

    public String getEndPlaceLatitude() {
        return endPlaceLatitude;
    }

    public void setEndPlaceLatitude(String endPlaceLatitude) {
        this.endPlaceLatitude = endPlaceLatitude;
    }

    public String getEndPlaceLongitude() {
        return endPlaceLongitude;
    }

    public void setEndPlaceLongitude(String endPlaceLongitude) {
        this.endPlaceLongitude = endPlaceLongitude;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }
}

