package cn.lanca.esaypoi.controller.wed;

import cn.lanca.esaypoi.util.ExcelListener;
import cn.lanca.esaypoi.vo.AandBVo;
import cn.lanca.esaypoi.vo.CommonVo;
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
 * @since 2022/3/25 18:12  <br>
 */
public class B_pipei_1233 {


    /**
     * zhao 1233
     *
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {

        List<CommonVo> commonVos = get84124();//84124
        List<AandBVo> aandBVos = get1327();//1327
        System.out.println(commonVos.get(0));
        System.out.println(aandBVos.get(0));
        System.out.println("开始:" + aandBVos.size());

        Map<String, List<CommonVo>> aaaa = commonVos.stream().collect(Collectors.groupingBy(CommonVo::getA10));
        Map<String, List<AandBVo>> vvvv = aandBVos.stream().collect(Collectors.groupingBy(AandBVo::getA3));

        List<AandBVo> ccc = new ArrayList<>();
        List<CommonVo> xxxxyyyy = new ArrayList<>();

        vvvv.forEach((k, v) -> {
            aaaa.forEach((m, n) -> {
                if (k.equals(m)) {
                    AandBVo aandBVo = v.get(0);
                    n.forEach(xx -> {
                        if (aandBVo.getA4().equals(xx.getA5())) {
                            System.out.println(aandBVo.getA4() + "_|_" + xx.getA5());
                            xx.setA25(aandBVo.getA0());
                            xx.setA26(aandBVo.getA1());
                            xxxxyyyy.add(xx);
                        }
                    });
                }
            });
        });
        System.out.println("_" + xxxxyyyy.size());


        List<CommonVo> collect = xxxxyyyy.stream().sorted(Comparator.comparing(CommonVo::getA10)).collect(Collectors.toList());
        // #3生成图片文件，excel文件
        File file2 = new File("/Users/meihongliang/Downloads/建设路-1327-没有/84124/C_0328_完全匹配的_" + collect.size() + ".xlsx");
         EasyExcel.write(file2, CommonVo.class).sheet(collect.size() + "").doWrite(collect);


    }

    private static List<CommonVo> get84124() throws FileNotFoundException {
        ExcelListener<CommonVo> userListener = new ExcelListener<>();
        String a = "/Users/meihongliang/Downloads/建设路-1327-没有/84124/A_全部数据汇总_84124.xlsx";
        EasyExcel.read(new FileInputStream(a), CommonVo.class, userListener).sheet().doRead();
        return userListener.getObjs();
    }

    private static List<AandBVo> get1327() throws FileNotFoundException {
        ExcelListener<AandBVo> userListener = new ExcelListener<>();
        String b = "/Users/meihongliang/Downloads/建设路-1327-没有/建设路药品表1327.xlsx";
        EasyExcel.read(new FileInputStream(b), AandBVo.class, userListener).sheet().doRead();
        return userListener.getObjs();
    }
}
