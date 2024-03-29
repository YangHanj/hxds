package iee.yh.common.util;

import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回值处理类
 * @author yanghan
 * @date 2022/6/18
 */
public class R extends HashMap<String,Object> {
    private R() {
        put("code", HttpStatus.SC_OK);
        put("msg","success");
    }

    @Override
    public R put(String key, Object value){
        super.put(key,value);
        return this;
    }

    public static R ok(){
        return new R();
    }

    public static R ok(String msg){
        R r = new R();
        r.put("msg",msg);
        return r;
    }

    public static R ok(Map<String,Object> map){
        R r = new R();
        r.putAll(map);
        return r;
    }

    public static R error(int code, String msg){
        R r = new R();
        r.put("code",code);
        r.put("msg",msg);
        return r;
    }

    public static R error(String msg){
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR,msg);
    }

    public static R error(){
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR,"未知异常，请联系管理员");
    }
}
