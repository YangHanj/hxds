package iee.yh.hxds.bff.driver.config;

import cn.dev33.satoken.stp.StpInterface;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 在司机端的bff中不需要判断权限角色，所有司机的权限角色都一样
 * @author yanghan
 * @date 2022/6/19
 */
@Component
public class StpInterfaceImpl implements StpInterface {

    /**
     * 返回某个用户所拥有的权限集合
     * @param o
     * @param s
     * @return
     */
    @Override
    public List<String> getPermissionList(Object o, String s) {
        return null;
    }

    /**
     * 返回某个用户所拥有的角色标识集合
     * @param o
     * @param s
     * @return
     */
    @Override
    public List<String> getRoleList(Object o, String s) {
        return null;
    }
}
