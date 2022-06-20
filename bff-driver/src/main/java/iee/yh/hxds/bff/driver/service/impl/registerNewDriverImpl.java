package iee.yh.hxds.bff.driver.service.impl;

import cn.hutool.core.convert.Convert;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import iee.yh.common.util.R;
import iee.yh.hxds.bff.driver.controller.form.RegisterNewDriverForm;
import iee.yh.hxds.bff.driver.feign.DrServiceApi;
import iee.yh.hxds.bff.driver.service.DriverService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * @author yanghan
 * @date 2022/6/20
 */
@Service
public class registerNewDriverImpl implements DriverService {
    @Resource
    private DrServiceApi drServiceApi;


    @Override
    @Transactional
    @LcnTransaction
    public long registerNewDriver(RegisterNewDriverForm form) {
        R r = drServiceApi.registerNewDriver(form);
        Long userId = Convert.toLong(r.get("userId"));
        return userId;
    }
}
