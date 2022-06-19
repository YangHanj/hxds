package iee.yh.hxds.dr.db.pojo;
import java.io.Serializable;
import java.math.BigDecimal;


public class WalletIncomeEntity implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * uuid字符串
     */
    private String uuid;
    /**
     * 司机ID
     */
    private Long driverId;

    /**
     * 金额
     */
    private BigDecimal amount;

    /**
     * 1充值，2奖励，3补贴
     */
    private Byte type;

    /**
     * 预支付订单ID
     */
    private String prepayId;

    /**
     * 1未支付，2已支付，3已到账
     */
    private Byte status;

    /**
     * 备注信息
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

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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

    public String getPrepayId() {
        return prepayId;
    }

    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId;
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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}