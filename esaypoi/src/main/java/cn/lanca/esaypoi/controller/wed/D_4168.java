package cn.lanca.esaypoi.controller.wed;

import cn.lanca.esaypoi.util.ExcelListener;
import cn.lanca.esaypoi.vo.CommonVo;
import com.alibaba.excel.EasyExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
public class D_4168 {


    /**
     * key3去重
     *
     * @param args args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {

        List<CommonVo> commonVos = get4168();
        System.out.println("commonVos_" + commonVos.size());
        List<CommonVo> result = new ArrayList<>();
        List<CommonVo> result_else = new ArrayList<>();

        System.out.println(commonVos.size());
        System.out.println(commonVos.get(0));
        commonVos.forEach(e -> {
            // x23 旧规格
            String x23 = e.getA21().replace("*", "-")
                    .replace(":", "x")
                    .replace("：", "x")
                    .replace("u", "μ")
                    .replace("s", "")
                    .replace("片/瓶", "")
                    .replace("片/盒", "")
                    .replace("片", "")
                    .replace("x1支", "")
                    .replace("支", "")
                    .replace("x1瓶", "")
                    .replace("毫升", "ml")
                    .replace("贴", "")
                    .replace("瓶", "")
                    .replace("粒", "")
                    .replace("袋", "")
                    .replace("×", "x")
                    .replace("/", "")
                    .replace("盒", "")
                    .replace("板", "")
                    .replace("装", "")
                    .replace("S", "")
                    .replace("x1", "")
                    .replace("x1", "")
                    .replace("包", "")
                    .replace("枚", "")
                    .replace("大", "")
                    .replace("糖衣", "")
                    .replace("（无糖型）", "")
                    .replace("（延迪诺）", "")
                    .replace("克", "g")
                    .replace("毫", "m")
                    .replace("(薄膜衣）", "")
                    .replace(" 薄膜衣", "")
                    .replace("（薄膜衣）", "")
                    .replace("丸", "")
                    .replace("（）", "")
                    .replace("gx", "x")
                    .replace("（乳糖型）", "")
                    .replace("(薄膜衣)", "")
                    .replace(";", "x").trim();


            String x24 = e.getA22().replace("*", "-")
                    .replace(":", "x")
                    .replace("：", "x")
                    .replace("u", "μ")
                    .replace(";", "x")
                    .replace("s", "")
                    .replace("片", "")
                    .replace("片/瓶", "")
                    .replace("片/盒", "")
                    .replace("x1支", "")
                    .replace("（无糖型）", "")
                    .replace("（延迪诺）", "")
                    .replace("支", "")
                    .replace("x1瓶", "")
                    .replace("毫升", "ml")
                    .replace("贴", "")
                    .replace("瓶", "")
                    .replace("粒", "")
                    .replace("袋", "")
                    .replace("×", "x")
                    .replace("/", "")
                    .replace("盒", "")
                    .replace("板", "")
                    .replace("包", "")
                    .replace("装", "")
                    .replace("S", "")
                    .replace("x1", "")
                    .replace("大", "")
                    .replace("糖衣", "")
                    .replace("克", "g")
                    .replace("枚", "")
                    .replace("毫", "m")
                    .replace("(薄膜衣）", "")
                    .replace(" 薄膜衣", "")
                    .replace("（薄膜衣）", "")
                    .replace("丸", "")
                    .replace("（）", "")
                    .replace("gx", "x")
                    .replace("（乳糖型）", "")
                    .replace("(薄膜衣)", "")
                    .replace("/盒", "").trim();

            if (x23.lastIndexOf("-1") == x23.length() - 2) {
                // System.out.println(x23 + "_|_" + x24 + " _leng_A:" + x24.lastIndexOf("-1") + " leng_B:" + x24.length());
//                System.out.println("Fuck you ........    " + x23 + "/" + x24);
                x23 = x23.replace("-1", "").trim();
            }
            if (x24.lastIndexOf("-1") == x24.length() - 2) {
                // System.out.println(x23 + "_|_" + x24 + " _leng_A:" + x24.lastIndexOf("-1") + " leng_B:" + x24.length());
//                System.out.println("Fuck you ........    " + x23 + "/" + x24);
                x24 = x24.replace("-1", "").trim();
            }

            e.setA23(x23);
            e.setA24(x24);
            e.setKey2(e.getA20() + "_" + e.getA21());
            // result.add(e);

            String patternxx = "[0-9]+";
            Pattern pattern = Pattern.compile(patternxx);
            Matcher matcher = pattern.matcher(x23);
            if (matcher.find()) {
                // 160ml	160mlx1瓶
                String group = matcher.group();
                if (x24.contains(group)) {
                    // System.out.println(x24 + "_|_" + x23);
                    result.add(e);
                } else {
                    result_else.add(e);
                }
            }
        });
        System.out.println("完全匹配:" + result.size());
        System.out.println("完全匹配_else:" + result_else.size());

        List<CommonVo> collect = result.stream().sorted(Comparator.comparing(CommonVo::getA10)).collect(Collectors.toList());
        // #3生成图片文件，excel文件 6041
        File file2 = new File("/Users/meihongliang/Downloads/建设路-1327-没有/84124_yy/1327_6041_key3_4168_" + collect.size() + ".xlsx");
        EasyExcel.write(file2, CommonVo.class).sheet(collect.size() + "").doWrite(collect);

        List<CommonVo> collect_result_else = result_else.stream().sorted(Comparator.comparing(CommonVo::getA10)).collect(Collectors.toList());
        // #3生成图片文件，excel文件 6041
        File file2_collect_result_else = new File("/Users/meihongliang/Downloads/建设路-1327-没有/84124_yy/1327_6041_key3_4168_" + collect_result_else.size() + ".xlsx");
        EasyExcel.write(file2_collect_result_else, CommonVo.class).sheet(collect_result_else.size() + "").doWrite(collect_result_else);


        List<CommonVo> resultxxx = new ArrayList<>();
        List<CommonVo> resultyyy = new ArrayList<>();
        result.forEach(e -> {
            if (e.getA23().equals(e.getA24())) {
                resultxxx.add(e);
            } else {
                resultyyy.add(e);
            }
        });
        System.out.println("x3098_" + resultxxx.size());
        System.out.println("y3098_" + resultyyy.size());

        List<CommonVo> ac12 = resultxxx.stream().sorted(Comparator.comparing(CommonVo::getA10)).collect(Collectors.toList());
        // #3生成图片文件，excel文件 6041
        File fileac12 = new File("/Users/meihongliang/Downloads/建设路-1327-没有/84124_yy/3098_中完全匹配_G_" + ac12.size() + ".xlsx");
        EasyExcel.write(fileac12, CommonVo.class).sheet(ac12.size() + "").doWrite(ac12);

        List<CommonVo> ac23 = resultyyy.stream().sorted(Comparator.comparing(CommonVo::getA10)).collect(Collectors.toList());
        // #3生成图片文件，excel文件 6041
        File fileac23 = new File("/Users/meihongliang/Downloads/建设路-1327-没有/84124_yy/3098_中未完全匹配_G_" + ac23.size() + ".xlsx");
        EasyExcel.write(fileac23, CommonVo.class).sheet(ac23.size() + "").doWrite(ac23);


        System.out.println("=================");
        List<CommonVo> pppp_list = new ArrayList<>();
        Map<String, List<CommonVo>> ppppp = ac12.stream().collect(Collectors.groupingBy(CommonVo::getKey2));
        ppppp.forEach((k, v) -> {
            pppp_list.add(v.get(0));
        });
        List<CommonVo> ac12_pppp_list = pppp_list.stream().sorted(Comparator.comparing(CommonVo::getA10)).collect(Collectors.toList());
        // #3生成图片文件，excel文件 6041
        File fileac12_ac12_pppp_list = new File("/Users/meihongliang/Downloads/建设路-1327-没有/84124_yy/3098_中完全匹配_G_" + ac12.size() + "_" + ac12_pppp_list.size() + ".xlsx");
        EasyExcel.write(fileac12_ac12_pppp_list, CommonVo.class).sheet(ac12_pppp_list.size() + "").doWrite(ac12_pppp_list);


        List<CommonVo> pppp_list_2 = new ArrayList<>();
        Map<String, List<CommonVo>> ppppp_ac23 = ac23.stream().collect(Collectors.groupingBy(CommonVo::getKey2));
        ppppp_ac23.forEach((k, v) -> {
            pppp_list_2.add(v.get(0));
        });
        List<CommonVo> ac23_2 = pppp_list_2.stream().sorted(Comparator.comparing(CommonVo::getA10)).collect(Collectors.toList());
        // #3生成图片文件，excel文件 6041
        File fileac23_2 = new File("/Users/meihongliang/Downloads/建设路-1327-没有/84124_yy/3098_中未完全匹配_G_" + ac23.size() + "_" + ac23_2.size() + ".xlsx");
        EasyExcel.write(fileac23_2, CommonVo.class).sheet(ac23_2.size() + "").doWrite(ac23_2);


        System.out.println("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
//        Map<String, List<CommonVo>> collect1 = ac12_pppp_list.stream().collect(Collectors.groupingBy(CommonVo::getKey2));
//        System.out.println("z1:" + collect1.size());
//        Map<String, List<CommonVo>> collect2 = pppp_list_2.stream().collect(Collectors.groupingBy(CommonVo::getKey2));
//        System.out.println("z2:" + collect2.size());


        System.out.println("==============+++++++++");
        // 未完全匹配的759
        System.out.println("A_未完全匹配_" + ac23_2.size());
        int size = ac23_2.size();
        System.out.println("B_已完全匹配" + ac12_pppp_list.size());
        int size1 = ac12_pppp_list.size();
        Iterator<CommonVo> iterator_759 = ac23_2.iterator();
        while (iterator_759.hasNext()) {
            CommonVo commonVo_759 = iterator_759.next();
            Iterator<CommonVo> iterator_813 = ac12_pppp_list.iterator();
            while (iterator_813.hasNext()) {
                CommonVo commonVo_813 = iterator_813.next();
                if ((commonVo_759.getA20() + "_" + commonVo_759.getA21()).equals((commonVo_813.getA20() + "_" + commonVo_813.getA21()))) {
//                    System.out.println(commonVo_759.getA20() + "_" + commonVo_759.getA21());
                    System.out.println(commonVo_813.getA20() + "_" + commonVo_813.getA21());
                    iterator_759.remove();
                }
            }
        }
        System.out.println("移除后剩余:" + ac23_2.size());// 348 ABC_348

        List<CommonVo> commonVos_759_sort = ac23_2.stream().sorted(Comparator.comparing(CommonVo::getA10)).collect(Collectors.toList());
        // #3生成图片文件，excel文件 6041
        File file759_sort = new File("/Users/meihongliang/Downloads/建设路-1327-没有/84124_yy/未完全匹配的" + size + "条数据去除完全匹配的" + size1 + "条中存在'批准文号_药品规格'后剩余需要手动匹配的数据_" + commonVos_759_sort.size() + ".xlsx");
        // 国药准字Z53020685_0.4g*70粒
        EasyExcel.write(file759_sort, CommonVo.class).sheet(commonVos_759_sort.size() + "").doWrite(commonVos_759_sort);

    }


    private static List<CommonVo> get4168() throws FileNotFoundException {
        ExcelListener<CommonVo> userListener = new ExcelListener<>();
        String a = "/Users/meihongliang/Downloads/建设路-1327-没有/84124/1327_6041_key3_4168.xlsx";
        EasyExcel.read(new FileInputStream(a), CommonVo.class, userListener).sheet().doRead();
        return userListener.getObjs();
    }

}
