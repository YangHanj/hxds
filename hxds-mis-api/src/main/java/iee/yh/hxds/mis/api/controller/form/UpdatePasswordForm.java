package iee.yh.hxds.mis.api.controller.form;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Schema(description = "修改密码表单")
public class UpdatePasswordForm {
    @NotBlank(message = "newPassword不能为空")
    @Pattern(regexp = "^[a-zA-Z0-9]{6,20}$", message = "newPassword内容不正确")
    @Schema(description = "新密码")
    String newPassword;

    @NotBlank(message = "oldPassword不能为空")
    @Pattern(regexp = "^[a-zA-Z0-9]{6,20}$", message = "oldPassword内容不正确")
    @Schema(description = "旧密码")
    String oldPassword;

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }
}