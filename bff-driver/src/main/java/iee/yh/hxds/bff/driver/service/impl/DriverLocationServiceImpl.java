package iee.yh.hxds.bff.driver.service.impl;

import iee.yh.hxds.bff.driver.controller.form.RemoveLocationCacheForm;
import iee.yh.hxds.bff.driver.controller.form.UpdateLocationCacheForm;
import iee.yh.hxds.bff.driver.feign.MpsServiceApi;
import iee.yh.hxds.bff.driver.service.DriverLocationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author yanghan
 * @date 2022/7/1
 */
@Service
public class DriverLocationServiceImpl implements DriverLocationService {
    @Resource
    private MpsServiceApi mpsServiceApi;

    @Override
    public void updateLocationCache(UpdateLocationCacheForm form) {
        mpsServiceApi.updateLocationCache(form);
    }

    @Override
    public void removeLocationCache(RemoveLocationCacheForm form) {
        mpsServiceApi.removeLocationCache(form);
    }

}
