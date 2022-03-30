package cn.lanca.esaypoi.controller;

import cn.lanca.esaypoi.util.ExcelListener;
import cn.lanca.esaypoi.vo.v0.DrugVo;
import com.alibaba.excel.EasyExcel;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
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
 * @since 2022/3/24 10:56  <br>
 */
public class Test436Co {

    // File file2 = new File("/Users/meihongliang/Downloads/thu/436/436_2178_1290_497_148_4.xlsx");
    //        EasyExcel.write(file2, DrugVo.class).sheet("z444444_148_4").doWrite(sortList);

    public static void main(String[] args) throws FileNotFoundException {

        List<DrugVo> drugVos436 = get436();
        System.out.println(drugVos436.size());
        Map<String, List<DrugVo>> collect2 = drugVos436.stream().collect(Collectors.groupingBy(DrugVo::getA15));
        System.out.println("======" + collect2.size());

        List<DrugVo> drugVos = get2178();
        System.out.println(drugVos.size());
        Map<String, List<DrugVo>> collect = drugVos.stream().collect(Collectors.groupingBy(DrugVo::getA15));
        System.out.println("=" + collect.size());

        HashSet hashSet = new HashSet();
        List<DrugVo> need = new ArrayList<>();
        System.out.println("前 "+drugVos436.size());
        Iterator<DrugVo> iterator = drugVos436.iterator();
        while (iterator.hasNext()) {
            DrugVo next = iterator.next();
            collect.forEach((k, v) -> {
                if (next.getA15().equals(k)) {
                    System.out.println("--->" + k);
                    need.add(v.get(0));
                    //iterator.remove();
                }
            });
        }
        System.out.println("后 "+need.size());
//        List<DrugVo> drugVos = get1290();
//        Map<String, List<DrugVo>> collect = drugVos.stream().collect(Collectors.groupingBy(DrugVo::getKey3));
//        List<DrugVo> result = new ArrayList<>();
//        collect.forEach((k, v) -> {
//            result.add(v.get(0));
//        });

        System.out.println(need.size());
        List<DrugVo> sortList = need.stream().sorted(Comparator.comparing(DrugVo::getA15)).collect(Collectors.toList());
        File file2 = new File("/Users/meihongliang/Downloads/thu/436/436_185_1.xlsx");
        EasyExcel.write(file2, DrugVo.class).sheet("436_185_1").doWrite(sortList);
    }


    public static void xx497to148() throws FileNotFoundException {
        List<DrugVo> drugVos = get2178();
        System.out.println("436_2178: " + drugVos.size());

//         List<DrugVo> drug8642 = get8642();
        List<DrugVo> result = new ArrayList<>();
        List<DrugVo> no = new ArrayList<>();

        Map<String, List<DrugVo>> collect = drugVos.stream().collect(Collectors.groupingBy(DrugVo::getKey3));
        Map<String, List<DrugVo>> collect2 = drugVos.stream().collect(Collectors.groupingBy(DrugVo::getKey2));
        System.out.println("_" + collect2.size());
        collect2.forEach((k, v) -> {
            no.add(v.get(0));
            System.out.println(k + "_|_" + v.size());
        });
//        collect.forEach((k, v) -> {
//            result.add(v.get(0));
//            System.out.println(k + "_|_" + v.size());
//        });

//        drugVos.forEach(e -> {
//            System.out.println(e.getKey3());
//            result.add(e);
//
//            // [0-9]+
////            String patternxx = "[0-9]+";
////            Pattern pattern = Pattern.compile(patternxx);
////            Matcher matcher = pattern.matcher(e.getA16());
////            if (matcher.find()) {
////                String group = matcher.group();
////                if (e.getA17().contains(group)) {
////                    System.out.println(e.getA17() + "_|_" + e.getA16());
////                    result.add(e);
////                } else {
////                    no.add(e);
////                }
////            } else {
////                System.out.println("!matcher.find()");
////            }
//
//        });
        // -
        System.out.println("Total:" + drugVos.size());
        System.out.println("result:" + result.size());
        System.out.println("no:" + no.size());
        List<DrugVo> sortList = no.stream().sorted(Comparator.comparing(DrugVo::getA15)).collect(Collectors.toList());

//        File file1 = new File("/Users/meihongliang/Downloads/thu/436/436zzzz_497.xlsx");
//        EasyExcel.write(file1, DrugVo.class).sheet("z444444_497").doWrite(result);
        File file2 = new File("/Users/meihongliang/Downloads/thu/436/436_2178_1290_497_148_4.xlsx");
        EasyExcel.write(file2, DrugVo.class).sheet("z444444_148_4").doWrite(sortList);
    }


    private static List<DrugVo> get2178() throws FileNotFoundException {
        ExcelListener<DrugVo> userListener55555 = new ExcelListener<>();
        String fileName36070_555 = "/Users/meihongliang/Downloads/thu/436/A_436_185_2178.xlsx";
        EasyExcel.read(new FileInputStream(fileName36070_555), DrugVo.class, userListener55555).sheet().doRead();
        List<DrugVo> objs = userListener55555.getObjs();
        objs.forEach(e -> e.setKey2(e.getA15() + "_" + e.getA16()));
        objs.forEach(e -> e.setKey3(e.getA15() + "_" + e.getA16() + "_" + e.getA17()));
        return objs;
    }

    private static List<DrugVo> get1290() throws FileNotFoundException {
        ExcelListener<DrugVo> userListener55555 = new ExcelListener<>();
        String fileName36070_555 = "/Users/meihongliang/Downloads/thu/436/436_2178_1290_2.xlsx";
        EasyExcel.read(new FileInputStream(fileName36070_555), DrugVo.class, userListener55555).sheet().doRead();
        List<DrugVo> objs = userListener55555.getObjs();
        objs.forEach(e -> e.setKey2(e.getA15() + "_" + e.getA16()));
        objs.forEach(e -> e.setKey3(e.getA15() + "_" + e.getA16() + "_" + e.getA17()));
        return objs;
    }

    private static List<DrugVo> get436() throws FileNotFoundException {
        ExcelListener<DrugVo> userListener55555 = new ExcelListener<>();
        String fileName36070_555 = "/Users/meihongliang/Downloads/thu/436/带图片原_436.xlsx";
        EasyExcel.read(new FileInputStream(fileName36070_555), DrugVo.class, userListener55555).sheet().doRead();
        List<DrugVo> objs = userListener55555.getObjs();
        objs.forEach(e -> e.setKey2(e.getA15() + "_" + e.getA16()));
        return objs;
    }

    private static List<DrugVo> get8642_2() throws FileNotFoundException {
        ExcelListener<DrugVo> userListener55555 = new ExcelListener<>();
        String fileName36070_555 = "/Users/meihongliang/Downloads/zzzz/根据批次文号匹配的全部8642.xlsx";
        EasyExcel.read(new FileInputStream(fileName36070_555), DrugVo.class, userListener55555).sheet().doRead();
        List<DrugVo> objs = userListener55555.getObjs();
        objs.forEach(e -> e.setKey2(e.getA15() + "_" + e.getA16()));
        return objs;
    }

    private static List<DrugVo> get8642() throws FileNotFoundException {
        ExcelListener<DrugVo> userListener55555 = new ExcelListener<>();
        String fileName36070_555 = "/Users/meihongliang/Downloads/brother/zzzzzz_8642.xlsx";
        EasyExcel.read(new FileInputStream(fileName36070_555), DrugVo.class, userListener55555).sheet().doRead();
        List<DrugVo> objs = userListener55555.getObjs();
        objs.forEach(e -> e.setKey2(e.getA15() + "_" + e.getA16()));
        // objs.forEach(e -> e.setKey3(e.getA15() + "_" + e.getA16() + "_" + e.getA17()));
        return objs;
    }

    private void xx() throws FileNotFoundException {
        // 处理图片字段 名称
        List<DrugVo> drugVos = get436();
        for (int m = 0; m < drugVos.size(); m++) {
            DrugVo drugVo = drugVos.get(m);
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
    }
}
