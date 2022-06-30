package iee.yh.hxds.cst.service.impl;

import cn.hutool.core.map.MapUtil;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import iee.yh.common.exception.HxdsException;
import iee.yh.common.util.MicroAppUtil;
import iee.yh.hxds.cst.db.dao.CustomerDao;
import iee.yh.hxds.cst.service.CustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yanghan
 * @date 2022/6/29
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    @Resource
    private CustomerDao customerDao;

    @Resource
    private MicroAppUtil microAppUtil;

    @Override
    @Transactional
    @LcnTransaction
    public String registerNewCustomer(Map param) {
        String code = MapUtil.getStr(param, "code");
        String openId = microAppUtil.getOpenId(code);
        HashMap tempParam = new HashMap() {{
            put("openId", openId);
        }};
        if (customerDao.hasCustomer(tempParam) != 0) {
            throw new HxdsException("该微信无法注册");
        }

        param.put("openId", openId);
        customerDao.registerNewCustomer(param);
        String customerId = customerDao.searchCustomerId(openId);
        return customerId;
    }

    @Override
    public String login(String openId) {
        String openId1 = microAppUtil.getOpenId(openId);
        String login = customerDao.login(openId1);
        login = (login != null ? login : "");
        return login;
    }
}
