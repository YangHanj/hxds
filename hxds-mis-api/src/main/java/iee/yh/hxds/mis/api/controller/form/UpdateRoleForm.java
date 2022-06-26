package iee.yh.hxds.mis.api.controller.form;

import io.swagger.v3.oas.annotations.media.Schema;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Schema(description = "更新角色表单")
public class UpdateRoleForm {

    @NotNull(message = "id不能为空")
    @Schema(description = "角色ID")
    private Integer id;

    @NotBlank(message = "roleName不能为空")
    @Pattern(regexp = "^[a-zA-Z0-9\\u4e00-\\u9fa5]{2,10}", message = "roleName内容不正确")
    @Schema(description = "角色名称")
    private String roleName;

    @NotEmpty(message = "permissions不能为空")
    @Schema(description = "权限")
    private Integer[] permissions;

    @Length(max = 20, message = "desc不能超过20个字符")
    @Schema(description = "简介")
    private String desc;

    @NotNull(message = "changed不能为空")
    @Schema(description = "权限是否改动了")
    private Boolean changed;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Boolean getChanged() {
        return changed;
    }

    public void setChanged(Boolean changed) {
        this.changed = changed;
    }
}