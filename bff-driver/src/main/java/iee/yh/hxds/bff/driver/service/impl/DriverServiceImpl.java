package iee.yh.hxds.bff.driver.service.impl;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.map.MapUtil;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import iee.yh.common.util.CosUtil;
import iee.yh.common.util.R;
import iee.yh.hxds.bff.driver.controller.form.*;
import iee.yh.hxds.bff.driver.feign.DrServiceApi;
import iee.yh.hxds.bff.driver.feign.OdrServiceApi;
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
public class DriverServiceImpl implements DriverService {
    @Resource
    private DrServiceApi drServiceApi;
    @Resource
    private OdrServiceApi odrServiceApi;


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

    @Override
    public HashMap searchDriverBaseInfo(SearchDriverBaseInfoForm form) {
        R r = drServiceApi.searchDriverBaseInfo(form);
        return (HashMap) r.get("result");
    }

    @Override
    public HashMap searchWorkbenchData(long driverId) {

        //TODO 使用completableFuture优化

        // 查询当天业务数据
        SearchDriverTodayBusinessDataForm form1 = new SearchDriverTodayBusinessDataForm();
        form1.setDriverId(driverId);
        R r = odrServiceApi.searchDriverTodayBusinessData(form1);
        HashMap business = (HashMap)r.get("result");

        // 查询司机的设置
        SearchDriverSettingsForm form2 = new SearchDriverSettingsForm();
        form2.setDriverId(driverId);
        r = drServiceApi.searchDriverSettings(form2);
        HashMap settings = (HashMap) r.get("result");
        HashMap result = new HashMap(){
            {
                put("business",business);
                put("settings",settings);
            }
        };
        return result;
    }

    @Resource
    private CosUtil cosUtil;
    @Override
    public HashMap searchDriverAuth(SearchDriverAuthForm form) {
        R r = drServiceApi.searchDriverAuth(form);
        HashMap map = (HashMap) r.get("result");
        //获取私有读写文件的临时URL地址
        String idcardFront = MapUtil.getStr(map, "idcardFront");
        String idcardBack = MapUtil.getStr(map, "idcardBack");
        String idcardHolding = MapUtil.getStr(map, "idcardHolding");
        String drcardFront = MapUtil.getStr(map, "drcardFront");
        String drcardBack = MapUtil.getStr(map, "drcardBack");
        String drcardHolding = MapUtil.getStr(map, "drcardHolding");
        String idcardFrontUrl = idcardFront.length() > 0 ? cosUtil.getPrivateFileUrl(idcardFront) : "";
        String idcardBackUrl = idcardBack.length() > 0 ? cosUtil.getPrivateFileUrl(idcardBack) : "";
        String idcardHoldingUrl = idcardHolding.length() > 0 ? cosUtil.getPrivateFileUrl(idcardHolding) : "";
        String drcardFrontUrl = drcardFront.length() > 0 ? cosUtil.getPrivateFileUrl(drcardFront) : "";
        String drcardBackUrl = drcardBack.length() > 0 ? cosUtil.getPrivateFileUrl(drcardBack) : "";
        String drcardHoldingUrl = drcardHolding.length() > 0 ? cosUtil.getPrivateFileUrl(drcardHolding) : "";

        map.put("idcardFrontUrl", idcardFrontUrl);
        map.put("idcardBackUrl", idcardBackUrl);
        map.put("idcardHoldingUrl", idcardHoldingUrl);
        map.put("drcardFrontUrl", drcardFrontUrl);
        map.put("drcardBackUrl", drcardBackUrl);
        map.put("drcardHoldingUrl", drcardHoldingUrl);
        return map;
    }
}
