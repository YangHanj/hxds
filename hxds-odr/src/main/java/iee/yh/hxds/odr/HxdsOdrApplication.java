package iee.yh.hxds.odr;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author yanghan
 * @date 2022/6/25
 */
@EnableFeignClients
@EnableDiscoveryClient
@ServletComponentScan
@EnableDistributedTransaction
@SpringBootApplication
@MapperScan("iee.yh.hxds.odr.db.dao")
@ComponentScan("iee.yh.*")
public class HxdsOdrApplication {
    public static void main(String[] args) {
        SpringApplication.run(HxdsOdrApplication.class,args);
    }
}
