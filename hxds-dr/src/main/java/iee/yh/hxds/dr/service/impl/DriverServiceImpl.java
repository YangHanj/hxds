package iee.yh.hxds.dr.service.impl;

import cn.hutool.core.map.MapUtil;
import cn.hutool.json.JSONObject;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import iee.yh.common.exception.HxdsException;
import iee.yh.common.util.MicroAppUtil;
import iee.yh.hxds.dr.db.dao.DriverDao;
import iee.yh.hxds.dr.db.dao.DriverSettingsDao;
import iee.yh.hxds.dr.db.dao.WalletDao;
import iee.yh.hxds.dr.db.pojo.DriverSettingsEntity;
import iee.yh.hxds.dr.db.pojo.WalletEntity;
import iee.yh.hxds.dr.service.DriverService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yanghan
 * @date 2022/6/19
 */
@Service
public class DriverServiceImpl implements DriverService {
    @Resource
    private MicroAppUtil microAppUtil;
    @Resource
    private DriverDao driverDao;
    @Resource
    private DriverSettingsDao settingsDao;
    @Resource
    private WalletDao walletDao;

    @Transactional
    @LcnTransaction
    @Override
    public String registerNewDriver(Map param) {
        // 使用临时授权码获取永久授权码OpenID
        String code = MapUtil.getStr(param, "code");
        String openId = microAppUtil.getOpenId(code);
        // 查询司机是否存在
        HashMap tempParam = new HashMap(){
            {put("openId",openId);}
        };
        if (driverDao.hasDriver(tempParam) != 0){
            throw new HxdsException("该微信已经注册，无需重复注册!");
        }
        param.put("openId",openId);
        driverDao.registerNewDriver(param);
        // 获取主键
        String driverId = driverDao.searchDriverId(openId);
        // 构建司机设定表的pojo
        DriverSettingsEntity settingsEntity = new DriverSettingsEntity();
        settingsEntity.setDriverId(Long.parseLong(driverId));
        JSONObject jsonObject = new JSONObject();
        jsonObject.set("orientation","");
        jsonObject.set("listenService",true);
        jsonObject.set("orderDistance",0);
        jsonObject.set("rangeDistance",5);
        jsonObject.set("autoAccpet",false);
        settingsEntity.setSettings(jsonObject.toString());
        settingsDao.insertDriverSettings(settingsEntity);
        // 构建钱包表pojo
        WalletEntity walletEntity = new WalletEntity();
        walletEntity.setDriverId(Long.parseLong(driverId));
        walletEntity.setBalance(new BigDecimal("0"));
        walletEntity.setPassword(null); // 初始密码为空
        walletDao.insert(walletEntity);

        return driverId;
    }
}
