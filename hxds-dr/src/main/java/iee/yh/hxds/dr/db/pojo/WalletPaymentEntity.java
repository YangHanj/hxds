package iee.yh.hxds.dr.db.pojo;

import java.io.Serializable;
import java.math.BigDecimal;


public class WalletPaymentEntity implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 司机ID
     */
    private Long driverId;

    /**
     * 支付金额
     */
    private BigDecimal amount;

    /**
     * 1话费，2罚款，3抽奖，4缴费，5其他
     */
    private Byte type;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private String createTime;

    private static final long serialVersionUID = 1L;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}