package iee.yh.hxds.bff.driver.controller.form;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * @author yanghan
 * @date 2022/7/2
 */
@Schema(description = "清空新订单消息队列的表单")
public class ClearNewOrderQueueForm {

    @Schema(description = "用户ID")
    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}

