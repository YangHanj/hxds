package iee.yh;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author yanghan
 * @date 2022/6/18
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@ServletComponentScan
@MapperScan("iee.yh.hxds.cst.db.dao")
@ComponentScan("iee.yh.*")
@EnableDistributedTransaction
public class HxdsCstApplication {
    public static void main(String[] args) {
        SpringApplication.run(HxdsCstApplication.class,args);
    }
}
