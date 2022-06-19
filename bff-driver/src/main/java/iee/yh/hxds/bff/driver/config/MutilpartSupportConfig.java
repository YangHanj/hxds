package iee.yh.hxds.bff.driver.config;

import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 该类用于Feign调用传输文件
 * @author yanghan
 * @date 2022/6/19
 */
@Configuration
public class MutilpartSupportConfig {
    @Autowired
    private ObjectFactory<HttpMessageConverters> messageConverters;
    @Bean
    public Encoder feginFormEncoder(){
        return new SpringFormEncoder(new SpringEncoder(messageConverters));
    }

}
