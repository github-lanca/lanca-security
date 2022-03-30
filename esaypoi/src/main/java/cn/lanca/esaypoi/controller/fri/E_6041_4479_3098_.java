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
public class E_6041_4479_3098_ {
    public static void main(String[] args) throws FileNotFoundException {
        List<CommonVo> commonVos = get3098();//3098
        List<CommonVo> result = new ArrayList<>();
        List<CommonVo> weiwanquan = new ArrayList<>();
        System.out.println(commonVos.size());
        commonVos.forEach(e -> {
            if (e.getA23().equals(e.getA24())) {
                System.out.println(e.getA23() + "_|_" + e.getA24());
                result.add(e);
            } else {
                weiwanquan.add(e);
            }
        });
        System.out.println("_|_" + result.size());


        // 441
        List<CommonVo> sortResult = result.stream().sorted(Comparator.comparing(CommonVo::getA10)).collect(Collectors.toList());
        File file2 = new File("/Users/meihongliang/Downloads/A_xiaowan/fri/3098完全匹配剩余441.xlsx");
        EasyExcel.write(file2, CommonVo.class).sheet(sortResult.size() + "").doWrite(sortResult);

        // 2657
        List<CommonVo> weiwanquanSort = weiwanquan.stream().sorted(Comparator.comparing(CommonVo::getA10)).collect(Collectors.toList());
        File file_weiwanquanSort = new File("/Users/meihongliang/Downloads/A_xiaowan/fri/3098未完全匹配剩余_" + weiwanquanSort.size() + ".xlsx");
        EasyExcel.write(file_weiwanquanSort, CommonVo.class).sheet(weiwanquanSort.size() + "").doWrite(weiwanquanSort);


    }

    private static List<CommonVo> get3098() throws FileNotFoundException {
        ExcelListener<CommonVo> userListener = new ExcelListener<>();
        String a = "/Users/meihongliang/Downloads/A_xiaowan/fri/4479中key3去重_3098.xlsx";
        EasyExcel.read(new FileInputStream(a), CommonVo.class, userListener).sheet().doRead();
        return userListener.getObjs();
    }
}
