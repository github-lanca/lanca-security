package cn.lanca.esaypoi.controller;

import cn.lanca.esaypoi.util.ExcelListener;
import cn.lanca.esaypoi.vo.DrugVo;
import cn.lanca.esaypoi.vo.DrugVo36070;
import cn.lanca.esaypoi.vo.DrugVo942;
import com.alibaba.excel.EasyExcel;
import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;

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
 * @since 2022/3/23 23:49  <br>
 */
public class GroupTest {
    public static void main(String[] args) throws FileNotFoundException {
        List<DrugVo942> drugVo942s = get942();
        List<DrugVo36070> drugVo36070s = get36070();//942
        Map<String, List<DrugVo942>> list942 = drugVo942s.stream().collect(Collectors.groupingBy(DrugVo942::getA15));
        Map<String, List<DrugVo36070>> listMap36070 = drugVo36070s.stream().collect(Collectors.groupingBy(DrugVo36070::getA10));
        System.out.println("<==========================>");
        System.out.println("            924总数:" + drugVo942s.size());
        System.out.println("       942GroupBy后:" + list942.size());
        System.out.println("           A+B总数量:" + drugVo36070s.size());//36070 168248
        System.out.println("  A+B总数量groupBy后:" + listMap36070.size());//36070 168248
        List<DrugVo> re = new ArrayList<>();
        list942.forEach((k, v) -> {
            listMap36070.forEach((m, n) -> {
                if (k.equals(m)) {
                    for (int i = 0; i < v.size(); i++) {
                        DrugVo942 drugVo942 = v.get(i);
                        DrugVo36070 drugVo36070 = n.get(0);
                        DrugVo drugVo = changeeeeee(drugVo36070, drugVo942);
                        re.add(drugVo);
                    }
                }
            });
        });
        List<DrugVo> zzzzzzzy = re.stream().sorted(Comparator.comparing(DrugVo::getA15)).collect(Collectors.toList());
        for (int m = 0; m < zzzzzzzy.size(); m++) {
            DrugVo drugVo = zzzzzzzy.get(m);
            drugVo.setA0((m + 1) + "");

            // 处理图片
            String a5 = drugVo.getA5();
            if (StringUtils.hasLength(a5)) {
                String[] split = a5.split(",");
                System.out.println("=====>执行第:" + m + "条数据,当前数据行有图片数量:" + split.length);
                String baseDir = "/Users/meihongliang/Working/xiaowan/doc/excel/0323/";
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < split.length; i++) {
                    String s = split[i];
                    String images = drugVo.getA15() + "_" + drugVo.getA3() + "_" + drugVo.getA16() + "_" + (i + 1) + ".jpg";
                    images = images.replace("/", "*");
                    // System.out.println(images);
                    try {
//                            downloadPicture(s, baseDir + "/" + images);
                    } catch (Exception e) {
                        System.out.println(s);
                        e.printStackTrace();
                    }
                    sb.append(images).append(",");
                }
                String substring = sb.substring(0, sb.lastIndexOf(","));
                drugVo.setA27(substring);
            }
        }
        File file2 = new File("/Users/meihongliang/Downloads/brother/另一个.xlsx");
        EasyExcel.write(file2, DrugVo.class).sheet("sheet_885").doWrite(zzzzzzzy);

//        List<DrugVo942> aaa = new ArrayList<>();
//        list942.forEach((k, v) -> {
//            aaa.addAll(v);
//        });
//        File file2 = new File("/Users/meihongliang/Downloads/zzzz/aaa.xlsx");
//        EasyExcel.write(file2, DrugVo942.class).sheet("sheet_377").doWrite(aaa);

        /**

         List<DrugVo> re = new ArrayList<>();
         List<DrugVo942> fu = new ArrayList<>();
         list942.forEach((k, v) -> {
         listMap36070.forEach((m, n) -> {
         if (m.equals(k)) {
         fu.add(v.get(0));
         //System.out.println(k);
         for (DrugVo942 drugVo942 : v) {
         for (DrugVo36070 drugVo36070 : n) {
         DrugVo drugVo = changeeeeee(drugVo36070, drugVo942);
         drugVo.setKey2(drugVo.getA15() + "_" + drugVo.getA16());
         drugVo.setKey3(drugVo.getA15() + "_" + drugVo.getA16() + "_" + drugVo.getA17());
         re.add(drugVo);
         }
         }
         }
         });
         });
         System.out.println(864 - 813);
         System.out.println("re.size()");
         System.out.println("re.size()" + re.size());
         Map<String, List<DrugVo>> collect = re.stream().collect(Collectors.groupingBy(DrugVo::getKey2));
         System.out.println(collect.size());
         List<DrugVo> zzzzzzzz = new ArrayList<>();
         collect.forEach((k, v) -> {
         zzzzzzzz.add(v.get(0));
         });
         List<DrugVo> zzzzzzzy = zzzzzzzz.stream().sorted(Comparator.comparing(DrugVo::getA15)).collect(Collectors.toList());

         //        File file2 = new File("/Users/meihongliang/Downloads/zzzz/zzzzzzzzz22.xlsx");
         //        EasyExcel.write(file2, DrugVo.class).sheet("sheet_377").doWrite(zzzzzzzy);


         for (DrugVo942 drugVo942 : drugVo942s) {
         drugVo942.setKey2(drugVo942.getA15() + "_" + drugVo942.getA16());
         }
         System.out.println("---456---");
         System.out.println(drugVo942s.size());
         System.out.println(zzzzzzzy.size());
         Iterator<DrugVo942> iterator = drugVo942s.iterator();
         while (iterator.hasNext()) {
         DrugVo942 next = iterator.next();
         Iterator<DrugVo942> iterator1 = fu.iterator();
         while (iterator1.hasNext()) {
         DrugVo942 next1 = iterator1.next();
         if (next.getA15().equals(next1.getA15())) {
         iterator.remove();
         }
         }
         }

         //        for (DrugVo942 drugVo942 : drugVo942s) {
         //            for (DrugVo drugVo : zzzzzzzy) {
         //                if (drugVo942.getKey2().equals(drugVo.getKey2())) {
         //                    drugVo942s.remove(drugVo942);
         //                }
         //            }
         //        }
         System.out.println("--123---");
         System.out.println(drugVo942s.size());
         List<DrugVo942> zzzzzzzyz = drugVo942s.stream().sorted(Comparator.comparing(DrugVo942::getA15)).collect(Collectors.toList());
         for (int i = 0; i < zzzzzzzyz.size(); i++) {
         DrugVo942 drugVo942 = zzzzzzzyz.get(i);
         drugVo942.setA0((i + 1) + "");
         }

         File file23333 = new File("/Users/meihongliang/Downloads/brother/未在大数据中匹配上批准文号.xlsx");
         EasyExcel.write(file23333, DrugVo942.class).sheet("sheet_377").doWrite(zzzzzzzyz);

         */
    }


    private static List<DrugVo942> get942() throws FileNotFoundException {
        System.out.println("5=================555========================");
        ExcelListener<DrugVo942> userListener55555 = new ExcelListener<>();
        String fileName36070_555 = "/Users/meihongliang/Downloads/xxxxx/xxxxx_942.xlsx";
        EasyExcel.read(new FileInputStream(fileName36070_555), DrugVo942.class, userListener55555).sheet().doRead();
        List<DrugVo942> allRow5555 = userListener55555.getObjs();
        System.out.println("942数量: " + allRow5555.size());
        return allRow5555;
    }

    private static List<DrugVo36070> get36070() throws FileNotFoundException {
        ExcelListener<DrugVo36070> userListener = new ExcelListener<>();
        String fileName36070 = "/Users/meihongliang/Downloads/xxxxx/xxxxx_A.xls";
        EasyExcel.read(new FileInputStream(fileName36070), DrugVo36070.class, userListener).sheet().doRead();
        List<DrugVo36070> allRow = userListener.getObjs();


        String fileName36070_2 = "/Users/meihongliang/Downloads/xxxxx/xxxxx_B.xls";
        EasyExcel.read(new FileInputStream(fileName36070_2), DrugVo36070.class, userListener).sheet().doRead();
        List<DrugVo36070> allRow_2 = userListener.getObjs();
        allRow.addAll(allRow_2);

        return allRow;
    }

    private static DrugVo changeeeeee(DrugVo36070 drugVo36070, DrugVo942 drugVo942) {
        DrugVo drugVo = new DrugVo();
        BeanUtils.copyProperties(drugVo942, drugVo);
        drugVo.setA3(drugVo36070.getA4());
        // 图片
        drugVo.setA5(drugVo36070.getA18());
        // 产品剂型
        drugVo.setA13(drugVo36070.getA6());
        drugVo.setA17(drugVo36070.getA5());
        // 价格
        drugVo.setA18(drugVo942.getA17());
        drugVo.setA19(drugVo36070.getA15());
        drugVo.setA20(drugVo36070.getA9());
        drugVo.setA21(drugVo36070.getA9());
        drugVo.setA22(drugVo36070.getA8());
        drugVo.setA26(drugVo942.getA25());
        drugVo.setA25(drugVo36070.getA11());
        return drugVo;
    }
}
