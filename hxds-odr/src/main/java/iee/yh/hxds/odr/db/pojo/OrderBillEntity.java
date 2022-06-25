package iee.yh.hxds.odr.db.pojo;


import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 订单账单表
 *
 * @TableName tb_order_bill
 */

public class OrderBillEntity implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 订单ID
     */
    private Long orderId;

    /**
     * 总金额
     */
    private BigDecimal total;
    /**
     * 实付款金额
     */
    private BigDecimal realPay;
    /**
     * 里程费
     */
    private BigDecimal mileageFee;

    /**
     * 通话费
     */
    private BigDecimal telFee;

    /**
     * 等时费用
     */
    private BigDecimal waitingFee;

    /**
     * 路桥费
     */
    private BigDecimal tollFee;

    /**
     * 停车费
     */
    private BigDecimal parkingFee;

    /**
     * 其他费用
     */
    private BigDecimal otherFee;

    /**
     * 返程费
     */
    private BigDecimal returnFee;

    /**
     * 顾客好处费
     */
    private BigDecimal favourFee;

    /**
     * 系统奖励费
     */
    private BigDecimal incentiveFee;

    /**
     * 代金券面额
     */
    private BigDecimal voucherFee;


    /**
     * 详情
     */
    private String detail;
    /**
     * 基础里程（公里）
     */
    private Short baseMileage;
    /**
     * 基础里程价格
     */
    private BigDecimal baseMileagePrice;
    /**
     * 超出基础里程的价格
     */
    private BigDecimal exceedMileagePrice;
    /**
     * 基础分钟
     */
    private Short baseMinute;
    /**
     * 超出基础分钟的价格
     */
    private BigDecimal exceedMinutePrice;

    /**
     * 基础返程里程（公里）
     */
    private Short baseReturnMileage;

    /**
     * 超出基础返程里程的价格
     */
    private BigDecimal exceedReturnPrice;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getRealPay() {
        return realPay;
    }

    public void setRealPay(BigDecimal realPay) {
        this.realPay = realPay;
    }

    public BigDecimal getMileageFee() {
        return mileageFee;
    }

    public void setMileageFee(BigDecimal mileageFee) {
        this.mileageFee = mileageFee;
    }

    public BigDecimal getTelFee() {
        return telFee;
    }

    public void setTelFee(BigDecimal telFee) {
        this.telFee = telFee;
    }

    public BigDecimal getWaitingFee() {
        return waitingFee;
    }

    public void setWaitingFee(BigDecimal waitingFee) {
        this.waitingFee = waitingFee;
    }

    public BigDecimal getTollFee() {
        return tollFee;
    }

    public void setTollFee(BigDecimal tollFee) {
        this.tollFee = tollFee;
    }

    public BigDecimal getParkingFee() {
        return parkingFee;
    }

    public void setParkingFee(BigDecimal parkingFee) {
        this.parkingFee = parkingFee;
    }

    public BigDecimal getOtherFee() {
        return otherFee;
    }

    public void setOtherFee(BigDecimal otherFee) {
        this.otherFee = otherFee;
    }

    public BigDecimal getReturnFee() {
        return returnFee;
    }

    public void setReturnFee(BigDecimal returnFee) {
        this.returnFee = returnFee;
    }

    public BigDecimal getFavourFee() {
        return favourFee;
    }

    public void setFavourFee(BigDecimal favourFee) {
        this.favourFee = favourFee;
    }

    public BigDecimal getIncentiveFee() {
        return incentiveFee;
    }

    public void setIncentiveFee(BigDecimal incentiveFee) {
        this.incentiveFee = incentiveFee;
    }

    public BigDecimal getVoucherFee() {
        return voucherFee;
    }

    public void setVoucherFee(BigDecimal voucherFee) {
        this.voucherFee = voucherFee;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Short getBaseMileage() {
        return baseMileage;
    }

    public void setBaseMileage(Short baseMileage) {
        this.baseMileage = baseMileage;
    }

    public BigDecimal getBaseMileagePrice() {
        return baseMileagePrice;
    }

    public void setBaseMileagePrice(BigDecimal baseMileagePrice) {
        this.baseMileagePrice = baseMileagePrice;
    }

    public BigDecimal getExceedMileagePrice() {
        return exceedMileagePrice;
    }

    public void setExceedMileagePrice(BigDecimal exceedMileagePrice) {
        this.exceedMileagePrice = exceedMileagePrice;
    }

    public Short getBaseMinute() {
        return baseMinute;
    }

    public void setBaseMinute(Short baseMinute) {
        this.baseMinute = baseMinute;
    }

    public BigDecimal getExceedMinutePrice() {
        return exceedMinutePrice;
    }

    public void setExceedMinutePrice(BigDecimal exceedMinutePrice) {
        this.exceedMinutePrice = exceedMinutePrice;
    }

    public Short getBaseReturnMileage() {
        return baseReturnMileage;
    }

    public void setBaseReturnMileage(Short baseReturnMileage) {
        this.baseReturnMileage = baseReturnMileage;
    }

    public BigDecimal getExceedReturnPrice() {
        return exceedReturnPrice;
    }

    public void setExceedReturnPrice(BigDecimal exceedReturnPrice) {
        this.exceedReturnPrice = exceedReturnPrice;
    }
}