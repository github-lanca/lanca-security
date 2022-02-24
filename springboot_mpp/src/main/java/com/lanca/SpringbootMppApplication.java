package com.lanca;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("mapper")
public class SpringbootMppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMppApplication.class, args);
    }

}
