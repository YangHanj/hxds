package iee.yh.hxds.bff.customer.controller.form;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotBlank;

/**
 * @author yanghan
 * @date 2022/6/29
 */

@Schema(description = "登陆系统")
public class LoginForm {
    @NotBlank(message = "code不能为空")
    @Schema(description = "微信小程序临时授权")
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
