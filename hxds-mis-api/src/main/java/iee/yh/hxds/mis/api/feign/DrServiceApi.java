package iee.yh.hxds.mis.api.feign;

import iee.yh.common.util.R;
import iee.yh.hxds.mis.api.controller.form.SearchDriverByPageForm;
import iee.yh.hxds.mis.api.controller.form.SearchDriverRealSummaryForm;
import iee.yh.hxds.mis.api.controller.form.UpdateDriverRealAuthForm;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;


/**
 * @author yanghan
 * @date 2022/6/26
 */
@FeignClient(value = "hxds-dr")
public interface DrServiceApi {

    @PostMapping("/driver/searchDriverByPage")
    R searchDriverByPage(SearchDriverByPageForm form);

    @PostMapping("/driver/searchDriverRealSummary")
    R searchDriverRealSummary(SearchDriverRealSummaryForm form);

    @PostMapping("/driver/updateDriverRealAuth")
    public R updateDriverRealAuth(UpdateDriverRealAuthForm form);
}
