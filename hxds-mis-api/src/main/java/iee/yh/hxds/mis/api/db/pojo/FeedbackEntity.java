package iee.yh.hxds.mis.api.db.pojo;
import java.io.Serializable;

/**
 * 
 * @TableName tb_feedback
 */
public class FeedbackEntity implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 反馈者姓名
     */
    private String customerName;

    /**
     * 反馈者电话
     */
    private String customerTel;

    /**
     * 接待员ID
     */
    private Long userId;

    /**
     * 反馈类型，1系统故障，2服务质量，3支付异常，4其他
     */
    private Integer type;

    /**
     * 反馈内容
     */
    private String content;

    /**
     * 反馈状态，1未处理，2已处理
     */
    private Integer status;

    /**
     * 处理结果
     */
    private String result;

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

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerTel() {
        return customerTel;
    }

    public void setCustomerTel(String customerTel) {
        this.customerTel = customerTel;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}