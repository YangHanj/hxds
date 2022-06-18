package iee.yh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author yanghan
 * @date 2022/6/18
 */
@SpringBootApplication
@EnableTransactionManagement
public class HxdsTmApplication {
    public static void main(String[] args) {
        SpringApplication.run(HxdsTmApplication.class,args);
    }
}
