package iee.yh.hxds.bff.driver.controller.form;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * @author yanghan
 * @date 2022/7/2
 */
@Schema(description = "接收新订单消息的表单")
public class ReceiveNewOrderMessageForm {
    @Schema(description = "用户ID")
    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}

