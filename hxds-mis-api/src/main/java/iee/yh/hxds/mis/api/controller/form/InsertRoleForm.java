package iee.yh.hxds.mis.api.controller.form;

import io.swagger.v3.oas.annotations.media.Schema;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Schema(description = "添加角色表单")
public class InsertRoleForm {

    @NotBlank(message = "roleName不能为空")
    @Schema(description = "角色名称")
    private String roleName;

    @NotEmpty(message = "permissions不能为空")
    @Schema(description = "权限")
    private Integer[] permissions;


    @Length(max = 20,message = "desc不能超过20个字符")
    @Schema(description = "备注")
    private String desc;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer[] getPermissions() {
        return permissions;
    }

    public void setPermissions(Integer[] permissions) {
        this.permissions = permissions;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}