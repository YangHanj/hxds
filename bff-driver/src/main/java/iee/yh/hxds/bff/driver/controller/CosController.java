package iee.yh.hxds.bff.driver.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import iee.yh.common.exception.HxdsException;
import iee.yh.common.util.CosUtil;
import iee.yh.common.util.R;
import iee.yh.hxds.bff.driver.controller.form.DeleteCosFileForm;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.HashMap;

/**
 * 用于向COS传输文件的web层接口
 * @author yanghan
 * @date 2022/6/22
 */
@RestController
@RequestMapping("/cos")
@Tag(name = "CosController",description = "对象存储Web接口")
public class CosController {

    private Logger logger = LoggerFactory.getLogger(CosController.class);

    @Resource
    public CosUtil cosUtil;

    @PostMapping("/uploadCosPublicFile")
    @SaCheckLogin
    @Operation(summary = "上传公有文件")
    public R uploadCosPublicFile(@Param("file")MultipartFile file,@Param("moudle") @NotEmpty String module){
        if (file.isEmpty()){
            throw new HxdsException("上传文件不能为空");
        }
        try{
            String path = null;
            HashMap map = cosUtil.uploadPublicFile(file, path);
            return R.ok(map);
        }catch (Exception e){
            logger.error("文件上传腾讯云出错",e);
            throw new HxdsException("文件上传腾讯云出错");
        }
    }


    private String DRIVER_AUTH = "driverAuth";
    private String DRIVER_AUTH_APTH = "/driver/auth";
    @PostMapping("/uploadCosPrivateFile")
    @SaCheckLogin
    @Operation(summary = "上传私有文件")
    public R uploadCosPrivateFile(@Param("file")MultipartFile file,@Param("moudle") @NotEmpty String module){
        if (file.isEmpty()){
            throw new HxdsException("上传文件不能为空");
        }
        try{
            String path = null;
            if (module.equals(DRIVER_AUTH)){
                path = DRIVER_AUTH_APTH;
            }else throw new HxdsException("module错误");
            HashMap map = cosUtil.uploadPublicFile(file, path);
            return R.ok(map);
        }catch (Exception e){
            logger.error("文件上传腾讯云出错",e);
            throw new HxdsException("文件上传腾讯云出错");
        }
    }

    @PostMapping("/deleteCosPublicFile")
    @SaCheckLogin
    @Operation(summary = "删除公有文件")
    public R deleteCosPublicFile(@Valid @RequestBody DeleteCosFileForm form){
        cosUtil.deletePrivateFile(form.getPathes());
        return R.ok();
    }


    @PostMapping("/deleteCosPrivateFile")
    @SaCheckLogin
    @Operation(summary = "删除私有文件")
    public R deleteCosPrivateFile(@Valid @RequestBody DeleteCosFileForm form){
        cosUtil.deletePrivateFile(form.getPathes());
        return R.ok();
    }

}
