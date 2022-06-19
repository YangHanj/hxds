package iee.yh.hxds.bff.driver.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

/**
 * @author yanghan
 * @date 2022/6/19
 */
@OpenAPIDefinition(
        info = @Info(
                title = "bff-driver",
                description = "司机端BFF",
                version = "1.0"
        ),
        security = @SecurityRequirement(name = "token")
)
@SecurityScheme(
        name = "token",
        type = SecuritySchemeType.APIKEY,
        in = SecuritySchemeIn.HEADER,
        bearerFormat = "JWT",
        scheme = "bearer"
)
@Configuration
public class SpringDocConfig {
}
