package iee.yh.hxds.mis.api.controller.form;

import io.swagger.v3.oas.annotations.media.Schema;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@Schema(description = "查询部门分页表单")
public class SearchDeptByPageForm {

    @Pattern(regexp = "^[0-9a-zA-Z\\u4e00-\\u9fa5]{1,10}$", message = "deptName内容不正确")
    @Schema(description = "部门名称")
    private String deptName;

    @NotNull(message = "page不能为空")
    @Min(value = 1, message = "page不能小于1")
    @Schema(description = "页数")
    private Integer page;

    @NotNull(message = "length不能为空")
    @Range(min = 10, max = 50, message = "length必须为10~50之间")
    @Schema(description = "每页记录数")
    private Integer length;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
