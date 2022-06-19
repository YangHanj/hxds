package iee.yh.hxds.dr.controller.form;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotBlank;

/**
 * @author yanghan
 * @date 2022/6/19
 */
@Schema(description = "新司机注册表单")
public class RegisterNewDriverForm {
    @NotBlank(message = "code不能为空")
    @Schema(description = "微信小程序临时授权码")
    private String code;
    @NotBlank(message = "nickname不能为空")
    @Schema(description = "用户昵称")
    private String nickname;
    @NotBlank(message = "photo不能为空")
    @Schema(description = "用户头像")
    private String photo;

    @Override
    public String toString() {
        return "RegisterNewDriverForm{" +
                "code='" + code + '\'' +
                ", nickname='" + nickname + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
