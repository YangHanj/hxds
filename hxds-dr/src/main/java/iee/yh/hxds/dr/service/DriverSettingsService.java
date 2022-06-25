package iee.yh.hxds.dr.service;

import java.util.HashMap;

/**
 * @author yanghan
 * @date 2022/6/25
 */
public interface DriverSettingsService {

    /**
     * 查询司机设定
     * @param driverId
     * @return
     */
    HashMap searchDriverSettings(long driverId);
}
