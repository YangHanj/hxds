package iee.yh.hxds.bff.driver.service;

import iee.yh.hxds.bff.driver.controller.form.RemoveLocationCacheForm;
import iee.yh.hxds.bff.driver.controller.form.UpdateLocationCacheForm;

/**
 * @author yanghan
 * @date 2022/7/1
 */
public interface DriverLocationService {

    void updateLocationCache(UpdateLocationCacheForm form);

    void removeLocationCache(RemoveLocationCacheForm form);

}
