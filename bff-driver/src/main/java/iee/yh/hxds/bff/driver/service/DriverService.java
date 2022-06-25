package iee.yh.hxds.bff.driver.service;

import iee.yh.hxds.bff.driver.controller.form.*;

import java.util.HashMap;

/**
 * @author yanghan
 * @date 2022/6/20
 */
public interface DriverService {
    /**
     * 新司机用户注册
     * @param form
     * @return
     */
    long registerNewDriver(RegisterNewDriverForm form);

    /**
     * 司机认证
     * @param form
     * @return
     */
    int updateDriverAuth(UpdateDriverAuthForm form);

    /**
     * 创建人脸模型
     * @param form
     * @return
     */
    String createDriverFaceModel(CreateDriverFaceModelForm form);

    HashMap login(LoginForm form);

    /**
     * 查询司机的总体信息
     * @param form
     * @return
     */
    HashMap searchDriverBaseInfo(SearchDriverBaseInfoForm form);

    /**
     * 司机工作台
     * @param driverId
     * @return
     */
    HashMap searchWorkbenchData(long driverId);
}
