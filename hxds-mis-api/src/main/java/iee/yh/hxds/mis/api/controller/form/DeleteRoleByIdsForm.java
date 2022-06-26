package iee.yh.hxds.mis.api.controller.form;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotEmpty;
@Schema(description = "删除角色表单")
public class DeleteRoleByIdsForm {
    public Integer[] getIds() {
        return ids;
    }

    public void setIds(Integer[] ids) {
        this.ids = ids;
    }

    @NotEmpty(message = "ids不能为空")
    @Schema(description = "角色ID")
    private Integer[] ids;
}

