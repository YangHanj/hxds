package iee.yh;

import com.codingapi.txlcn.tm.config.EnableTransactionManagerServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author yanghan
 * @date 2022/6/18
 */
@SpringBootApplication
@EnableTransactionManagerServer
public class HxdsTmApplication {
    public static void main(String[] args) {
        SpringApplication.run(HxdsTmApplication.class,args);
    }
}
