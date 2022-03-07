package cn.lanca.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * project name:<font size="1"><b>小芄健康数据运营平台</b></font><br>
 * file name:<font size="1"><b>DictTemplate</b></font><br>
 * description:<font size="1"><b>平台字典数据操作实现类</b></font><br>
 * company name:<font size="1"><b>小芄医药科技（成都）有限公司-研发中心</b></font><br>
 *
 * @author <a href="mail to: ">mei.hongliang<br>
 * @version 1.0.0<br>
 * @since 2022/3/2 10:01  <br>
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)//只允许该注解打在方法上
public @interface KthLog {
    /**
     * value
     */
    String value() default "";
    /**
     * 日期类型 yyyy-MM-dd HH:mm:ss
     */
    String dateFormat() default "yyyy-MM-dd HH:mm:ss";
}
