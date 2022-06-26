package iee.yh.hxds.mis.api.controller.form;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotEmpty;

@Schema(description = "删除部门表单")
public class DeleteDeptByIdsForm {

    @NotEmpty(message = "ids不能为空")
    @Schema(description = "部门ID")
    private Integer[] ids;

    public Integer[] getIds() {
        return ids;
    }

    public void setIds(Integer[] ids) {
        this.ids = ids;
    }
}
