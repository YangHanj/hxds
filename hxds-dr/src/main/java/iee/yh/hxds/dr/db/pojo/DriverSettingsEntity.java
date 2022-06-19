package iee.yh.hxds.dr.db.pojo;


import java.io.Serializable;

public class DriverSettingsEntity implements Serializable {
    @Override
    public String toString() {
        return "DriverSettingsEntity{" +
                "id=" + id +
                ", driverId=" + driverId +
                ", settings='" + settings + '\'' +
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

    public String getSettings() {
        return settings;
    }

    public void setSettings(String settings) {
        this.settings = settings;
    }

    /**
     * 主键
     */
    private Long id;

    /**
     * 司机ID
     */
    private Long driverId;

    /**
     * 个人设置
     */
    private String settings;

    private static final long serialVersionUID = 1L;
}