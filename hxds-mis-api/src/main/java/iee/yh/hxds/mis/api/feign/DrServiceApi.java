package iee.yh.hxds.mis.api.feign;

import iee.yh.common.util.R;
import iee.yh.hxds.mis.api.controller.form.SearchDriverByPageForm;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;


/**
 * @author yanghan
 * @date 2022/6/26
 */
@FeignClient(value = "hxds-dr")
public interface DrServiceApi {

    @PostMapping("/driver/searchDriverByPage")
    R searchDriverByPage(SearchDriverByPageForm form);
}
