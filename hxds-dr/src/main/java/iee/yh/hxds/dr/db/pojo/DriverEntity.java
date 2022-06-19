package iee.yh.hxds.dr.db.pojo;

import java.io.Serializable;

public class DriverEntity implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 小程序长期授权
     */
    private String openId;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 性别
     */
    private String sex;

    /**
     * 姓名
     */
    private String name;

    /**
     * 头像
     */
    private String photo;

    /**
     * 电话
     */
    private String tel;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 1未认证，2已认证
     */
    private Byte realAuth;

    /**
     * 身份证编号
     */
    private String identityLicence;

    /**
     * 身份证图片云存储网址
     */
    private String identityLicenceImg;

    /**
     * 驾驶证编号
     */
    private String drivingLicence;

    /**
     * 驾驶证图片云存储网址
     */
    private String drivingLicenceImg;

    /**
     * 摘要信息，level等级，totalOrder接单数，weekOrder周接单，weekComment周好评，appeal正在申诉量
     */
    private String summary;

    /**
     * 是否在腾讯云归档存放司机面部信息
     */
    private Boolean archive;

    /**
     * 状态，1正常，2禁用，3.降低接单量
     */
    private Byte status;

    /**
     * 注册时间
     */
    private String createTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Byte getRealAuth() {
        return realAuth;
    }

    public void setRealAuth(Byte realAuth) {
        this.realAuth = realAuth;
    }

    public String getIdentityLicence() {
        return identityLicence;
    }

    public void setIdentityLicence(String identityLicence) {
        this.identityLicence = identityLicence;
    }

    public String getIdentityLicenceImg() {
        return identityLicenceImg;
    }

    public void setIdentityLicenceImg(String identityLicenceImg) {
        this.identityLicenceImg = identityLicenceImg;
    }

    public String getDrivingLicence() {
        return drivingLicence;
    }

    public void setDrivingLicence(String drivingLicence) {
        this.drivingLicence = drivingLicence;
    }

    public String getDrivingLicenceImg() {
        return drivingLicenceImg;
    }

    public void setDrivingLicenceImg(String drivingLicenceImg) {
        this.drivingLicenceImg = drivingLicenceImg;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Boolean getArchive() {
        return archive;
    }

    public void setArchive(Boolean archive) {
        this.archive = archive;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "DriverEntity{" +
                "id=" + id +
                ", openId='" + openId + '\'' +
                ", nickname='" + nickname + '\'' +
                ", sex='" + sex + '\'' +
                ", name='" + name + '\'' +
                ", photo='" + photo + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", realAuth=" + realAuth +
                ", identityLicence='" + identityLicence + '\'' +
                ", identityLicenceImg='" + identityLicenceImg + '\'' +
                ", drivingLicence='" + drivingLicence + '\'' +
                ", drivingLicenceImg='" + drivingLicenceImg + '\'' +
                ", summary='" + summary + '\'' +
                ", archive=" + archive +
                ", status=" + status +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}