package cn.lanca.esaypoi.controller.v4;

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
public class Test_GetAllData {
    public static void main(String[] args) throws FileNotFoundException {

        List<CommonA> result = getTogether();
        result.sort(Comparator.comparing(CommonA::getA10));
        File file1 = new File("/Users/meihongliang/Downloads/A_xiaowan/main/B_全部数据_" + result.size() + ".xlsx");
        EasyExcel.write(file1, CommonA.class).sheet(result.size() + "").doWrite(result);

    }

    private static List<CommonA> getA() throws FileNotFoundException {
        ExcelListener<CommonA> a = new ExcelListener<>();
        String fileA = "/Users/meihongliang/Downloads/A_xiaowan/main/7.5w数据库/OTC药品系列-数据表.xls";
        EasyExcel.read(new FileInputStream(fileA), CommonA.class, a).sheet().doRead();
        return a.getObjs();
    }


    private static List<CommonA> getB() throws FileNotFoundException {
        ExcelListener<CommonA> b = new ExcelListener<>();
        String fileB = "/Users/meihongliang/Downloads/A_xiaowan/main/7.5w数据库/处方药-数据表.xls";
        EasyExcel.read(new FileInputStream(fileB), CommonA.class, b).sheet().doRead();
        return b.getObjs();
    }

    /**
     * 获取所有数据并根据'批准文号+规格'去重
     *
     * @return List List
     * @throws FileNotFoundException e
     */
    private static List<CommonA> getTogether() throws FileNotFoundException {
        List<CommonA> a = getA();
        List<CommonA> b = getB();
        System.out.println("A:" + a.size());
        System.out.println("B:" + b.size());
        a.addAll(b);
        System.out.println("T:" + a.size());
        a.forEach(e -> {
            e.setKey(e.getA10() + "_" + e.getA5());
        });
        Map<String, List<CommonA>> collect = a.stream().collect(Collectors.groupingBy(CommonA::getKey));
        List<CommonA> result = new ArrayList<>();
        collect.forEach((k, v) -> {
            CommonA commonA = v.get(0);
            commonA.setB1(commonA.getA10());
            commonA.setB2(commonA.getA5());
            result.add(commonA);
        });
        System.out.println("根据'批准文号+规格'去重");
        System.out.println("R:" + result.size());
        return result;
    }
}
