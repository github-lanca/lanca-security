package cn.lanca_ip.service;

import cn.lanca_ip.config.IpProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 具体的实现/功能方法
 *
 * @author <a href="mail to: ">mei.hongliang<br>
 * @version 1.0.0<br>
 * @since 2022/4/1 10:20  <br>
 */
@Service
public class IpServiceImpl {

    @Autowired
    private IpProperties ipProperties;

    /**
     * 具体的实现/功能方法
     */
    public void printIp() {
        System.out.println("+---------我是自定义Start模块中的方法----------------+");
        System.out.println(ipProperties);
    }
}
