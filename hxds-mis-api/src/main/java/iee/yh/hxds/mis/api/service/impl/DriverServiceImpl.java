package iee.yh.hxds.mis.api.service.impl;

import cn.hutool.core.bean.BeanUtil;
import iee.yh.common.util.PageUtils;
import iee.yh.common.util.R;
import iee.yh.hxds.mis.api.controller.form.SearchDriverByPageForm;
import iee.yh.hxds.mis.api.feign.DrServiceApi;
import iee.yh.hxds.mis.api.service.DriverService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @author yanghan
 * @date 2022/6/26
 */
@Service
public class DriverServiceImpl implements DriverService {
    @Resource
    private DrServiceApi drServiceApi;
    @Override
    public PageUtils searchDriverByPage(SearchDriverByPageForm form) {
        R r = drServiceApi.searchDriverByPage(form);
        HashMap result = (HashMap) r.get("result");
        PageUtils pageUtils = BeanUtil.toBean(result, PageUtils.class);
        return pageUtils;
    }
}
