package cn.lanca.esaypoi.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @version 1.0.0<br>
 * @since 2022/3/18 15:09  <br>
 */
@Retention(RetentionPolicy.RUNTIME)//注解在运行时也生效
@Target(ElementType.FIELD)//只允许在字段上添加该注解
public @interface ExcelAno {

    public String value() default "";
}
