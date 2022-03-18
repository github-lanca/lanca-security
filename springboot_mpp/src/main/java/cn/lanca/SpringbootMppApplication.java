package cn.lanca;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling // 开启定时任务功能
@SpringBootApplication
@MapperScan({"cn.lanca.security.mapper","cn.lanca.schedule.mapper"})
public class SpringbootMppApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SpringbootMppApplication.class, args);
        System.out.println(run);
    }

}
