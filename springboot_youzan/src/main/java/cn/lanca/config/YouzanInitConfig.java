package cn.lanca.config;

import com.youzan.cloud.open.sdk.common.exception.SDKException;
import com.youzan.cloud.open.sdk.core.client.core.YouZanClient;
import com.youzan.cloud.open.sdk.core.oauth.model.OAuthToken;
import com.youzan.cloud.open.sdk.core.oauth.token.TokenParameter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.ObjectUtils;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

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

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private YouZanClient youZanClient;

    /**
     * +@Component 一起使用
     */
    @PostConstruct
    public void init() {
        OAuthToken oAuthToken = null;
        try {
            TokenParameter parameter = TokenParameter.self()
                    .clientId(YouzanProperties.CLIENT_ID)
                    .clientSecret(YouzanProperties.CLIENT_SECRET)
                    .grantId(YouzanProperties.GRANT_ID)
                    .build();
            oAuthToken = youZanClient.getOAuthToken(parameter);
        } catch (SDKException e) {
            e.printStackTrace();
            log.info(e.getMessage());
        }
        if (!ObjectUtils.isEmpty(oAuthToken)) {
            // 授权令牌
            String youzanToken = oAuthToken.getAccessToken();
            try {
                redisTemplate.opsForValue().set("youzanToken_" + YouzanProperties.GRANT_ID, youzanToken, 2, TimeUnit.HOURS);
                log.info("redis存入youzanToken={}", youzanToken);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
