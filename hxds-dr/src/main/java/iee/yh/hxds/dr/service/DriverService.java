package iee.yh.hxds.dr.service;

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
}
