package cn.lanca_ip;

import cn.lanca_ip.service.IpServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class IpSpringBootStartApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(IpSpringBootStartApplication.class, args);
        IpServiceImpl ipServiceImpl = context.getBean("ipServiceImpl", IpServiceImpl.class);
        ipServiceImpl.printIp();
    }

}
