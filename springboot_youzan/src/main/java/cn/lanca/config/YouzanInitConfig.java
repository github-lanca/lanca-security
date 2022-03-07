package cn.lanca.config;

import cn.lanca.forest.GetToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.PostConstruct;

/**
 * project name:<font size="1"><b>小芄健康数据运营平台</b></font><br>
 * file name:<font size="1"><b>DictTemplate</b></font><br>
 * description:<font size="1"><b>平台字典数据操作实现类</b></font><br>
 * company name:<font size="1"><b>小芄医药科技（成都）有限公司-研发中心</b></font><br>
 *
 * @author <a href="mail to: ">mei.hongliang<br>
 * @version 1.0.0<br>
 * @since 2022/3/7 09:59  <br>
 */
@Slf4j
@Configuration
public class YouzanInitConfig {
    //172.27.16.11:43900/get-youzan-token?grantId=102631073
    //ff28cd748cf7bae04c3a10abf7796ee
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private GetToken getToken;

    /**
     * +@Component 一起使用
     */
    @PostConstruct
    public void init() {
        //
        String grantId = "102631073";
        String youzanToken = getToken.getYouzanToken(grantId);
        try {
            redisTemplate.opsForValue().set("youzanToken_" + grantId, youzanToken);
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("redis存入youzanToken={}", youzanToken);

    }


}
