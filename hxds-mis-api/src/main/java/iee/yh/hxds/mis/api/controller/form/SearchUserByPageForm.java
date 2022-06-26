package iee.yh.hxds.mis.api.controller.form;

import io.swagger.v3.oas.annotations.media.Schema;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Schema(description = "查询用户分页记录表单")
public class SearchUserByPageForm {
    @NotNull(message = "page不能为空")
    @Min(value = 1, message = "page不能小于1")
    @Schema(description = "页数")
    private Integer page;

    @NotNull(message = "length不能为空")
    @Range(min = 10, max = 50, message = "length必须在10~50之间")
    @Schema(description = "每页记录数")
    private Integer length;

    @Pattern(regexp = "^[\\u4e00-\\u9fa5]{1,10}$", message = "name内容不正确")
    @Schema(description = "姓名")
    private String name;

    @Pattern(regexp = "^男$|^女$", message = "sex内容不正确")
    @Schema(description = "性别")
    private String sex;

    @Pattern(regexp = "^[a-zA-Z0-9\\u4e00-\\u9fa5]{2,10}$", message = "role内容不正确")
    @Schema(description = "角色")
    private String role;

    @Min(value = 1, message = "dept不能小于1")
    private Integer deptId;

    @Min(value = 1, message = "status不能小于1")
    private Integer status;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
