package cn.lanca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * project name:<font size="1"><b>小芄健康数据运营平台</b></font><br>
 * file name:<font size="1"><b>DictTemplate</b></font><br>
 * description:<font size="1"><b>平台字典数据操作实现类</b></font><br>
 * company name:<font size="1"><b>小芄医药科技（成都）有限公司-研发中心</b></font><br>
 *
 * @author <a href="mail to: ">mei.hongliang<br>
 * @version 1.0.0<br>
 * @since 2022/3/7 09:57  <br>
 */
@RestController
public class YouzanController {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @GetMapping("/test/{str}")
    public String test(@PathVariable String str) {
        return "springboot_youzan " + str;
    }


    @GetMapping("/token/{grantId}")
    public String token(@PathVariable String grantId) {

        String youzanToken = Objects.requireNonNull(redisTemplate.opsForValue().get("youzanToken_" + grantId)).toString();

        return "springboot_youzan token:_" + youzanToken;
    }


}
