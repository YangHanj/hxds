package iee.yh.hxds.bff.driver.service.impl;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.map.MapUtil;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import iee.yh.common.util.R;
import iee.yh.hxds.bff.driver.controller.form.CreateDriverFaceModelForm;
import iee.yh.hxds.bff.driver.controller.form.LoginForm;
import iee.yh.hxds.bff.driver.controller.form.RegisterNewDriverForm;
import iee.yh.hxds.bff.driver.controller.form.UpdateDriverAuthForm;
import iee.yh.hxds.bff.driver.feign.DrServiceApi;
import iee.yh.hxds.bff.driver.service.DriverService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;


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

    @Override
    public int updateDriverAuth(UpdateDriverAuthForm form) {
        R r = drServiceApi.updateDriverAuth(form);
        int rows  = Convert.toInt(r.get("rows"));
        return rows;
    }

    @Override
    @Transactional
    @LcnTransaction
    public String createDriverFaceModel(CreateDriverFaceModelForm form) {
        R r = drServiceApi.createDriverFaceModel(form);
        String result = MapUtil.getStr(r, "result");
        return result;
    }

    @Override
    public HashMap login(LoginForm form) {
        R login = drServiceApi.login(form);
        HashMap result = (HashMap)login.get("result");
        return result;
    }
}
