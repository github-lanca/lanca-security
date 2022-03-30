package cn.lanca.esaypoi.controller.wed;

import cn.lanca.esaypoi.util.ExcelListener;
import cn.lanca.esaypoi.vo.v0.CommonVo;
import com.alibaba.excel.EasyExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * project name:<font size="1"><b>小芄健康数据运营平台</b></font><br>
 * file name:<font size="1"><b>DictTemplate</b></font><br>
 * description:<font size="1"><b>平台字典数据操作实现类</b></font><br>
 * company name:<font size="1"><b>小芄医药科技（成都）有限公司-研发中心</b></font><br>
 *
 * @author <a href="mail to: ">mei.hongliang<br>
 * @version 1.0.0<br>
 * @since 2022/3/25 18:12  <br>
 */
public class A_84124 {

    // 两个相同表合一
    public static void main(String[] args) throws FileNotFoundException {
        List<CommonVo> commonVos3a = get3A();
        List<CommonVo> commonVos48 = get48();
        System.out.println("commonVos3a:" + commonVos3a.size());
        System.out.println("commonVos48:" + commonVos48.size());
        commonVos3a.addAll(commonVos48);
        System.out.println("tt:" + commonVos3a.size());

        List<CommonVo> collect = commonVos3a.stream().sorted(Comparator.comparing(CommonVo::getA10)).collect(Collectors.toList());

        for (int i = 0; i < collect.size(); i++) {
            CommonVo commonVo = collect.get(i);
            commonVo.setA20((i + 1) + "");
        }

        // #3生成图片文件，excel文件
        File file2 = new File("/Users/meihongliang/Downloads/建设路-1327-没有/84124/A_全部数据汇总_84124.xlsx");
        EasyExcel.write(file2, CommonVo.class).sheet("84124").doWrite(collect);
    }

    private static List<CommonVo> get3A() throws FileNotFoundException {
        ExcelListener<CommonVo> userListener = new ExcelListener<>();
        String a = "/Users/meihongliang/Downloads/建设路-1327-没有/OTC药品系列-数据表.xls";
        EasyExcel.read(new FileInputStream(a), CommonVo.class, userListener).sheet().doRead();
        return userListener.getObjs();


    }

    private static List<CommonVo> get48() throws FileNotFoundException {
        ExcelListener<CommonVo> userListener = new ExcelListener<>();
        String b = "/Users/meihongliang/Downloads/建设路-1327-没有/处方药-数据表.xls";
        EasyExcel.read(new FileInputStream(b), CommonVo.class, userListener).sheet().doRead();
        return userListener.getObjs();
    }
}
