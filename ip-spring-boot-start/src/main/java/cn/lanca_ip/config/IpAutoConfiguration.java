package cn.lanca_ip.config;

import cn.lanca_ip.service.IpServiceImpl;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * project name:<font size="1"><b>小芄健康数据运营平台</b></font><br>
 * file name:<font size="1"><b>DictTemplate</b></font><br>
 * description:<font size="1"><b>平台字典数据操作实现类</b></font><br>
 * company name:<font size="1"><b>小芄医药科技（成都）有限公司-研发中心</b></font><br>
 *
 * @author <a href="mail to: ">mei.hongliang<br>
 * @version 1.0.0<br>
 * @since 2022/4/1 10:27  <br>
 */
@Configuration
@EnableConfigurationProperties(IpProperties.class) //开启自动配置
public class IpAutoConfiguration {

    @Bean
    public IpServiceImpl ipService() {
        return new IpServiceImpl();
    }

}
