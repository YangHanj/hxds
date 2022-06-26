package iee.yh;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author yanghan
 * @date 2022/6/26
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@ServletComponentScan
@MapperScan(basePackages = "iee.yh.hxds.mis.api.db.dao")
@ComponentScan("iee.yh.*")
@EnableDistributedTransaction
public class HxdsMisApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(HxdsMisApiApplication.class,args);
    }
}
