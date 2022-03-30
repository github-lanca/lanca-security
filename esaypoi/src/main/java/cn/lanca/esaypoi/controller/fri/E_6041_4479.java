package cn.lanca.esaypoi.controller.fri;

import cn.lanca.esaypoi.util.ExcelListener;
import cn.lanca.esaypoi.vo.v0.CommonVo;
import com.alibaba.excel.EasyExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * project name:<font size="1"><b>小芄健康数据运营平台</b></font><br>
 * file name:<font size="1"><b>DictTemplate</b></font><br>
 * description:<font size="1"><b>平台字典数据操作实现类</b></font><br>
 * company name:<font size="1"><b>小芄医药科技（成都）有限公司-研发中心</b></font><br>
 *
 * @author <a href="mail to: ">mei.hongliang<br>
 * @version 1.0.0<br>
 * @since 2022/3/25 15:05  <br>
 */
public class E_6041_4479 {
    public static void main(String[] args) throws FileNotFoundException {
        List<CommonVo> commonVos = get6041();//6041
        List<CommonVo> result = new ArrayList<>();
        System.out.println(commonVos.size());

        String patternxx = "[0-9]+";
        Pattern pattern = Pattern.compile(patternxx);
        commonVos.forEach(e -> {
            Matcher matcher = pattern.matcher(e.getA21());
            if (matcher.find()) {
                String group = matcher.group();
                if (e.getA22().contains(group)) {
                    System.out.println(e.getA21() + "_|_" + e.getA22());
                    result.add(e);
                }
            }
        });
        System.out.println("find:"+result.size());
//         [0-9]+
// #3生成图片文件，excel文件
        List<CommonVo> sortResult = result.stream().sorted(Comparator.comparing(CommonVo::getA10)).collect(Collectors.toList());
        File file2 = new File("/Users/meihongliang/Downloads/A_xiaowan/fri/6041中根据规格模糊匹配_4479.xlsx");
        EasyExcel.write(file2, CommonVo.class).sheet("4479").doWrite(sortResult);

    }

    private static List<CommonVo> get6041() throws FileNotFoundException {
        ExcelListener<CommonVo> userListener = new ExcelListener<>();
        String a = "/Users/meihongliang/Downloads/A_xiaowan/fri/1327中匹配上的数据_6041.xlsx";
        EasyExcel.read(new FileInputStream(a), CommonVo.class, userListener).sheet().doRead();
        return userListener.getObjs();
    }
}
