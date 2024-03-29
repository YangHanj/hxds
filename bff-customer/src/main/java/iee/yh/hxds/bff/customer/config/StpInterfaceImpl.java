package iee.yh.hxds.bff.customer.config;

import cn.dev33.satoken.stp.StpInterface;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yanghan
 * @date 2022/6/28
 */
@Component
public class StpInterfaceImpl implements StpInterface {

    /**
     * 返回某个用户所拥有的权限集合
     */
    @Override
    public List<String> getPermissionList(Object loginId, String loginKey) {
        //因为本项目不需要用到权限判定，所以这里就返回一个空的ArrayList对象
        ArrayList<String> list = new ArrayList<String>();
        return list;
    }

    /**
     * 返回某个用户所拥有的角色标识集合
     */
    @Override
    public List<String> getRoleList(Object loginId, String loginKey) {
        //因为本项目不需要用到角色判定，所以这里就返回一个空的ArrayList对象
        ArrayList<String> list = new ArrayList<String>();
        return list;
    }

}
