package cn.lanca;

import com.dtflys.forest.springboot.annotation.ForestScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@ForestScan(basePackages = "cn.lanca.forest")
public class SpringbootYouzanApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootYouzanApplication.class, args);
    }

}
