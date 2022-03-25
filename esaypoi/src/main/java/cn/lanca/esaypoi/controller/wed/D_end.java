package cn.lanca.esaypoi.controller.wed;

import cn.lanca.esaypoi.util.ExcelListener;
import cn.lanca.esaypoi.vo.CommonVo;
import com.alibaba.excel.EasyExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Iterator;
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
public class D_end {


    /**
     * 在未完全匹配的759中去除813中重复的批准文号
     *
     * @param args args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        List<CommonVo> commonVos_759 = get759();
        List<CommonVo> commonVos1 = get813();
        System.out.println("A_" + commonVos_759.size());
        System.out.println("B_" + commonVos1.size());
        Iterator<CommonVo> iterator_759 = commonVos_759.iterator();
        while (iterator_759.hasNext()) {
            CommonVo commonVo_759 = iterator_759.next();
            Iterator<CommonVo> iterator_813 = commonVos1.iterator();
            while (iterator_813.hasNext()) {
                CommonVo commonVo_813 = iterator_813.next();
                if (commonVo_759.getA10().equals(commonVo_813.getA10())) {
                    iterator_759.remove();
                }
            }
        }
        System.out.println("移除后剩余:" + commonVos_759.size());

        List<CommonVo> commonVos_759_sort = commonVos_759.stream().sorted(Comparator.comparing(CommonVo::getA10)).collect(Collectors.toList());
        // #3生成图片文件，excel文件 6041
        File file759_sort = new File("/Users/meihongliang/Downloads/建设路-1327-没有/84124_yy/未完全匹配的759条数据去除重复批准文号后剩余需要手动匹配的数据_" + commonVos_759_sort.size() + ".xlsx");
        EasyExcel.write(file759_sort, CommonVo.class).sheet(commonVos_759_sort.size() + "").doWrite(commonVos_759_sort);

    }

    private static List<CommonVo> get813() throws FileNotFoundException {
        ExcelListener<CommonVo> userListener = new ExcelListener<>();
        String a = "/Users/meihongliang/Downloads/建设路-1327-没有/84124_yy/3098_中完全匹配_G_915_813.xlsx";
        EasyExcel.read(new FileInputStream(a), CommonVo.class, userListener).sheet().doRead();
        return userListener.getObjs();
    }

    private static List<CommonVo> get759() throws FileNotFoundException {
        ExcelListener<CommonVo> userListener = new ExcelListener<>();
        String a = "/Users/meihongliang/Downloads/建设路-1327-没有/84124_yy/3098_中未完全匹配_G_2125_759.xlsx";
        EasyExcel.read(new FileInputStream(a), CommonVo.class, userListener).sheet().doRead();
        return userListener.getObjs();
    }

}
