package cn.lanca.esaypoi.controller;

import cn.lanca.esaypoi.util.ExcelListener;
import cn.lanca.esaypoi.vo.DrugVo36070;
import cn.lanca.esaypoi.vo.DrugVo916;
import cn.lanca.esaypoi.vo.DrugVo942;
import com.alibaba.excel.EasyExcel;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    //批量新增，文件解析
    @RequestMapping("/fileUpload")
    public void fileUpload(HttpServletRequest request, HttpServletResponse response) throws IOException {
    }

    public static void main(String[] args) throws FileNotFoundException {

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
//        get916();
        get36070();


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

    }

    private static Map<String, DrugVo36070> get36070() throws FileNotFoundException {
        //
        Map<String, DrugVo36070> map36070 = new HashMap<>();
        ExcelListener<DrugVo36070> userListener = new ExcelListener<>();
        String fileName36070 = "/Users/meihongliang/Downloads/OTC药品系列.xls";
        EasyExcel.read(new FileInputStream(fileName36070), DrugVo36070.class, userListener).sheet().doRead();
        List<DrugVo36070> allRow = userListener.getObjs();
        System.out.println("===========" + fileName36070.substring(fileName36070.lastIndexOf("/") + 1) + "===========总数: " + allRow.size());
        for (int i = 0; i < allRow.size(); i++) {
            DrugVo36070 drugVo = allRow.get(i);
            String sKey = drugVo.getA10() + "_" + drugVo.getA4() + "_" + drugVo.getA5();
//            System.out.println(drugVo);
            System.out.println((i + 1) + "_" + sKey);
            map36070.put(sKey, drugVo);
        }
        File file = new File("/Users/meihongliang/Downloads/36070.xlsx");
        EasyExcel.write(file, DrugVo36070.class).sheet("sheet_1").doWrite(allRow);
        return map36070;
    }


    private static Map<String, DrugVo942> get942() throws FileNotFoundException {
        Map<String, DrugVo942> map42 = new HashMap<>();
        ExcelListener<DrugVo942> userListener = new ExcelListener<>();
        String fileName942 = "/Users/meihongliang/Downloads/942.xlsx";
        EasyExcel.read(new FileInputStream(fileName942), DrugVo942.class, userListener).sheet().doRead();
        List<DrugVo942> allRow = userListener.getObjs();
        System.out.println("===========" + fileName942.substring(fileName942.lastIndexOf("/") + 1) + "===========总数: " + allRow.size());
        for (int i = 0; i < allRow.size(); i++) {
            DrugVo942 drugVo = allRow.get(i);
            String sKey = drugVo.getA2() + "_" + drugVo.getA16() + "_" + drugVo.getA17();
            System.out.println(drugVo);
//            System.out.println((i + 1) + "_" + sKey);
            map42.put(sKey, drugVo);
        }
        return map42;
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
            String sKey = drugVo.getA2() + "_" + drugVo.getA3() + "_" + drugVo.getA4();
//            System.out.println(drugVo);
            System.out.println((i + 1) + "_" + sKey);
            map916.put(sKey, drugVo);
        }

        File file = new File("/Users/meihongliang/Downloads/916916916.xlsx");
        EasyExcel.write(file, DrugVo916.class).sheet("sheet_1").doWrite(allRow);

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
                String newDir = "/Users/meihongliang/Working/xiaowan/doc/excel/0322/" + dirName;
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
