package iee.yh.common.exception;

/**
 * 全局异常类
 * @author yanghan
 * @date 2022/6/18
 */
public class HxdsException extends RuntimeException {
    private String msg;
    private int code = 500;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public HxdsException(String msg){
        super(msg);
        this.msg = msg;
    }

    public HxdsException(String msg, int code){
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public HxdsException(String msg, int code, Throwable e){
        super(msg,e);
        this.msg = msg;
        this.code = code;
    }
}
