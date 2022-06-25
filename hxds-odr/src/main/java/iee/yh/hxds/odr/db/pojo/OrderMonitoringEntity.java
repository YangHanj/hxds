package iee.yh.hxds.odr.db.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单监控表
 * @TableName tb_order_monitoring
 */
public class OrderMonitoringEntity implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 订单ID
     */
    private Long orderId;

    /**
     * 录音文档云存储网址
     */
    private String recording;

    /**
     * 谈话文字内容
     */
    private String content;

    /**
     * 谈话内容的标签，比如辱骂、挑逗、开房、包养等
     */
    private String tag;

    /**
     * 创建时间
     */
    private Date createTime;

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

    public String getRecording() {
        return recording;
    }

    public void setRecording(String recording) {
        this.recording = recording;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}