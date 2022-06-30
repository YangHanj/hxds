package iee.yh.hxds.cst.service;

import java.util.Map;

/**
 * @author yanghan
 * @date 2022/6/29
 */
public interface CustomerService {

    String registerNewCustomer(Map param);

    /**
     * 登录
     * @param openId
     * @return
     */
    String login(String openId);
}
