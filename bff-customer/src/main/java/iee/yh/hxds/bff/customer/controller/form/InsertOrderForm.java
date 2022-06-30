package iee.yh.hxds.bff.customer.controller.form;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author yanghan
 * @date 2022/6/30
 */
@Schema(description = "顾客下单的表单")
public class InsertOrderForm {
    @NotBlank(message = "uuid不能为空")
    @Pattern(regexp = "^[0-9A-Za-z]{32}$", message = "uuid内容不正确")
    @Schema(description = "uuid")
    private String uuid;

    @Schema(description = "客户ID")
    private Long customerId;

    @NotBlank(message = "startPlace不能为空")
    @Pattern(regexp = "[\\(\\)0-9A-Z#\\-_\\u4e00-\\u9fa5]{2,50}", message = "startPlace内容不正确")
    @Schema(description = "订单起点")
    private String startPlace;

    @NotBlank(message = "startPlaceLatitude不能为空")
    @Pattern(regexp = "^(([1-8]\\d?)|([1-8]\\d))(\\.\\d{1,18})|90|0(\\.\\d{1,18})?$", message = "startPlaceLatitude内容不正确")
    @Schema(description = "订单起点的纬度")
    private String startPlaceLatitude;

    @NotBlank(message = "startPlaceLongitude不能为空")
    @Pattern(regexp = "^(([1-9]\\d?)|(1[0-7]\\d))(\\.\\d{1,18})|180|0(\\.\\d{1,18})?$", message = "startPlaceLongitude内容不正确")
    @Schema(description = "订单起点的经度")
    private String startPlaceLongitude;

    @NotBlank(message = "endPlace不能为空")
    @Pattern(regexp = "[\\(\\)0-9A-Z#\\-_\\u4e00-\\u9fa5]{2,50}", message = "endPlace内容不正确")
    @Schema(description = "订单终点")
    private String endPlace;

    @NotBlank(message = "endPlaceLatitude不能为空")
    @Pattern(regexp = "^(([1-8]\\d?)|([1-8]\\d))(\\.\\d{1,18})|90|0(\\.\\d{1,18})?$", message = "endPlaceLatitude内容不正确")
    @Schema(description = "订单终点的纬度")
    private String endPlaceLatitude;

    @NotBlank(message = "endPlaceLongitude不能为空")
    @Pattern(regexp = "^(([1-9]\\d?)|(1[0-7]\\d))(\\.\\d{1,18})|180|0(\\.\\d{1,18})?$", message = "endPlaceLongitude内容不正确")
    @Schema(description = "订单终点的经度")
    private String endPlaceLongitude;

    @NotBlank(message = "expectsMileage不能为空")
    @Pattern(regexp = "^[1-9]\\d*\\.\\d+$|^0\\.\\d*[1-9]\\d*$|^[1-9]\\d*$", message = "expectsMileage内容不正确")
    @Schema(description = "预估代驾公里数")
    private String expectsMileage;

    @NotBlank(message = "expectsFee不能为空")
    @Pattern(regexp = "^[1-9]\\d*\\.\\d{1,2}$|^0\\.\\d{1,2}$|^[1-9]\\d*$", message = "expectsFee内容不正确")
    @Schema(description = "预估代驾费用")
    private String expectsFee;

    @NotBlank(message = "favourFee不能为空")
    @Pattern(regexp = "^[1-9]\\d*\\.\\d{1,2}$|^0\\.\\d{1,2}$|^[1-9]\\d*$", message = "favourFee内容不正确")
    @Schema(description = "顾客好处费")
    private String favourFee;

    @NotNull(message = "chargeRuleId不能为空")
    @Min(value = 1, message = "chargeRuleId不能小于1")
    @Schema(description = "规则ID")
    private Long chargeRuleId;

    @NotBlank(message = "carPlate不能为空")
    @Pattern(regexp = "^([京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}(([0-9]{5}[DF])|([DF]([A-HJ-NP-Z0-9])[0-9]{4})))|([京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-HJ-NP-Z0-9]{4}[A-HJ-NP-Z0-9挂学警港澳]{1})$",
            message = "carPlate内容不正确")
    @Schema(description = "车牌号")
    private String carPlate;

    @NotBlank(message = "carType不能为空")
    @Pattern(regexp = "^[\\u4e00-\\u9fa5A-Za-z0-9\\-\\_\\s]{2,20}$", message = "carType内容不正确")
    @Schema(description = "车型")
    private String carType;

    @NotBlank(message = "date不能为空")
    @Pattern(regexp = "^((((1[6-9]|[2-9]\\d)\\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\\d|3[01]))|(((1[6-9]|[2-9]\\d)\\d{2})-(0?[13456789]|1[012])-(0?[1-9]|[12]\\d|30))|(((1[6-9]|[2-9]\\d)\\d{2})-0?2-(0?[1-9]|1\\d|2[0-8]))|(((1[6-9]|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))-0?2-29-))$", message = "date内容不正确")
    @Schema(description = "日期")
    private String date;

    @NotNull(message = "baseMileage不能为空")
    @Min(value = 1, message = "baseMileage不能小于1")
    @Schema(description = "基础里程（公里）")
    private Short baseMileage;

    @NotBlank(message = "baseMileagePrice不能为空")
    @Pattern(regexp = "^[1-9]\\d*\\.\\d{1,2}$|^0\\.\\d{1,2}$|^[1-9]\\d*$", message = "baseMileagePrice内容不正确")
    @Schema(description = "基础里程价格")
    private String baseMileagePrice;

    @NotBlank(message = "exceedMileagePrice不能为空")
    @Pattern(regexp = "^[1-9]\\d*\\.\\d{1,2}$|^0\\.\\d{1,2}$|^[1-9]\\d*$", message = "exceedMileagePrice内容不正确")
    @Schema(description = "超出基础里程的价格")
    private String exceedMileagePrice;

    @NotNull(message = "baseMinute不能为空")
    @Min(value = 1, message = "baseMinute不能小于1")
    @Schema(description = "基础分钟")
    private Short baseMinute;

    @NotBlank(message = "exceedMinutePrice不能为空")
    @Pattern(regexp = "^[1-9]\\d*\\.\\d{1,2}$|^0\\.\\d{1,2}$|^[1-9]\\d*$", message = "exceedMinutePrice内容不正确")
    @Schema(description = "超出基础分钟的价格")
    private String exceedMinutePrice;

    @NotNull(message = "baseReturnMileage不能为空")
    @Min(value = 1, message = "baseReturnMileage不能小于1")
    @Schema(description = "基础返程里程（公里）")
    private Short baseReturnMileage;

    @NotBlank(message = "exceedReturnPrice不能为空")
    @Pattern(regexp = "^[1-9]\\d*\\.\\d{1,2}$|^0\\.\\d{1,2}$|^[1-9]\\d*$", message = "exceedReturnPrice内容不正确")
    @Schema(description = "超出基础返程里程的价格")
    private String exceedReturnPrice;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getStartPlace() {
        return startPlace;
    }

    public void setStartPlace(String startPlace) {
        this.startPlace = startPlace;
    }

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

    public String getEndPlace() {
        return endPlace;
    }

    public void setEndPlace(String endPlace) {
        this.endPlace = endPlace;
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

    public String getExpectsMileage() {
        return expectsMileage;
    }

    public void setExpectsMileage(String expectsMileage) {
        this.expectsMileage = expectsMileage;
    }

    public String getExpectsFee() {
        return expectsFee;
    }

    public void setExpectsFee(String expectsFee) {
        this.expectsFee = expectsFee;
    }

    public String getFavourFee() {
        return favourFee;
    }

    public void setFavourFee(String favourFee) {
        this.favourFee = favourFee;
    }

    public Long getChargeRuleId() {
        return chargeRuleId;
    }

    public void setChargeRuleId(Long chargeRuleId) {
        this.chargeRuleId = chargeRuleId;
    }

    public String getCarPlate() {
        return carPlate;
    }

    public void setCarPlate(String carPlate) {
        this.carPlate = carPlate;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Short getBaseMileage() {
        return baseMileage;
    }

    public void setBaseMileage(Short baseMileage) {
        this.baseMileage = baseMileage;
    }

    public String getBaseMileagePrice() {
        return baseMileagePrice;
    }

    public void setBaseMileagePrice(String baseMileagePrice) {
        this.baseMileagePrice = baseMileagePrice;
    }

    public String getExceedMileagePrice() {
        return exceedMileagePrice;
    }

    public void setExceedMileagePrice(String exceedMileagePrice) {
        this.exceedMileagePrice = exceedMileagePrice;
    }

    public Short getBaseMinute() {
        return baseMinute;
    }

    public void setBaseMinute(Short baseMinute) {
        this.baseMinute = baseMinute;
    }

    public String getExceedMinutePrice() {
        return exceedMinutePrice;
    }

    public void setExceedMinutePrice(String exceedMinutePrice) {
        this.exceedMinutePrice = exceedMinutePrice;
    }

    public Short getBaseReturnMileage() {
        return baseReturnMileage;
    }

    public void setBaseReturnMileage(Short baseReturnMileage) {
        this.baseReturnMileage = baseReturnMileage;
    }

    public String getExceedReturnPrice() {
        return exceedReturnPrice;
    }

    public void setExceedReturnPrice(String exceedReturnPrice) {
        this.exceedReturnPrice = exceedReturnPrice;
    }
}

