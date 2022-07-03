package iee.yh.hxds.snm.controller.form;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.*;

/**
 * @author yanghan
 * @date 2022/7/2
 */
@Schema(description = "发送新订单消息的表单")
public class SendNewOrderMessageForm {
    @NotEmpty(message = "driversContent不能为空")
    @Schema(description = "司机的相关信息（司机ID#接单距离）")
    private String[] driversContent;

    @NotNull(message = "orderId不能为空")
    @Min(value = 1, message = "orderId不能小于1")
    @Schema(description = "订单ID")
    private Long orderId;

    @NotBlank(message = "from内容不正确")
    @Pattern(regexp = "[\\(\\)0-9A-Z#\\-_\\u4e00-\\u9fa5]{2,50}", message = "from内容不正确")
    @Schema(description = "订单起点")
    private String from;

    @NotBlank(message = "to内容不正确")
    @Pattern(regexp = "[\\(\\)0-9A-Z#\\-_\\u4e00-\\u9fa5]{2,50}", message = "to内容不正确")
    @Schema(description = "订单终点")
    private String to;

    @NotBlank(message = "expectsFee不能为空")
    @Pattern(regexp = "^[1-9]\\d*\\.\\d{1,2}$|^0\\.\\d{1,2}$|^[1-9]\\d*$", message = "expectsFee内容不正确")
    @Schema(description = "预估价格")
    private String expectsFee;

    @NotBlank(message = "mileage不能为空")
    @Pattern(regexp = "^[1-9]\\d*\\.\\d+$|^0\\.\\d*[1-9]\\d*$|^[1-9]\\d*$", message = "mileage内容不正确")
    @Schema(description = "预估里程")
    private String mileage;

    @NotNull(message = "minute")
    @Min(value = 1, message = "minute不能小于1")
    @Schema(description = "预估时长")
    private Integer minute;

    @NotBlank(message = "favourFee不能为空")
    @Pattern(regexp = "^[1-9]\\d*\\.\\d{1,2}$|^0\\.\\d{1,2}$|^[1-9]\\d*$", message = "favourFee内容不正确")
    @Schema(description = "顾客好处费")
    private String favourFee;

    public String[] getDriversContent() {
        return driversContent;
    }

    public void setDriversContent(String[] driversContent) {
        this.driversContent = driversContent;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getExpectsFee() {
        return expectsFee;
    }

    public void setExpectsFee(String expectsFee) {
        this.expectsFee = expectsFee;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public Integer getMinute() {
        return minute;
    }

    public void setMinute(Integer minute) {
        this.minute = minute;
    }

    public String getFavourFee() {
        return favourFee;
    }

    public void setFavourFee(String favourFee) {
        this.favourFee = favourFee;
    }
}

