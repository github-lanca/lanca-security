package cn.lanca;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@SpringBootTest
class SpringbootYouzanApplicationTests {

    @Test
    void contextLoads() throws Exception {
        System.out.println("文件压缩,,,,,");
        //File.separator代表了当前系统的文件分割符
        //linux使用/分割符会报错找不到文件,window系统下/和\都可以作为文件路径
        System.out.println("File.separator="+ File.separator);
        String a =  "/Users/meihongliang/Working/xiaowan/subline/2022-02-14";
        String b =  "/Users/meihongliang/Working/xiaowan/subline/2022-02-22_核查";
        String c =  "/Users/meihongliang/Working/xiaowan/subline/2022-03-09";
        String d =  "/Users/meihongliang/Working/xiaowan/subline";
        File file = new File(d);

        //File file = new File("D:" + File.separator + "upgrade46.txt");
        File zipFile = new File("/Users/meihongliang/Working/xiaowan/subline/zip_test.zip");
        //读取相关的文件
        InputStream input = new FileInputStream(file);
        //设置输出流
        ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile));

        zipOut.putNextEntry(new ZipEntry(file.getName()));
        // 设置注释
        zipOut.setComment("hello_zip_test");
        int temp = 0;
        //读取相关的文件
        while((temp = input.read()) != -1){
            //写入输出流中
            zipOut.write(temp);
        }
        //关闭流
        input.close();
        zipOut.close();
        System.out.println("over");
    }

    @Test
    void testZip() throws Exception {
//        File zip = ZipUtil.zip("/Users/meihongliang/Working/xiaowan/subline");
        System.out.println("1232131");

    }

}
