package iee.yh.hxds.dr.db.dao;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public interface DriverDao {
    /**
     * 根据openid或者driverid查询是否存在司机记录
     * @param param
     * @return
     */
    long hasDriver(Map param);

    /**
     * 添加新的司机用户
     * @param param
     */
    int registerNewDriver(Map param);

    /**
     * 查询司机主键
     * @param openId 司机对应微信小程序的openId
     * @return
     */
    String searchDriverId(String openId);
}




