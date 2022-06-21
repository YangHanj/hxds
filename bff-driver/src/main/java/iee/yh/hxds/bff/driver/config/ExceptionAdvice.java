package iee.yh.hxds.bff.driver.config;

import cn.dev33.satoken.exception.NotLoginException;
import cn.hutool.json.JSONObject;
import iee.yh.common.exception.HxdsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * 统一的异常捕获
 * @author yanghan
 * @date 2022/6/18
 */
@RestControllerAdvice
public class ExceptionAdvice {
    private Logger logger = LoggerFactory.getLogger(ExceptionAdvice.class);
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public String exceptionHandler(Exception e){
        JSONObject json = new JSONObject();
        // 处理后端验证失败异常
        if (e instanceof MethodArgumentNotValidException){
            MethodArgumentNotValidException exception = (MethodArgumentNotValidException) e;
            json.set("error",exception.getBindingResult().getFieldError().getDefaultMessage());
        }
        // HTTP请求类型不正确异常
        else if (e instanceof HttpRequestMethodNotSupportedException){
            json.set("error","Web方法不支持当前请求类型");
        }
        // 缺少必须提交的表单数据
        else if (e instanceof HttpMessageNotReadableException){
            json.set("error","缺少提交的数据");
        }
        // 处理业务异常
        else if (e instanceof HxdsException){
            logger.error("执行异常",e.getMessage());
            HxdsException exception = (HxdsException) e;
            json.set("error",exception.getMsg());
        }
        // 处理其他异常
        else {
            logger.error("执行异常",e.getMessage());
            json.set("error","执行异常");
        }
        return json.toString();
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(NotLoginException.class)
    public String unLoginHandler(Exception e){
        JSONObject json = new JSONObject();
        json.set("error",e.getMessage());
        return json.toString();
    }
}
