package iee.yh;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;


/**
 *  =========================================== <br/>
 * ｜ @EnableDiscoveryClient        ｜ 注册nacos      ｜<br/>
 * ｜ @ServletComponentScan         ｜ 解决web异常     ｜<br/>
 * ｜ @EnableDistributedTransaction ｜ 子系统分布式事务 ｜<br/>
 *  =========================================== <br/>
 * @author yanghan
 * @date 2022/6/18
 */
@SpringBootApplication
@EnableDiscoveryClient
@ServletComponentScan
@ComponentScan("iee.yh.*")
@EnableDistributedTransaction
@EnableFeignClients
public class HxdsDrApplication {
    public static void main(String[] args) {
        SpringApplication.run(HxdsDrApplication.class,args);
    }
}
