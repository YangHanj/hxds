package iee.yh;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author yanghan
 * @date 2022/6/28
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@ComponentScan("iee.yh.*")
@EnableDistributedTransaction
public class BffCustomerApplication {
    public static void main(String[] args) {
        SpringApplication.run(BffCustomerApplication.class,args);
    }
}
