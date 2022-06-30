package iee.yh.hxds.bff.customer.service.impl;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.StrUtil;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import iee.yh.common.util.R;
import iee.yh.hxds.bff.customer.controller.form.*;
import iee.yh.hxds.bff.customer.feign.CstServiceApi;
import iee.yh.hxds.bff.customer.service.CustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author yanghan
 * @date 2022/6/29
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    @Resource
    private CstServiceApi cstServiceApi;

    @Override
    @Transactional
    @LcnTransaction
    public long registerNewCustomer(RegisterNewCustomerForm form) {
        R r = cstServiceApi.registerNewCustomer(form);
        long userId = Convert.toLong(r.get("userId"));
        return userId;
    }

    @Override
    public Long login(LoginForm form) {
        R r = cstServiceApi.login(form);
        String userId = MapUtil.getStr(r, "userId");
        if (!StrUtil.isBlank(userId)) {
            return Convert.toLong(userId);
        }
        return null;
    }


}
