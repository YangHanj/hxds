package iee.yh.hxds.cst.db.pojo;


import java.io.Serializable;

public class CustomerCarEntity implements Serializable {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
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

    /**
     * 主键
     */
    private Long id;

    /**
     * 客户ID
     */
    private Long customerId;

    /**
     * 车牌号
     */
    private String carPlate;

    /**
     * 车型
     */
    private String carType;

    private static final long serialVersionUID = 1L;
}