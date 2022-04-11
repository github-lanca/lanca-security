package cn.lanca.esaypoi.controller.fileRead.v1;

import cn.lanca.esaypoi.util.ExcelListener;
import com.alibaba.excel.EasyExcel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

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
import java.util.concurrent.atomic.AtomicInteger;

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
@Slf4j
public class TestA {
    public static void main(String[] args) throws IOException {
        List<CommonImgName> image = getImage();
        System.out.println(image.size());
        System.out.println(image.get(0));
        Path startPath = Paths.get("/Users/meihongliang/Downloads/建设路-316图片");
        List<String> fileName = new ArrayList<>();
        AtomicInteger atomicInteger = new AtomicInteger(0);
        // 文件夹遍历
        Files.walkFileTree(startPath, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                // System.out.println("File : " + file.getFileName());
                fileName.add(file.getFileName().toString());
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                atomicInteger.incrementAndGet();
                return super.postVisitDirectory(dir, exc);
            }
        });
        log.info(fileName.size() + "");
        log.info("文件夹数量: " + atomicInteger);
        log.info("----------");
        AtomicInteger number = new AtomicInteger(0);
        image.forEach(e -> {
            String a3 = e.getA3();
            String a2 = e.getA2();
            String a4 = regex(e.getA4());
            String ff = a3 + a2 + a4;
            StringBuffer sb = new StringBuffer();
            fileName.forEach(f -> {
                if (f.contains(ff)) {
                    sb.append(f).append(";");
                }
            });
            if (StringUtils.hasText(sb)) {
                number.incrementAndGet();
            }
            e.setA25(sb.toString());
            // System.out.println(ff + "_" + sb);
        });
        System.out.println("_ " + number);
        File file1 = new File("/Users/meihongliang/Downloads/建设路-316提取图片名称_result_bak2.xlsx");
        // EasyExcel.write(file1, CommonImgName.class).sheet(image.size() + "").doWrite(image);

    }

    private static String regex(String a4) {
        String trim = a4.trim();
        trim = trim.replace("％", "");
        trim = trim.replace("*", "");
        return trim;
    }

    private static List<CommonImgName> getImage() throws FileNotFoundException {
        ExcelListener<CommonImgName> b = new ExcelListener<>();
        String fileB = "/Users/meihongliang/Downloads/建设路-316提取图片名称.xlsx";
        EasyExcel.read(new FileInputStream(fileB), CommonImgName.class, b).sheet().doRead();
        return b.getObjs();
    }
}
