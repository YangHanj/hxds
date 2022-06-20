package iee.yh.hxds.bff.driver.service;

import iee.yh.hxds.bff.driver.controller.form.RegisterNewDriverForm;

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
}
