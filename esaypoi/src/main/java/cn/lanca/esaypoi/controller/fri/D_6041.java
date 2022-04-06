package cn.lanca.esaypoi.controller.fri;

import cn.lanca.esaypoi.util.ExcelListener;
import cn.lanca.esaypoi.vo.v0.AandBVo;
import cn.lanca.esaypoi.vo.v0.CommonVo;
import com.alibaba.excel.EasyExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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
 * @since 2022/3/25 15:05  <br>
 */
public class D_6041 {
    public static void main(String[] args) throws FileNotFoundException {

        List<CommonVo> commonVos = get84124();//84124
        List<CommonVo> pipeishang = new ArrayList<>();
        List<AandBVo> aandBVos = get1327();//1327
        System.out.println(commonVos.get(0));
        System.out.println(aandBVos.get(0));
        System.out.println("开始:" + aandBVos.size());
        aandBVos.forEach(ab->{
            commonVos.forEach(com->{
                if (ab.getA15().equals(com.getA10())) {
                    com.setA25(ab.getA0());
                    com.setA26(ab.getA1());
                    com.setA20(com.getA10());
                    com.setA21(ab.getA16());
                    com.setA22(com.getA5());
                    pipeishang.add(com);
                }
            });
        });
        List<CommonVo> pingsort = pipeishang.stream().sorted(Comparator.comparing(CommonVo::getA0)).collect(Collectors.toList());
        System.out.println("end:" + pingsort.size());

        // #3生成图片文件，excel文件
        File file2 = new File("/Users/meihongliang/Downloads/A_xiaowan/fri/1327中匹配上的数据_6041.xlsx");
        EasyExcel.write(file2, CommonVo.class).sheet("6041").doWrite(pingsort);

    }

    private static List<CommonVo> get84124() throws FileNotFoundException {
        ExcelListener<CommonVo> userListener = new ExcelListener<>();
        String a = "/Users/meihongliang/Downloads/A_xiaowan/fri/A_全部数据_84124.xlsx";
        EasyExcel.read(new FileInputStream(a), CommonVo.class, userListener).sheet().doRead();
        return userListener.getObjs();
    }


    private static List<AandBVo> get1327() throws FileNotFoundException {
        ExcelListener<AandBVo> userListener = new ExcelListener<>();
        String a = "/Users/meihongliang/Downloads/A_xiaowan/fri/建设路药品表1327.xlsx";
        EasyExcel.read(new FileInputStream(a), AandBVo.class, userListener).sheet().doRead();
        return userListener.getObjs();
    }
}
