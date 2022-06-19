package iee.yh.hxds.dr.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

/**
 * @author yanghan
 * @date 2022/6/18
 */
@OpenAPIDefinition(
        info = @Info(
                title = "hxds-dr",
                description = "司机子系统",
                version = "1.0"
        )
)
@Configuration
public class SpringDocConfig {
}
