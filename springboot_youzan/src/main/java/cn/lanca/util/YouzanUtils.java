package cn.lanca.util;

import cn.lanca.config.YouzanProperties;
import cn.lanca.vo.base.AjaxResult;
import com.youzan.cloud.open.sdk.common.exception.SDKException;
import com.youzan.cloud.open.sdk.core.client.auth.Token;
import com.youzan.cloud.open.sdk.core.client.core.YouZanClient;
import com.youzan.cloud.open.sdk.gen.v3_0_0.api.YouzanRegionsGet;
import com.youzan.cloud.open.sdk.gen.v3_0_0.model.YouzanRegionsGetParams;
import com.youzan.cloud.open.sdk.gen.v3_0_0.model.YouzanRegionsGetResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

/**
 * project name:<font size="1"><b>小芄健康数据运营平台</b></font><br>
 * file name:<font size="1"><b>DictTemplate</b></font><br>
 * description:<font size="1"><b>平台字典数据操作实现类</b></font><br>
 * company name:<font size="1"><b>小芄医药科技（成都）有限公司-研发中心</b></font><br>
 *
 * @author <a href="mail to: ">mei.hongliang<br>
 * @version 1.0.0<br>
 * @since 2022/3/7 16:35  <br>
 */
@Component
@Slf4j
public class YouzanUtils {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private YouZanClient youZanClient;

    public Token getToken() {
        Token youzanToken = null;
        Object o = redisTemplate.opsForValue().get("youzanToken_" + YouzanProperties.GRANT_ID);
        if (!ObjectUtils.isEmpty(o)) {
            youzanToken = new Token(o.toString());
        }
        return youzanToken;
    }





    /**
     * 获取区域地名列表信息
     *
     * @return AjaxResult
     */
    public AjaxResult getRegions() {
        YouzanRegionsGet youzanRegionsGet = new YouzanRegionsGet();
        //创建参数对象,并设置参数
        YouzanRegionsGetParams youzanRegionsGetParams = new YouzanRegionsGetParams();
        youzanRegionsGet.setAPIParams(youzanRegionsGetParams);

        YouzanRegionsGetResult result = null;
        try {
            result = youZanClient.invoke(youzanRegionsGet, getToken(), YouzanRegionsGetResult.class);
        } catch (SDKException e) {
            e.printStackTrace();
            log.error("获取区域地名列表信息异常: {}",e.getMessage());
        }
        return AjaxResult.success(result);
    }
}
