package iee.yh.hxds.mis.api.controller.form;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "强制让司机下线的表单")
public class ForceLogoutForm {

    @Schema(description = "加密后的Hex数据")
    private String encryptHex;

    @Schema(description = "数字签名字符串")
    private String signStr;

    public String getSignStr() {
        return signStr;
    }

    public void setSignStr(String signStr) {
        this.signStr = signStr;
    }

    public String getEncryptHex() {
        return encryptHex;
    }

    public void setEncryptHex(String encryptHex) {
        this.encryptHex = encryptHex;
    }
}