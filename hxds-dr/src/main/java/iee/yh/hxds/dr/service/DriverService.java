package iee.yh.hxds.dr.service;

import iee.yh.common.util.PageUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yanghan
 * @date 2022/6/19
 */
public interface DriverService {
    /**
     * 司机注册
     * @param param
     * @return
     */
    String registerNewDriver(Map param);

    /**
     * 存储司机的实名信息
     * @param param
     * @return
     */
    int updateDriverAuth(Map param);

    /**
     * 创建人脸模型
     * @param driverId 司机Id
     * @param photo 照片
     * @return
     */
    String createDriverFaceModel(long driverId,String photo);

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

    /**
     * 分页查询司机信息
     * @param param
     * @return
     */
    PageUtils searchDriverByPage(Map param);

    /**
     * 查询司机的认证信息（用于司机修改认证信息）
     * @param deiverId
     * @return
     */
    HashMap searchDriverAuth(long deiverId);

    /**
     * 查询司机上传的证件信息
     * @param driverId
     * @return
     */
    HashMap searchDriverRealSummary(long driverId);

    /**
     * 修改审核信息
     * @param parm
     * @return
     */
    int updateDriverRealAuth(Map parm);
}
