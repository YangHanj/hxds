package iee.yh.hxds.snm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author yanghan
 * @date 2022/7/1
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableAsync
@ComponentScan("iee.yh.*")
public class HxdsSnmApplication {
    public static void main(String[] args) {
        SpringApplication.run(HxdsSnmApplication.class,args);
    }
}
