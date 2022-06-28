package iee.yh.hxds.mis.api.service;

import iee.yh.common.util.PageUtils;
import iee.yh.hxds.mis.api.controller.form.SearchDriverByPageForm;
import iee.yh.hxds.mis.api.controller.form.UpdateDriverRealAuthForm;

import java.util.HashMap;

/**
 * @author yanghan
 * @date 2022/6/26
 */
public interface DriverService {
    /**
     * 按照条件分页查询司机信息
     * @param form
     * @return
     */
    PageUtils searchDriverByPage(SearchDriverByPageForm form);

    HashMap searchDriverComprehensiveData(byte realAuth,Long driverId);

    /**
     * 修改认证信息
     * @param form
     * @return
     */
    int updateDriverRealAuth(UpdateDriverRealAuthForm form);
}
