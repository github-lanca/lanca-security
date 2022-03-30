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
import java.util.Map;
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
public class E_6041_4479_3098 {
    public static void main(String[] args) throws FileNotFoundException {
        List<CommonVo> commonVos = get4479();//4479
        System.out.println(commonVos.size());
        List<CommonVo> result = new ArrayList<>();
        commonVos.forEach(e -> {
            e.setKey(e.getA20() + "_" + e.getA21() + "_" + e.getA22());
        });
        Map<String, List<CommonVo>> key3List = commonVos.stream().collect(Collectors.groupingBy(CommonVo::getKey));
        System.out.println("key3去重:" + key3List.size());

        key3List.forEach((k, v) -> {
            CommonVo commonVo = v.get(0);
            String x23 = commonVo.getA21().replace("*", "x");
            String x24 = commonVo.getA22().replace("*", "x").replace("/盒", "");
            commonVo.setA23(x23);
            commonVo.setA24(x24);
            result.add(commonVo);
        });
        System.out.println("-" + result.size());


//        List<CommonVo> abccccc = new ArrayList<>();
//        result.forEach(e->{
//            if (e.getA21().equals(e.getA22())) {
//                System.out.println(e.getA21());
//                abccccc.add(e);
//            }
//        });
//        System.out.println("abccc:"+abccccc.size());

        List<CommonVo> sortResult = result.stream().sorted(Comparator.comparing(CommonVo::getA10)).collect(Collectors.toList());
        File file2 = new File("/Users/meihongliang/Downloads/A_xiaowan/fri/4479中key3去重_3098.xlsx");
        EasyExcel.write(file2, CommonVo.class).sheet("3098").doWrite(sortResult);


    }

    private static List<CommonVo> get4479() throws FileNotFoundException {
        ExcelListener<CommonVo> userListener = new ExcelListener<>();
        String a = "/Users/meihongliang/Downloads/A_xiaowan/fri/6041中根据规格模糊匹配_4479.xlsx";
        EasyExcel.read(new FileInputStream(a), CommonVo.class, userListener).sheet().doRead();
        return userListener.getObjs();
    }
}
