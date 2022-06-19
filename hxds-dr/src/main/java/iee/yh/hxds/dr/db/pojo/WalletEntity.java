package iee.yh.hxds.dr.db.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class WalletEntity implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 司机ID
     */
    private Long driverId;

    /**
     * 钱包金额
     */
    private BigDecimal balance;

    /**
     * 支付密码
     */
    private String password;


    @Override
    public String toString() {
        return "WalletEntity{" +
                "id=" + id +
                ", driverId=" + driverId +
                ", balance=" + balance +
                ", password='" + password + '\'' +
                '}';
    }

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

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}