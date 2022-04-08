package cn.lanca.esaypoi.util;

import org.springframework.util.StringUtils;

/**
 * project name:<font size="1"><b>小芄健康数据运营平台</b></font><br>
 * file name:<font size="1"><b>DictTemplate</b></font><br>
 * description:<font size="1"><b>平台字典数据操作实现类</b></font><br>
 * company name:<font size="1"><b>小芄医药科技（成都）有限公司-研发中心</b></font><br>
 *
 * @author <a href="mail to: ">mei.hongliang<br>
 * @version 1.0.0<br>
 * @since 2022/4/6 14:03  <br>
 */
public class ReplaceStriUtils {

    /**
     * 用量单位转换
     *
     * @param arg arg
     * @return String
     */
    public static String replaceString(String arg) {
        String result = arg.trim();
        if (StringUtils.hasText(result)) {
            if (result.contains("ml")) {
                return "ml";
            }
            if (result.contains("μg")) {
                return "μg";
            }
            if (result.contains("ug")) {
                return "μg";
            }
            if (result.contains("mg")) {
                return "mg";
            }//μg
            if (result.contains("g")) {
                return "g";
            }
            if (result.contains("克")) {
                return "克";
            }
            if (result.contains("片")) {
                return "片";
            }//粒
            if (result.contains("粒")) {
                return "粒";
            }//丸
            if (result.contains("丸")) {
                return "丸";
            }//贴
            if (result.contains("贴")) {
                return "贴";
            }//枚
            if (result.contains("枚")) {
                return "枚";
            }//毫升
            if (result.contains("毫升")) {
                return "毫升";
            }//袋
            if (result.contains("袋")) {
                return "袋";
            }//克
            //帖
            if (result.contains("帖")) {
                return "帖";
            }
        }
        return result;
    }

    public static String change(String args) {
        args = args.trim();
        if (StringUtils.hasText(args)) {
            args = args.replace("*", "_");
            args = args.replace("×", "_");
            args = args.replace("袋/盒", "");
            args = args.replace("片/盒", "");
            args = args.replace("瓶/盒", "");
            args = args.replace("片/瓶", "");
            args = args.replace("袋", "");
            args = args.replace("板", "");
            args = args.replace("支", "");
            args = args.replace("片", "");
            args = args.replace("/盒", "");
            args = args.replace("克", "g");
            args = args.replace("/包", "");
            args = args.replace("毫升", "ml");//69
            args = args.replace("/", "");
        }
        return args;
    }
}
