package cn.lanca.esaypoi.controller.fri;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * project name:<font size="1"><b>小芄健康数据运营平台</b></font><br>
 * file name:<font size="1"><b>DictTemplate</b></font><br>
 * description:<font size="1"><b>平台字典数据操作实现类</b></font><br>
 * company name:<font size="1"><b>小芄医药科技（成都）有限公司-研发中心</b></font><br>
 *
 * @author <a href="mail to: ">mei.hongliang<br>
 * @version 1.0.0<br>
 * @since 2022/3/25 16:14  <br>
 */
public class D {
    public static void main(String[] args) {
        String patternxx = "[0-9]+";
        Pattern pattern = Pattern.compile(patternxx);
        Matcher matcher = pattern.matcher("abc123adad234");
        if (matcher.find()) {
            String group0 = matcher.group(0);
            String group1 = matcher.group(1);
            System.out.println(group0);
            System.out.println(group1);
            int i = matcher.groupCount();
            System.out.println(i);
        }
    }
}
