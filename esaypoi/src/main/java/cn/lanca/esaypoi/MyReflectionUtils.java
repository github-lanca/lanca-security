package cn.lanca.esaypoi;

import cn.lanca.esaypoi.dto.Person;

import java.lang.reflect.Field;
import java.util.Date;

/**
 * project name:<font size="1"><b>小芄健康数据运营平台</b></font><br>
 * file name:<font size="1"><b>DictTemplate</b></font><br>
 * description:<font size="1"><b>平台字典数据操作实现类</b></font><br>
 * company name:<font size="1"><b>小芄医药科技（成都）有限公司-研发中心</b></font><br>
 *
 * @author <a href="mail to: ">mei.hongliang<br>
 * @version 1.0.0<br>
 * @since 2022/3/18 16:19  <br>
 */
public class MyReflectionUtils {

    public static void main(String[] args) throws IllegalAccessException {
        Person person = new Person();
        person.setAge(1);
        person.setName("meihongliang");
        person.setTime(new Date());
        person.setTimeStr("2022-03-18 12:00:09");
        // 拿字段
        Field[] declaredFields = Person.class.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            Object o = declaredField.get(person);
             System.out.println(declaredField.getName()+"/"+declaredField.getType()+"/"+o.toString());
        }
    }
}
