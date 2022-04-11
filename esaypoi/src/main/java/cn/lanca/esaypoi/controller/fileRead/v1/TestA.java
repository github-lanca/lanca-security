package cn.lanca.esaypoi.controller.fileRead.v1;

import cn.lanca.esaypoi.util.ExcelListener;
import com.alibaba.excel.EasyExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

/**
 * project name:<font size = "1"><b>小芄健康数据运营平台</b></font><br>
 * file name:<font size = "1"><b>TODO</b></font><br>
 * description:<font size = "1"><b>TODO</b></font><br>
 * company name:<font size = "1"><b>小芄医药科技（成都）有限公司-研发中心</b></font><br>
 *
 * @author <a href="mail to: meihongliang@xiaowanjiankang.com" rel="nofollow">meihongliang<br>
 * @version 1.0.0<br>
 * @since [1] [2022/4/11 13:52] [meihongliang] [新建] <br>
 */
public class TestA {
    public static void main(String[] args) throws IOException {
        List<CommonImgName> image = getImage();
        System.out.println(image.size());
        System.out.println(image.get(0));
        Path startPath = Paths.get("/Users/meihongliang/Downloads/建设路-316图片");
        List<String> fileName = new ArrayList<>();
        // 文件夹遍历
        Files.walkFileTree(startPath, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                System.out.println("File : " + file.getFileName());
                fileName.add(file.getFileName().toString());
                return FileVisitResult.CONTINUE;
            }

        });
        System.out.println(fileName.size());
        System.out.println("----------");
        image.forEach(e -> {
            String a3 = e.getA3();
            StringBuffer sb = new StringBuffer();
            fileName.forEach(f -> {
                if (f.contains(a3)) {
                    sb.append(f).append(";");
                }
            });
            e.setA25(sb.toString());
            System.out.println(sb);
        });

        File file1 = new File("/Users/meihongliang/Downloads/建设路-316提取图片名称_result.xlsx");
        EasyExcel.write(file1, CommonImgName.class).sheet(image.size() + "").doWrite(image);

    }

    private static List<CommonImgName> getImage() throws FileNotFoundException {
        ExcelListener<CommonImgName> b = new ExcelListener<>();
        String fileB = "/Users/meihongliang/Downloads/建设路-316提取图片名称.xlsx";
        EasyExcel.read(new FileInputStream(fileB), CommonImgName.class, b).sheet().doRead();
        return b.getObjs();
    }
}
