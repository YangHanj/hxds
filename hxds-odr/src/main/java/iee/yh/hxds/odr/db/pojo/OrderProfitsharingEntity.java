package iee.yh.hxds.odr.db.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 订单分账表
 *
 * @TableName tb_order_profitsharing
 */
public class OrderProfitsharingEntity implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 订单ID
     */
    private Long orderId;

    /**
     * 规则ID
     */
    private Long ruleId;

    /**
     * 总费用
     */
    private BigDecimal amountFee;

    /**
     * 微信支付渠道费率
     */
    private BigDecimal paymentRate;

    /**
     * 微信支付渠道费
     */
    private BigDecimal paymentFee;

    /**
     * 为代驾司机代缴税率
     */
    private BigDecimal taxRate;

    /**
     * 税率支出
     */
    private BigDecimal taxFee;

    /**
     * 企业分账收入
     */
    private BigDecimal systemIncome;

    /**
     * 司机分账收入
     */
    private BigDecimal driverIncome;

    /**
     * 分账状态，1未分账，2已分账
     */
    private Byte status;

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

    public Long getRuleId() {
        return ruleId;
    }

    public void setRuleId(Long ruleId) {
        this.ruleId = ruleId;
    }

    public BigDecimal getAmountFee() {
        return amountFee;
    }

    public void setAmountFee(BigDecimal amountFee) {
        this.amountFee = amountFee;
    }

    public BigDecimal getPaymentRate() {
        return paymentRate;
    }

    public void setPaymentRate(BigDecimal paymentRate) {
        this.paymentRate = paymentRate;
    }

    public BigDecimal getPaymentFee() {
        return paymentFee;
    }

    public void setPaymentFee(BigDecimal paymentFee) {
        this.paymentFee = paymentFee;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public BigDecimal getTaxFee() {
        return taxFee;
    }

    public void setTaxFee(BigDecimal taxFee) {
        this.taxFee = taxFee;
    }

    public BigDecimal getSystemIncome() {
        return systemIncome;
    }

    public void setSystemIncome(BigDecimal systemIncome) {
        this.systemIncome = systemIncome;
    }

    public BigDecimal getDriverIncome() {
        return driverIncome;
    }

    public void setDriverIncome(BigDecimal driverIncome) {
        this.driverIncome = driverIncome;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}