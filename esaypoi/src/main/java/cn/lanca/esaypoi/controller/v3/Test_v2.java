package cn.lanca.esaypoi.controller.v3;

import cn.lanca.esaypoi.util.ExcelListener;
import cn.lanca.esaypoi.util.ReplaceStriUtils;
import com.alibaba.excel.EasyExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
public class Test_v2 {
    public static void main(String[] args) throws FileNotFoundException {
        List<CommonV3> all = getAll();
        System.out.println("ALL:" + all.size());
        System.out.println(all.get(0));
        System.out.println("-----------");
        List<CommonOther> other = getOther();
        System.out.println("OTHRER:" + other.size());
        System.out.println(other.get(0));
        AtomicInteger atomicInteger = new AtomicInteger(0);
        AtomicInteger lessInteger = new AtomicInteger(0);
        AtomicInteger lessInteger222 = new AtomicInteger(0);

        List<CommonOther> equalsList = new ArrayList<>();
        List<CommonOther> notEqualsList = new ArrayList<>();

        Map<String, List<CommonV3>> allCollect = all.stream().collect(Collectors.groupingBy(CommonV3::getA10));
        Map<String, List<CommonOther>> otherCollect = other.stream().collect(Collectors.groupingBy(CommonOther::getA8));
        System.out.println("singeALL:" + allCollect.size());
        System.out.println("singeOTHER:" + otherCollect.size());

        otherCollect.forEach((k, v) -> {
            allCollect.forEach((m, n) -> {
                if (k.equals(m)) {
                    lessInteger222.incrementAndGet();
                    CommonOther commonOther = v.get(0);
                    String less = commonOther.getA4();
                    out:for (int i = 0; i < n.size(); i++) {
                        CommonV3 commonV3 = n.get(i);
                        String a5 = commonV3.getA5();
                        Pattern compile = Pattern.compile("[0-9]+");
                        Matcher matcher = compile.matcher(a5);
                        if (matcher.find()) {
                            if (less.contains(matcher.group())) {
                                String change = ReplaceStriUtils.change(less);
                                String change_a5 = ReplaceStriUtils.change(a5);
                                if (change.equals(change_a5)) {
                                    //System.out.println(k + "  " + less + "_|_" + a5 + "    " + change + "_|_" + change_a5);
                                    commonOther.setA19(commonV3.getA18());
                                    String a21 = commonV3.getA5();
                                    String a22 = commonOther.getA4();
                                    commonOther.setA21(a21);
                                    commonOther.setA22(a22);

                                    commonOther.setB1(commonV3.getA8());
                                    commonOther.setB2(commonV3.getA9());
                                    commonOther.setB3(commonV3.getA11());
                                    commonOther.setB4(commonV3.getA12());
                                    commonOther.setB5(commonV3.getA14());
                                    commonOther.setB6(commonV3.getA15());
                                    commonOther.setB7(commonV3.getA16());
                                    equalsList.add(commonOther);
                                    atomicInteger.incrementAndGet();
                                    break out;
                                }
                            }
                        }

                    }
                }
            });
        });

        System.out.println("+++++");
        System.out.println("完全相等：" + atomicInteger);


        equalsList.sort(Comparator.comparing(CommonOther::getA0));

        Iterator<CommonOther> iterator = other.iterator();
        while (iterator.hasNext()) {
            CommonOther next = iterator.next();
            Iterator<CommonOther> iterator1 = equalsList.iterator();
            while (iterator1.hasNext()) {
                CommonOther next1 = iterator1.next();
                if (next.getA8().equals(next1.getA8())){
                    iterator.remove();
                }
            }
        }

        File file1 = new File("/Users/meihongliang/Downloads/新增上线品种（福源店）的副本_完全匹配.xlsx");
        EasyExcel.write(file1, CommonOther.class).sheet(equalsList.size() + "").doWrite(equalsList);

        File file2 = new File("/Users/meihongliang/Downloads/新增上线品种（福源店）的副本_不完全匹配.xlsx");
        EasyExcel.write(file2, CommonOther.class).sheet(other.size() + "").doWrite(other);
        System.out.println(equalsList.size());
        System.out.println(other.size());
        System.out.println("标准文号相同的数量："+lessInteger222);
        // todo 完全/不完全匹配 就是这个
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
