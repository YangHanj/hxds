package iee.yh;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author yanghan
 * @date 2022/6/19
 */
@SpringBootApplication
@EnableDistributedTransaction
@EnableDiscoveryClient
@EnableFeignClients
@ComponentScan("iee.yh.*")
public class BffDriverApplication {
    public static void main(String[] args) {
        SpringApplication.run(BffDriverApplication.class,args);
    }
}
