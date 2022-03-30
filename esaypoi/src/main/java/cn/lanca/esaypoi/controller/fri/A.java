package cn.lanca.esaypoi.controller.fri;

import cn.lanca.esaypoi.util.ExcelListener;
import cn.lanca.esaypoi.vo.v0.DrugVo;
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
 * @since 2022/3/25 11:44  <br>
 */
public class A {
    public static void main(String[] args) throws FileNotFoundException {
        String baseDir = "/Users/meihongliang/Downloads/fri/97/";
        // #1.先读
        List<DrugVo> list = get96();
        // #2。处理数据
//        System.out.println(list.get(0));

        for (int i = 0; i < list.size(); i++) {
            DrugVo drugVo = list.get(i);
            // ,
            String imageStr = drugVo.getA5();
            if (StringUtils.hasLength(imageStr)) {
                String nameArr = drugVo.getA15() + "_" + drugVo.getA3() + "_" + drugVo.getA16() + "_";
                String picNamePre = nameArr
                        .replace(" ", "")
                        .replace("/", "x")
                        .replace("?", "x")
                        .replace(":", "");
                // System.out.println(picNamePre);

                String[] split = imageStr.split(",");
                StringBuilder stringBuilder = new StringBuilder();
                System.out.println("第" + (i + 1) + "条开始生成图片,共计" + split.length + "条图片");
                for (int i1 = 0; i1 < split.length; i1++) {
                    String picName = picNamePre + (i1 + 1);
                    String url = split[i1];
                    // 国药准字Z51021383_三七伤药片_0.3g×20片×2板_1
                    String jpgName = baseDir + picName + ".jpg";
//                    System.out.println(picName);
//                    System.out.println(jpgName);
//                    System.out.println();
                    try {
//                        downloadPicture(url, jpgName);
                    } catch (Exception e) {
                        System.out.println(jpgName);
                        e.printStackTrace();
                    }
                    stringBuilder.append(picName).append(";");
                }
                String substring = stringBuilder.substring(0, stringBuilder.lastIndexOf(";"));
                //System.out.println(substring);
                // 图片名称
                // 国药准字Z51021383_三七伤药片_0.3g×20片×2板_1;国药准字Z51021383_三七伤药片_0.3g×20片×2板_2;
                drugVo.setA27(substring);
                // System.out.println(drugVo);
            }
        }
        // #3生成图片文件，excel文件
        File file2 = new File("/Users/meihongliang/Downloads/A_20220324_97_new.xlsx");
        EasyExcel.write(file2, DrugVo.class).sheet("97_new").doWrite(list);
    }

    private static List<DrugVo> get96() throws FileNotFoundException {

        ExcelListener<DrugVo> userListener55555 = new ExcelListener<>();
//        String fileName36070_555 = "/Users/meihongliang/Downloads/导入失败表289.xlsx";
        String fileName96 = "/Users/meihongliang/Downloads/A_436_185_2178_1290_497_96.xlsx";
        EasyExcel.read(new FileInputStream(fileName96), DrugVo.class, userListener55555).sheet().doRead();
        return userListener55555.getObjs();
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
