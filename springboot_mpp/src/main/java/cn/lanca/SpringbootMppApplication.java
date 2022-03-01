package cn.lanca;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.lanca.security.mapper")
public class SpringbootMppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMppApplication.class, args);
    }

}
