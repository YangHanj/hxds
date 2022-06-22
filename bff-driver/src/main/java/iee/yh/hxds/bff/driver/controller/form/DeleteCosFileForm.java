package iee.yh.hxds.bff.driver.controller.form;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotEmpty;

/**
 * @author yanghan
 * @date 2022/6/22
 */
@Schema(description = "删除腾讯云COS文件表单")
public class DeleteCosFileForm {
    @NotEmpty(message = "pathes不能为空")
    @Schema(description = "云文件路径数组")
    private String[] pathes;

    public String[] getPathes() {
        return pathes;
    }

    public void setPathes(String[] pathes) {
        this.pathes = pathes;
    }
}
