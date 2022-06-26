package iee.yh.hxds.mis.api.config;

import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author yanghan
 * @date 2022/6/26
 */
@Configuration
public class MultipartSupportConfig {
    @Autowired
    private ObjectFactory<HttpMessageConverters> messageConverters;
    @Bean
    public Encoder figenFormEncoder(){
        return new SpringFormEncoder(new SpringEncoder(messageConverters));
    }
}
