package iee.yh.hxds.mis.api.config;

import cn.dev33.satoken.stp.StpInterface;
import iee.yh.hxds.mis.api.controller.UserController;
import iee.yh.hxds.mis.api.db.dao.UserDao;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author yanghan
 * @date 2022/6/26
 */
@Configuration
public class StpInterfaceImpl implements StpInterface {
    @Resource
    private UserDao userDao;

    /**
     * 用户权限查询
     * @param loginId
     * @param loginType
     * @return
     */
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        int userId = Integer.parseInt(loginId.toString());
        // userId用户对应的权限
        Set<String> set = userDao.searchUserPermissions(userId);
        ArrayList list = new ArrayList();
        list.addAll(set);
        return list;
    }

    /**
     * 用户角色
     * @param loginId
     * @param loginType
     * @return
     */
    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        //因为本项目不需要用到角色判定，所以这里就返回一个空的ArrayList对象
        ArrayList<String> list = new ArrayList<String>();
        return list;
    }
}
