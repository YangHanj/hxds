package iee.yh.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 抽取出来的公共类
 * 无需启动运行，保留主启动类为了方便后期打包
 * @author yanghan
 * @date 2022/6/18
 */
@SpringBootApplication
public class CommonApplication {
    public static void main(String[] args) {
        SpringApplication.run(CommonApplication.class,args);
    }
}
