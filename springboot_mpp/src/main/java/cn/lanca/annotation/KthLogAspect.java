package cn.lanca.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * project name:<font size="1"><b>小芄健康数据运营平台</b></font><br>
 * file name:<font size="1"><b>DictTemplate</b></font><br>
 * description:<font size="1"><b>平台字典数据操作实现类</b></font><br>
 * company name:<font size="1"><b>小芄医药科技（成都）有限公司-研发中心</b></font><br>
 *
 * @author <a href="mail to: ">mei.hongliang<br>
 * @version 1.0.0<br>
 * @since 2022/3/2 10:12  <br>
 */
@Component
@Aspect
public class KthLogAspect {

    @Pointcut("@annotation(cn.lanca.annotation.KthLog)")
    private void pointcut() {
    }

    @Before("pointcut() && @annotation(logger)")
    public void advice(JoinPoint joinPoint, KthLog logger) {
        System.out.println("--- Kth日志的内容为[" + logger.value() + "] ---");
    }
}

