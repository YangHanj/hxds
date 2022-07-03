package iee.yh.hxds.snm.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

/**
 * @author yanghan
 * @date 2022/6/25
 */
@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "hxds-odr",
                description = "订单子系统",
                version = "1.0"
        )
)
public class SpringDocConfig {
}
