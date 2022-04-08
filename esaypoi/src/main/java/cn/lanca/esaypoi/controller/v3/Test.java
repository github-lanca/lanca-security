package cn.lanca.esaypoi.controller.v3;

import cn.lanca.esaypoi.util.ExcelListener;
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
 * project name:<font size = "1"><b>小芄健康数据运营平台</b></font><br>
 * file name:<font size = "1"><b>TODO</b></font><br>
 * description:<font size = "1"><b>TODO</b></font><br>
 * company name:<font size = "1"><b>小芄医药科技（成都）有限公司-研发中心</b></font><br>
 *
 * @author <a href="mail to: meihongliang@xiaowanjiankang.com" rel="nofollow">meihongliang<br>
 * @version 1.0.0<br>
 * @since [1] [2022/4/7 21:30] [meihongliang] [新建] <br>
 */
public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        List<CommonV3> all = getAll();
        System.out.println("ALL:" + all.size());
        System.out.println(all.get(0));
        System.out.println("-----------");
        List<CommonOther> other = getOther();
        System.out.println("OTHRER:" + other.size());
        System.out.println(other.get(0));

        List<CommonOther> equalsList = new ArrayList<>();
        Map<String, List<CommonV3>> allCollect = all.stream().collect(Collectors.groupingBy(CommonV3::getA10));
        Map<String, List<CommonOther>> otherCollect = other.stream().collect(Collectors.groupingBy(CommonOther::getA8));
        System.out.println("singeALL:" + allCollect.size());
        System.out.println("singeOTHER:" + otherCollect.size());
        allCollect.forEach((m, n) -> {
            otherCollect.forEach((k, v) -> {
                if (k.equals(m)) {
                    for (int i1 = 0; i1 < n.size(); i1++) {
                        CommonV3 commonV3 = n.get(i1);
                        for (int i = 0; i < v.size(); i++) {
                            CommonOther commonOther = v.get(i);
                            commonOther.setA19(commonV3.getA18());
                            commonOther.setA20(commonOther.getA8() + "_" + commonOther.getA4());
                            commonOther.setA21(commonV3.getA5());
                            commonOther.setA22(commonOther.getA4());
                            equalsList.add(commonOther);
                        }
                    }
                }
            });
        });

        Map<String, List<CommonOther>> collect = equalsList.stream().collect(Collectors.groupingBy(CommonOther::getA20));
        List<CommonOther> aaaaa = new ArrayList<>();
        collect.forEach((k, v) -> {
            CommonOther commonOther = v.get(0);
            commonOther.setA19("");
            commonOther.setA20("");
            aaaaa.add(commonOther);
        });

        aaaaa.sort(Comparator.comparing(CommonOther::getA0));

        File file1 = new File("/Users/meihongliang/Downloads/新增上线品种（福源店）的副本_需手动匹配.xlsx");
        EasyExcel.write(file1, CommonOther.class).sheet(aaaaa.size() + "").doWrite(aaaaa);

    }

    private static List<CommonV3> getAll() throws FileNotFoundException {
        ExcelListener<CommonV3> userListener55555 = new ExcelListener<>();
        String fileName96 = "/Users/meihongliang/Downloads/A_xiaowan/main/A_全部数据_84124.xlsx";
        EasyExcel.read(new FileInputStream(fileName96), CommonV3.class, userListener55555).sheet().doRead();
        return userListener55555.getObjs();
    }


    private static List<CommonOther> getOther() throws FileNotFoundException {
        ExcelListener<CommonOther> userListener55555 = new ExcelListener<>();
        String fileName96 = "/Users/meihongliang/Downloads/A_xiaowan/main/新增上线品种（福源店）的副本.xls";
        EasyExcel.read(new FileInputStream(fileName96), CommonOther.class, userListener55555).sheet().doRead();
        return userListener55555.getObjs();
    }
}
