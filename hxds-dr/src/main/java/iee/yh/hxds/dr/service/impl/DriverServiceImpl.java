package iee.yh.hxds.dr.service.impl;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.iai.v20200303.IaiClient;
import com.tencentcloudapi.iai.v20200303.models.CreatePersonRequest;
import com.tencentcloudapi.iai.v20200303.models.CreatePersonResponse;
import iee.yh.common.exception.HxdsException;
import iee.yh.common.util.MicroAppUtil;
import iee.yh.common.util.PageUtils;
import iee.yh.hxds.dr.db.dao.DriverDao;
import iee.yh.hxds.dr.db.dao.DriverSettingsDao;
import iee.yh.hxds.dr.db.dao.WalletDao;
import iee.yh.hxds.dr.db.pojo.DriverSettingsEntity;
import iee.yh.hxds.dr.db.pojo.WalletEntity;
import iee.yh.hxds.dr.service.DriverService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yanghan
 * @date 2022/6/19
 */
@Service
public class DriverServiceImpl implements DriverService {

    private Logger logger = LoggerFactory.getLogger(DriverServiceImpl.class);

    @Resource
    private MicroAppUtil microAppUtil;
    @Resource
    private DriverDao driverDao;
    @Resource
    private DriverSettingsDao settingsDao;
    @Resource
    private WalletDao walletDao;

    @Value("${tencent.cloud.secretId}")
    private String secretId;
    @Value("${tencent.cloud.secretKey}")
    private String secretKey;
    @Value("${tencent.cloud.face.groupName}")
    private String groupName;
    @Value("${tencent.cloud.face.region}")
    private String region;

    /**
     * 司机注册
     * @param param
     * @return
     */
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

    /**
     * 司机实名
     * @param param
     * @return
     */
    @Override
    @Transactional
    @LcnTransaction
    public int updateDriverAuth(Map param) {
        return driverDao.updateDriverAuth(param);
    }

    @Override
    @Transactional
    @LcnTransaction
    public String createDriverFaceModel(long driverId, String photo) {
        // 查询员工的姓名与性别
        HashMap map = driverDao.searchDriverNameAndSex(driverId);
        String name = MapUtil.getStr(map,"name");
        String sex = MapUtil.getStr(map,"sex");

        // 创建腾讯云司机面部档案
        Credential cred = new Credential(secretId,secretKey);
        IaiClient client = new IaiClient(cred, region);
        try{
            CreatePersonRequest req = new CreatePersonRequest();
            req.setGroupId(groupName);   //人员库ID
            req.setPersonId(driverId + "");   //人员ID
            long gender = sex.equals("男") ? 1L : 2L;
            req.setGender(gender);
            req.setQualityControl(4L);   //照片质量等级
            req.setUniquePersonControl(4L);   //重复人员识别等级
            req.setPersonName(name);   //姓名
            req.setImage(photo);   //base64图片
            CreatePersonResponse resp = client.CreatePerson(req);
            if (StrUtil.isNotBlank(resp.getFaceId())) {
                //更新司机表的archive字段值
                int rows = driverDao.updateDriverArchive(driverId);
                if (rows != 1) {
                    return "更新司机归档字段失败";
                }
            }
        }catch (TencentCloudSDKException e){
            logger.error("创建腾讯云端司机档案失败",e);
            return "创建腾讯云端司机档案失败";
        }
        return "";
    }

    @Override
    public HashMap login(String code) {
        // 利用临时授权码获取永久openid
        String openId = microAppUtil.getOpenId(code);
        // 查询登录信息
        HashMap login = driverDao.login(openId);
        // 如果存在面部信息，则进行结果转译
        if (login != null && login.containsKey("archive")){
            int temp = MapUtil.getInt(login, "archive");
            boolean archive = temp == 1 ? true : false;
            login.replace("archive",archive);
        }
        return login;
    }

    @Override
    public HashMap searchDriverBaseInfo(long driverId) {
        HashMap map = driverDao.searchDriverBaseInfo(driverId);
        JSONObject summary = JSONUtil.parseObj(MapUtil.getStr(map, "summary"));
        map.replace("summary",summary);
        return map;
    }

    @Override
    public PageUtils searchDriverByPage(Map param) {
        long count = driverDao.searchDriverCount(param);
        ArrayList<HashMap> list = null;
        if (count == 0) {
            list = new ArrayList<>();
        } else {
            list = driverDao.searchDriverByPage(param);
        }
        int start = (Integer) param.get("start");
        int length = (Integer) param.get("length");
        PageUtils pageUtils = new PageUtils(count, length, start, list);
        return pageUtils;
    }
}
