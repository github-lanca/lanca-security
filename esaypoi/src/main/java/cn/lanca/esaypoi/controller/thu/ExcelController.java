package cn.lanca.esaypoi.controller;

import cn.lanca.esaypoi.util.ExcelListener;
import cn.lanca.esaypoi.vo.v0.DrugVo;
import cn.lanca.esaypoi.vo.v0.DrugVo36070;
import cn.lanca.esaypoi.vo.v0.DrugVo916;
import cn.lanca.esaypoi.vo.v0.DrugVo942;
import cn.lanca.esaypoi.vo.v0.DrugVo_Copy;
import com.alibaba.excel.EasyExcel;
import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * project name:<font size="1"><b>小芄健康数据运营平台</b></font><br>
 * file name:<font size="1"><b>DictTemplate</b></font><br>
 * description:<font size="1"><b>平台字典数据操作实现类</b></font><br>
 * company name:<font size="1"><b>小芄医药科技（成都）有限公司-研发中心</b></font><br>
 *
 * @author <a href="mail to: ">mei.hongliang<br>
 * @version 1.0.0<br>
 * @since 2022/3/22 17:26  <br>
 */
@RestController
public class ExcelController {

    //        Map<String, DrugVo> map942 = get36070();

//        ExcelUtils.export2Web(response, "组装后数据.xlsx", "homh_drug", DrugVo.class, objs);

//        Map<String, DrugVo> map942 = get942();
//        System.out.println(map942.size());
//        Map<String, DrugVo> map916 = get916();
//        System.out.println(map916.size());
//        Map<String, DrugVo> hashMap = new HashMap<>();
//
//        map916.forEach((k, v) -> {
//            map942.forEach((m, n) -> {
//                if (m.equals(k)){
//                    hashMap.put(m,n);
//                }
//            });
//        });
//        System.out.println(hashMap.size());

//        get942();
    // 甲巯咪唑片_国药准字J20171078_10mg*50片(薄膜衣)
//        Map<String, DrugVo916> stringDrugVo916Map = get916();
//        Set<String> sKey916 = stringDrugVo916Map.keySet();
//        System.out.println("916:" + stringDrugVo916Map.size());


    // 国药准字J20171071_屈螺酮炔雌醇片_21片/盒
//        Map<String, DrugVo36070> stringDrugVo36070Map = get36070();
//
//        Map<String, DrugVo36070> resultMap = new HashMap<>();
//        stringDrugVo916Map.forEach((k, v) -> {
//            stringDrugVo36070Map.forEach((m, n) -> {
//                if (k.equals(m)) {
//                    System.out.println("==相等==" + k);
//                    resultMap.put(k, n);
//                }
//            });
//        });
//        System.out.println("36070: " + stringDrugVo36070Map.size());
//        System.out.println("resultMap: " + resultMap.size());


    // OTC药品系列 copy.xlsx
//        String fileName = "/Users/meihongliang/Downloads/OTC药品系列 copy.xlsx";
    // String fileName36070 = "/Users/meihongliang/Downloads/OTC药品系列.xls";
//        String fileName36070 = "/Users/meihongliang/Downloads/OTC药品系列-数据表.xls";
    // String fileName916 = "/Users/meihongliang/Downloads/福源店-院外916已排重（1）.xlsx";

//        List<DrugVo> all916 = get916();
//        Map<String, DrugVo> map = new HashMap<>();
//        ExcelListener<DrugVo> userListener = new ExcelListener<DrugVo>();
//        String fileName942 = "/Users/meihongliang/Downloads/942.xlsx";
//        EasyExcel.read(new FileInputStream(fileName942), DrugVo.class, userListener).sheet().doRead();
//        List<DrugVo> allRow = userListener.getObjs();
//        System.out.println("===========" + fileName942.substring(fileName942.lastIndexOf("/") + 1) + "===========总数: " + allRow.size());
//        for (int i = 0; i < allRow.size(); i++) {
//            DrugVo drugVo = allRow.get(i);
//            String sKey = drugVo.getA2() + "_" + drugVo.getA16() + "_" + drugVo.getA17();
//            //System.out.println(i + "_" + sKey);
//            map.put(sKey, drugVo);
//        }
//        System.out.println(map.size());
//        map.forEach((k,v)->{
//            String s = v.getA2() + "_" + v.getA16() + "_" + v.getA17();
//            System.out.println(s);
//        });

    //批量新增，文件解析
    @RequestMapping("/fileUpload")
    public void fileUpload(HttpServletRequest request, HttpServletResponse response) throws IOException {
    }

    public static void main(String[] args) throws FileNotFoundException {
//        compare();
//        get942();
        getXxxx();
//        getyyyyy();
    }


    private static void compare() throws FileNotFoundException {
        System.out.println("1=================916key========================");
        //Map<String, DrugVo916> map916 = new HashMap<>();
        ExcelListener<DrugVo942> userListener916 = new ExcelListener<>();
        String fileName916 = "/Users/meihongliang/Downloads/xxxxx_942.xlsx";
        EasyExcel.read(new FileInputStream(fileName916), DrugVo942.class, userListener916).sheet().doRead();
        List<DrugVo942> list942 = userListener916.getObjs();

        System.out.println(list942.get(5));

        Map<String, DrugVo942> map916 = new HashMap<>();
        list942.forEach(e -> {
            System.out.println(e.getA3());
//            map916.put(e.getA3() + "_" + e.getA4(), e);
            map916.put(e.getA15(), e);
        });

//        System.out.println("===========" + fileName916.substring(fileName916.lastIndexOf("/") + 1) + "===========总数: " + list916.size());
//        System.out.println(list916.get(5));


        Map<String, DrugVo36070> map36070 = new HashMap<>();
        System.out.println("2=================2222key========================");
        ExcelListener<DrugVo36070> userListener2222 = new ExcelListener<>();
        String fileName36070 = "/Users/meihongliang/Downloads/xxxxx_A.xls";
        EasyExcel.read(new FileInputStream(fileName36070), DrugVo36070.class, userListener2222).sheet().doRead();
        List<DrugVo36070> allRow22222 = userListener2222.getObjs();
        allRow22222.forEach(e -> {
//            map36070.put(e.getA10() + "_" + e.getA5(), e);
            map36070.put(e.getA10(), e);
        });
        System.out.println("===========" + fileName36070.substring(fileName36070.lastIndexOf("/") + 1) + "===========总数: " + allRow22222.size());
//        System.out.println(allRow22222.get(5));


        System.out.println("3=================3333key========================");
        ExcelListener<DrugVo36070> userListener33333 = new ExcelListener<>();
//        String fileName36070_333 = "/Users/meihongliang/Downloads/OTC药品系列-数据表.xls";
        String fileName36070_333 = "/Users/meihongliang/Downloads/xxxxx_B.xls";
        EasyExcel.read(new FileInputStream(fileName36070_333), DrugVo36070.class, userListener33333).sheet().doRead();
        List<DrugVo36070> allRow33333 = userListener33333.getObjs();
        allRow33333.forEach(e -> {
//            map36070.put(e.getA10() + "_" + e.getA5(), e);
            map36070.put(e.getA10(), e);
        });
//
//        System.out.println("===========" + fileName36070_333.substring(fileName36070_333.lastIndexOf("/") + 1) + "===========总数: " + allRow33333.size());
//        System.out.println(allRow33333.get(5));

        System.out.println("5=================555========================");
        ExcelListener<DrugVo36070> userListener55555 = new ExcelListener<>();
//        String fileName36070_333 = "/Users/meihongliang/Downloads/OTC药品系列-数据表.xls";
        String fileName36070_555 = "/Users/meihongliang/Downloads/xxxxx_942.xls";
        EasyExcel.read(new FileInputStream(fileName36070_555), DrugVo36070.class, userListener55555).sheet().doRead();
        List<DrugVo36070> allRow5555 = userListener55555.getObjs();
        allRow5555.forEach(e -> {
//            map36070.put(e.getA10() + "_" + e.getA5(), e);
            map36070.put(e.getA10(), e);
        });


        System.out.println("=================size==============");
        System.out.println(map916.size());
        System.out.println(map36070.size());

        HashSet<String> hashSet = new HashSet<>();
        map916.forEach((k, v) -> {
            map36070.forEach((m, n) -> {
                if (m.equals(k)) {
                    System.out.println("=相等=" + k);
                    hashSet.add(k);
                }
            });
        });
        System.out.println("相等的数量: " + hashSet.size());

    }

    private static List<DrugVo36070> get36070() throws FileNotFoundException {
        //
        Map<String, DrugVo36070> map36070 = new ConcurrentHashMap<>();
        ExcelListener<DrugVo36070> userListener = new ExcelListener<>();
        String fileName36070 = "/Users/meihongliang/Downloads/xxxxx/xxxxx_A.xls";
        EasyExcel.read(new FileInputStream(fileName36070), DrugVo36070.class, userListener).sheet().doRead();
        List<DrugVo36070> allRow = userListener.getObjs();


        System.out.println("===========" + fileName36070.substring(fileName36070.lastIndexOf("/") + 1) + "===========总数: " + allRow.size());
        for (int i = 0; i < allRow.size(); i++) {
            DrugVo36070 drugVo = allRow.get(i);
//            String sKey = drugVo.getA10() + "_" + drugVo.getA4() + "_" + drugVo.getA5();
//            String sKey = drugVo.getA10() + "_" + drugVo.getA5();
            String sKey = drugVo.getA10();
//            System.out.println(drugVo);
//            System.out.println((i + 1) + "_" + sKey);
            map36070.put(sKey, drugVo);
        }

        // --

        String fileName36070_2 = "/Users/meihongliang/Downloads/xxxxx/xxxxx_B.xls";
        EasyExcel.read(new FileInputStream(fileName36070_2), DrugVo36070.class, userListener).sheet().doRead();
        List<DrugVo36070> allRow_2 = userListener.getObjs();
        allRow.addAll(allRow_2);

//        System.out.println("===========" + fileName36070_2.substring(fileName36070_2.lastIndexOf("/") + 1) + "===========总数: " + allRow.size());
//        for (int i = 0; i < allRow_2.size(); i++) {
//            DrugVo36070 drugVo = allRow_2.get(i);
////            String sKey = drugVo.getA10() + "_" + drugVo.getA4() + "_" + drugVo.getA5();
////            String sKey = drugVo.getA10() + "_" + drugVo.getA5();
////            System.out.println(drugVo);
////            System.out.println((i + 1) + "_" + sKey);
//            String sKey = drugVo.getA10();
//            map36070.put(sKey, drugVo);
//        }
//        File file = new File("/Users/meihongliang/Downloads/36070.xlsx");
//        EasyExcel.write(file, DrugVo36070.class).sheet("sheet_1").doWrite(allRow);
        System.out.println("allRow: " + allRow.size());
//        return map36070;
        return allRow;
    }


    private static List<DrugVo942> get942() throws FileNotFoundException {
        System.out.println("5=================555========================");
        Map<String, DrugVo942> resultMap = new HashMap<>();

        ExcelListener<DrugVo942> userListener55555 = new ExcelListener<>();
        String fileName36070_555 = "/Users/meihongliang/Downloads/xxxxx/xxxxx_942.xlsx";
        EasyExcel.read(new FileInputStream(fileName36070_555), DrugVo942.class, userListener55555).sheet().doRead();
        List<DrugVo942> allRow5555 = userListener55555.getObjs();
        //            map36070.put(e.getA10() + "_" + e.getA5(), e);
        //            map36070.put(e.getA10(), e);
        System.out.println("942数量: " + allRow5555.size());
//        allRow5555.forEach(e -> {
//            resultMap.put(e.getA15(), e);
//        });
//        return resultMap;
        return allRow5555;
    }

    public static void getyyyyy() throws FileNotFoundException {
        // #1.拿942的国药key，国药准字Z19991031
        List<DrugVo942> drugVo942s = get942();
        List<DrugVo36070> drugVo36070s = get36070();
        System.out.println("----------------------------------------------------------------");
        System.out.println("list,942: " + drugVo942s.size());
        Map<String, List<DrugVo942>> list942 = drugVo942s.stream().collect(Collectors.groupingBy(DrugVo942::getA15));
        list942.forEach((k, v) -> {
            if (v.size() != 1) {
                System.out.println(k + "    k|" + v.size());
            }
        });

//
//        Map<String, List<DrugVo36070>> listMap36070 = drugVo36070s.stream().collect(Collectors.groupingBy(DrugVo36070::getA10));
//        System.out.println(list942.size());//864
//        System.out.println(listMap36070.size());//35582
//        List<DrugVo36070> oooo = new ArrayList<>();
//        HashSet<String> hashSet = new HashSet<>();
//        list942.forEach((k, v) -> {
//            listMap36070.forEach((m, n) -> {
//                if (k.equals(m)) {
//                    System.out.println(m + "  m|" + n.size());
//                    hashSet.add(k);
//                    oooo.addAll(n);
//                }
//            });
//        });
//        System.out.println("hhhhhhh " + hashSet.size());
//        System.out.println("PPPPPPP " + oooo.size());


    }


    /**
     * @throws FileNotFoundException
     */
    public static void getXxxx() throws FileNotFoundException {
        // #1.拿942的国药key，国药准字Z19991031
        List<DrugVo942> drugVo942s = get942();
        List<DrugVo36070> drugVo36070s = get36070();


        System.out.println("----------------------------------------------------------------");
        System.out.println("总数量: " + drugVo942s.size());
        Map<String, List<DrugVo942>> list942 = drugVo942s.stream().collect(Collectors.groupingBy(DrugVo942::getA15));
        Map<String, List<DrugVo36070>> listMap36070 = drugVo36070s.stream().collect(Collectors.groupingBy(DrugVo36070::getA10));

        System.out.println("分组后的数量: " + list942.size());//864
        List<DrugVo942> w = new ArrayList<>();
        list942.forEach((k, v) -> {
            // System.out.println(k + "      k|" + v.size());
            w.addAll(v);
        });

        System.out.println("w_" + w.size());

        System.out.println(listMap36070.size());//35582
        List<DrugVo> re = new ArrayList<>();
        List<DrugVo> re2 = new ArrayList<>();
        List<DrugVo> abccccccc = new ArrayList<>();

        HashSet<String> hashSet = new HashSet<>();

        list942.forEach((k, v) -> {
            listMap36070.forEach((m, n) -> {
                if (k.equals(m)) {

                    DrugVo942 drugVo942 = v.get(0);
                    DrugVo36070 drugVo36070 = n.get(0);
                    DrugVo drugVo = changeeeeee(drugVo36070, drugVo942);
                    re.add(drugVo);
//
////                     批准文号 相同
////                    System.out.println(k + " k|v " + v.size());
////                    System.out.println(k + " m|n " + n.size());
//
////                    for (int i = 0; i < v.size(); i++) {
////                        DrugVo942 drugVo942 = v.get(i);
//////                        DrugVo942 drugVo942 = v.get(0);
////                        DrugVo36070 drugVo36070 = n.get(0);
////                        DrugVo drugVo = changeeeeee(drugVo36070, drugVo942);
////                        re.add(drugVo);
////                    }
//
//                    if (v.size() == 1) {
//                        DrugVo942 drugVo942 = v.get(0);
//                        DrugVo36070 drugVo36070 = n.get(0);
//                        DrugVo drugVo = changeeeeee(drugVo36070, drugVo942);
//                        re.add(drugVo);
//                    }
//                    if (v.size() > 1) {
//                        //
//                        List<DrugVo> xxx = new ArrayList<>();
//                        for (int i = 0; i < v.size(); i++) {
//                            DrugVo942 drugVo942 = v.get(i);
//                            DrugVo36070 drugVo36070 = n.get(0);
//                            DrugVo drugVo = changeeeeee(drugVo36070, drugVo942);
//                            xxx.add(drugVo);
//                        }
//                        re2.addAll(xxx);
//                    }
                }
            });
        });



        System.out.println("hashSet.size() " + hashSet.size());


        List<DrugVo942> bbb = new ArrayList<>();
        list942.forEach((k, v) -> {
            hashSet.forEach(e -> {
                if (e.equals(k)) {
                    bbb.add(v.get(0));
                }
            });
        });


        for (int i = 0; i < re.size(); i++) {
            DrugVo drugVo = re.get(i);
            drugVo.setA0((i + 1) + "");
        }

//        for (int i = 0; i < abccccccc.size(); i++) {
//            DrugVo drugVo = abccccccc.get(i);
//            drugVo.setA0((i + 1) + "");
//        }
//
//        File file1 = new File("/Users/meihongliang/Downloads/yyyyy/同批次多规格_B.xlsx");
//        EasyExcel.write(file1, DrugVo942.class).sheet("sheet_B").doWrite(re2);
//
//
//        File file2 = new File("/Users/meihongliang/Downloads/yyyyy/同批次多规格_A.xlsx");
//        EasyExcel.write(file2, DrugVo.class).sheet("sheet_A").doWrite(re);


        // #3。生成excel
//        File file = new File("/Users/meihongliang/Downloads/20220323_36070.xlsx");
//        EasyExcel.write(file, DrugVo36070.class).sheet("sheet_1").doWrite(resultList);


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


    private static DrugVo_Copy change(DrugVo36070 drugVo36070) {
        DrugVo_Copy drugVo = new DrugVo_Copy();
        String a0 = drugVo36070.getA0();
        return null;
    }

    private static Map<String, DrugVo916> get916() throws FileNotFoundException {

        Map<String, DrugVo916> map916 = new HashMap<>();
        ExcelListener<DrugVo916> userListener = new ExcelListener<>();
        String fileName916 = "/Users/meihongliang/Downloads/福源店-院外916已排重（1）.xlsx";
        EasyExcel.read(new FileInputStream(fileName916), DrugVo916.class, userListener).sheet().doRead();
        List<DrugVo916> allRow = userListener.getObjs();

        System.out.println("===========" + fileName916.substring(fileName916.lastIndexOf("/") + 1) + "===========总数: " + allRow.size());
        for (int i = 0; i < allRow.size(); i++) {
            DrugVo916 drugVo = allRow.get(i);
            String sKey = drugVo.getA3() + "_" + drugVo.getA4();
//            String sKey = drugVo.getA3();
//            System.out.println(drugVo);
            System.out.println((i + 1) + "_" + sKey);
            map916.put(sKey, drugVo);
        }

//        File file = new File("/Users/meihongliang/Downloads/916916916.xlsx");
//        EasyExcel.write(file, DrugVo916.class).sheet("sheet_1").doWrite(allRow);

        // EasyExcel.writerSheet("sheet_1").
        return map916;
    }

    /**
     * 生成文件夹和图片
     */
    public void createImage() throws FileNotFoundException {
        ExcelListener<DrugVo36070> userListener = new ExcelListener<>();
        String fileName942 = "/Users/meihongliang/Downloads/942.xlsx";
        EasyExcel.read(new FileInputStream(fileName942), DrugVo36070.class, userListener).sheet().doRead();
        List<DrugVo36070> objs = userListener.getObjs();
        for (int m = 0; m < objs.size(); m++) {
            System.out.println("当前==:" + m);
            DrugVo36070 obj = objs.get(m);
            //
            String a4 = obj.getA4();
            String a5 = obj.getA5();
            // 国药准字Z19983104
            String a10 = obj.getA10();
            String name = a10 + a4 + a5;
            String dirName = name.replace("/", "*");

            String images = obj.getA18();
            if (StringUtils.hasLength(images)) {
                String[] split = images.split(",");
                String newDir = "/Users/meihongliang/Working/xiaowan/doc/excel/0323/" + dirName;
                File file = new File(newDir);
                if (!file.exists()) {
                    boolean mkdir = file.mkdir();
                    System.out.println("创建文件夹 " + newDir);
                    if (mkdir) {
                        for (int i = 0; i < split.length; i++) {
                            String s = split[i];
                            String imageName = newDir + "/" + dirName + "_" + (i + 1) + ".jpg";
                            // downloadPicture(s, imageName);
                            System.out.println(imageName);
                        }
                        System.out.println();
                    }
                }
            }
        }
    }


    //链接url下载图片
    private static void downloadPicture(String urlList, String path) {
        URL url = null;
        try {
            url = new URL(urlList);
            DataInputStream dataInputStream = new DataInputStream(url.openStream());

            FileOutputStream fileOutputStream = new FileOutputStream(new File(path));
            ByteArrayOutputStream output = new ByteArrayOutputStream();

            byte[] buffer = new byte[1024];
            int length;

            while ((length = dataInputStream.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
            //返回Base64编码过的字节数组字符串
//            BASE64Encoder encoder = new BASE64Encoder();
//            String encode = encoder.encode(buffer);
            fileOutputStream.write(output.toByteArray());
            dataInputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
