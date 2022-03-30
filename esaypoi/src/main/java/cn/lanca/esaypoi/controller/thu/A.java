package cn.lanca.esaypoi.controller;

import cn.lanca.esaypoi.util.ExcelListener;
import cn.lanca.esaypoi.vo.v0.ExportVo;
import com.alibaba.excel.EasyExcel;
import org.springframework.util.StringUtils;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * project name:<font size="1"><b>小芄健康数据运营平台</b></font><br>
 * file name:<font size="1"><b>DictTemplate</b></font><br>
 * description:<font size="1"><b>平台字典数据操作实现类</b></font><br>
 * company name:<font size="1"><b>小芄医药科技（成都）有限公司-研发中心</b></font><br>
 *
 * @author <a href="mail to: ">mei.hongliang<br>
 * @version 1.0.0<br>
 * @since 2022/3/24 15:56  <br>
 */
public class A {
    public static void main(String[] args) throws FileNotFoundException {
        String baseDir = "/Users/meihongliang/Downloads/thu/17/";
        List<ExportVo> exportVos = get();
        List<ExportVo> result = new ArrayList<>();
        for (int i = 0; i < exportVos.size(); i++) {
//            if (i == 5) {
            ExportVo exportVo = exportVos.get(i);
            if (exportVo != null) {
                exportVo.setA0(i+"");
                exportVo.setA1(i+"");
                String s1 = exportVo.getA30() + "_" + exportVo.getA33() + "_" + exportVo.getA35();
                // images
                String images = s1.replace("*", "x")
                        .replace(" ", "")
                        .replace(":", "x")
                        .replace("", "")
                        .replace("/", "x");
                String imageList = exportVo.getA44();
                if (StringUtils.hasLength(imageList)) {
                    imageList = imageList.replace("*", "x").replace(" ", "");
                    if (StringUtils.hasLength(imageList)) {
                        String[] imageUrl = imageList.split(",");
                        StringBuilder sb = new StringBuilder();
                        System.out.println("开始执行第" + (i + 1) + "条数据,图片数量:" + imageUrl.length);
                        for (int m = 0; m < imageUrl.length; m++) {
                            String urlName = images + "_" + (m + 1);
                            String urlNameWithJpg = urlName + ".jpg";
                            String urlPath = baseDir + urlNameWithJpg;

//                    System.out.println(urlName);
//                    System.out.println(urlPath);
                            String url = imageUrl[m];
                            try {
                                downloadPicture(url, urlPath);
                            } catch (Exception e) {
//                        System.out.println(url);
                                e.printStackTrace();
                            }
                            // 处理图片名称字段
                            sb.append(urlName).append(";");
                        }
                        String substring = sb.substring(0, sb.lastIndexOf(";"));
                        System.out.println(substring);
                        exportVo.setA7(substring);
                        exportVo.setA6("");
                        exportVo.setA8("");
                        exportVo.setA11("");
                        exportVo.setA12("");
                        exportVo.setA13("");
                        exportVo.setA14("");
                        exportVo.setA15("");
                        exportVo.setA16("");
                        exportVo.setA18("");
                        exportVo.setA19("");
                        exportVo.setA20("");
                        exportVo.setA23("");
                        exportVo.setA24("");
                        exportVo.setA25("");
                        exportVo.setA26("");
                        exportVo.setA27("");
                        exportVo.setA28("");
                        exportVo.setA36("");
                        exportVo.setA37("");
                        exportVo.setA38("");
                        exportVo.setA39("");
                        exportVo.setA40("");
                        exportVo.setA41("");
                        exportVo.setA42("");
                        exportVo.setA43("");
                        result.add(exportVo);
                    }
                }
            }
        }

        //
        System.out.println("==" + result.size());
        File file2 = new File("/Users/meihongliang/Downloads/院外-17_new.xlsx");
        EasyExcel.write(file2, ExportVo.class).sheet("17_new").doWrite(result);
    }

    private static List<ExportVo> get() throws FileNotFoundException {
        ExcelListener<ExportVo> userListener55555 = new ExcelListener<>();
//        String fileName36070_555 = "/Users/meihongliang/Downloads/导入失败表289.xlsx";
        String fileName36070_555 = "/Users/meihongliang/Downloads/院外-17.xlsx";
        EasyExcel.read(new FileInputStream(fileName36070_555), ExportVo.class, userListener55555).sheet().doRead();
        List<ExportVo> objs = userListener55555.getObjs();
        return objs;
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
            fileOutputStream.write(output.toByteArray());
            dataInputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
