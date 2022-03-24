package cn.lanca.esaypoi.controller;

import cn.lanca.esaypoi.util.ExcelListener;
import cn.lanca.esaypoi.vo.DrugVo;
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
import java.util.List;

/**
 * project name:<font size="1"><b>小芄健康数据运营平台</b></font><br>
 * file name:<font size="1"><b>DictTemplate</b></font><br>
 * description:<font size="1"><b>平台字典数据操作实现类</b></font><br>
 * company name:<font size="1"><b>小芄医药科技（成都）有限公司-研发中心</b></font><br>
 *
 * @author <a href="mail to: ">mei.hongliang<br>
 * @version 1.0.0<br>
 * @since 2022/3/23 22:37  <br>
 */
public class DrugTest {

    public static void main(String[] args) throws FileNotFoundException {
        ExcelListener<DrugVo> userListener55555 = new ExcelListener<>();
        String fileName377 = "/Users/meihongliang/Downloads/院外377条（813筛出的相同药品）.xlsx";
        EasyExcel.read(new FileInputStream(fileName377), DrugVo.class, userListener55555).sheet().doRead();
        List<DrugVo> allRow5555 = userListener55555.getObjs();
        System.out.println(allRow5555.size());

//        StopWatch sw = new StopWatch("drug");
//        sw.start("task_1");

        for (int m = 0; m < allRow5555.size(); m++) {
            DrugVo drugVo = allRow5555.get(m);
            String a5 = drugVo.getA5();
//            sw.start("task_" + m);
            //  141 164 255  295  302
            //m == 140
            //                    || m == 164
            //                    || m == 255
            //                    || m == 295
            //                    || m == 302
            //
            if (true) {
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
                    // System.out.println(substring);
                }
            }
//            sw.stop();
//            System.out.println(sw.getTotalTimeSeconds() + "秒");
//            if (m == 5) {
//                break;
//            }
            // 141 164 255  295  302
        }

//        allRow5555
        File file2 = new File("/Users/meihongliang/Downloads/院外377条（813筛出的相同药品）_copy.xlsx");
        EasyExcel.write(file2, DrugVo.class).sheet("sheet_377").doWrite(allRow5555);

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
