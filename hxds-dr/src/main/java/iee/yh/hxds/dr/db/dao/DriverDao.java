package iee.yh.hxds.dr.db.dao;


import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
@Mapper
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

    /**
     * 存储司机的实名信息
     * @param param
     * @return
     */
    int updateDriverAuth(Map param);

    /**
     * 查询司机的姓名与性别
     * @param driverId
     * @return
     */
    HashMap searchDriverNameAndSex(long driverId);

    /**
     * 更新司机的在腾讯云的面部信息
     * @param driverId
     * @return
     */
    int updateDriverArchive(long driverId);

    /**
     * 利用openid查询
     * @param code
     * @return
     */
    HashMap login(String code);

    /**
     * 查询司机的总体信息
     * @param driverId
     * @return
     */
    HashMap searchDriverBaseInfo(long driverId);
}




