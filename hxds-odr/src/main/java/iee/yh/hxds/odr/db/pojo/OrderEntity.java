package iee.yh.hxds.odr.db.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单表
 *
 * @TableName tb_order
 */
public class OrderEntity implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 订单序列号
     */
    private String uuid;

    /**
     * 客户ID
     */
    private Long customerId;

    /**
     * 起始地点
     */
    private String startPlace;

    /**
     * 起始地点坐标信息
     */
    private String startPlaceLocation;

    /**
     * 结束地点
     */
    private String endPlace;

    /**
     * 结束地点坐标信息
     */
    private String endPlaceLocation;

    /**
     * 预估里程
     */
    private BigDecimal expectsMileage;

    /**
     * 实际里程
     */
    private BigDecimal realMileage;

    /**
     * 返程里程
     */
    private BigDecimal returnMileage;

    /**
     * 预估订单价格
     */
    private BigDecimal expectsFee;

    /**
     * 顾客好处费
     */
    private BigDecimal favourFee;

    /**
     * 系统奖励费
     */
    private BigDecimal incentiveFee;

    /**
     * 实际订单价格
     */
    private BigDecimal realFee;

    /**
     * 司机ID
     */
    private Long driverId;

    /**
     * 订单日期
     */
    private String date;

    /**
     * 订单创建时间
     */
    private Date createTime;

    /**
     * 司机接单时间
     */
    private Date acceptTime;

    /**
     * 司机到达时间
     */
    private Date arriveTime;

    /**
     * 代驾开始时间
     */
    private Date startTime;

    /**
     * 代驾结束时间
     */
    private Date endTime;

    /**
     * 代驾等时分钟数
     */
    private Short waitingMinute;

    /**
     * 微信预支付单ID
     */
    private String prepayId;

    /**
     * 微信支付单ID
     */
    private String payId;

    /**
     * 微信付款时间
     */
    private Date payTime;

    /**
     * 费用规则ID
     */
    private Long chargeRuleId;

    /**
     * 订单取消规则ID
     */
    private Long cancelRuleId;

    /**
     * 车牌号
     */
    private String carPlate;

    /**
     * 车型
     */
    private String carType;

    /**
     * 1等待接单，2已接单，3司机已到达，4开始代驾，5结束代驾，6未付款，7已付款，8订单已结束，9顾客撤单，10司机撤单，11事故关闭，12其他
     */
    private Byte status;

    /**
     * 订单备注
     */
    private String remark;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getStartPlaceLocation() {
        return startPlaceLocation;
    }

    public void setStartPlaceLocation(String startPlaceLocation) {
        this.startPlaceLocation = startPlaceLocation;
    }

    public String getEndPlace() {
        return endPlace;
    }

    public void setEndPlace(String endPlace) {
        this.endPlace = endPlace;
    }

    public String getEndPlaceLocation() {
        return endPlaceLocation;
    }

    public void setEndPlaceLocation(String endPlaceLocation) {
        this.endPlaceLocation = endPlaceLocation;
    }

    public BigDecimal getExpectsMileage() {
        return expectsMileage;
    }

    public void setExpectsMileage(BigDecimal expectsMileage) {
        this.expectsMileage = expectsMileage;
    }

    public BigDecimal getRealMileage() {
        return realMileage;
    }

    public void setRealMileage(BigDecimal realMileage) {
        this.realMileage = realMileage;
    }

    public BigDecimal getReturnMileage() {
        return returnMileage;
    }

    public void setReturnMileage(BigDecimal returnMileage) {
        this.returnMileage = returnMileage;
    }

    public BigDecimal getExpectsFee() {
        return expectsFee;
    }

    public void setExpectsFee(BigDecimal expectsFee) {
        this.expectsFee = expectsFee;
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

    public BigDecimal getRealFee() {
        return realFee;
    }

    public void setRealFee(BigDecimal realFee) {
        this.realFee = realFee;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getAcceptTime() {
        return acceptTime;
    }

    public void setAcceptTime(Date acceptTime) {
        this.acceptTime = acceptTime;
    }

    public Date getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(Date arriveTime) {
        this.arriveTime = arriveTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Short getWaitingMinute() {
        return waitingMinute;
    }

    public void setWaitingMinute(Short waitingMinute) {
        this.waitingMinute = waitingMinute;
    }

    public String getPrepayId() {
        return prepayId;
    }

    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId;
    }

    public String getPayId() {
        return payId;
    }

    public void setPayId(String payId) {
        this.payId = payId;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Long getChargeRuleId() {
        return chargeRuleId;
    }

    public void setChargeRuleId(Long chargeRuleId) {
        this.chargeRuleId = chargeRuleId;
    }

    public Long getCancelRuleId() {
        return cancelRuleId;
    }

    public void setCancelRuleId(Long cancelRuleId) {
        this.cancelRuleId = cancelRuleId;
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

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}