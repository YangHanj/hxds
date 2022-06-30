package iee.yh.hxds.mps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author yanghan
 * @date 2022/6/29
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@ComponentScan("iee.yh.*")
public class HxdsMapsApplication {
    public static void main(String[] args) {
        SpringApplication.run(HxdsMapsApplication.class,args);
    }
}
