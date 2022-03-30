package cn.lanca.esaypoi.controller.wed;

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
 * @since 2022/3/25 18:12  <br>
 */
public class C_key3_4168_quchong {


    /**
     * key3去重
     *
     * @param args args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {

        List<CommonVo> commonVos = get6041();
        List<CommonVo> result = new ArrayList<>();
        System.out.println(commonVos.size());
        commonVos.forEach(e -> {
            String key3 = e.getA20() + "_" + e.getA21() + "_" + e.getA22();
            e.setKey(key3);
        });
        System.out.println(commonVos.get(0).getKey());
        Map<String, List<CommonVo>> collectxxx = commonVos.stream().collect(Collectors.groupingBy(CommonVo::getKey));
        collectxxx.forEach((k, v) -> {
            result.add(v.get(0));
        });
        System.out.println("a" + result.size());


        List<CommonVo> collect = result.stream().sorted(Comparator.comparing(CommonVo::getA10)).collect(Collectors.toList());
        // #3生成图片文件，excel文件 6041
        File file2 = new File("/Users/meihongliang/Downloads/建设路-1327-没有/84124/1327_6041_key3_" + collect.size() + ".xlsx");
        EasyExcel.write(file2, CommonVo.class).sheet(collect.size() + "").doWrite(collect);


    }

    private static List<CommonVo> get6041() throws FileNotFoundException {
        ExcelListener<CommonVo> userListener = new ExcelListener<>();
        String a = "/Users/meihongliang/Downloads/建设路-1327-没有/84124/1327全匹配上的数据_6041.xlsx";
        EasyExcel.read(new FileInputStream(a), CommonVo.class, userListener).sheet().doRead();
        return userListener.getObjs();
    }

}
