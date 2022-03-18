package cn.lanca;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipOutputStream;

@SpringBootTest
class SpringbootTestApplicationTests {

    @Test
    void contextLoads() throws FileNotFoundException {
        System.out.println("专门测试用,,,,");
        String a = "/Users/meihongliang/Working/xiaowan/subline/2022-02-14";
        String b = "/Users/meihongliang/Working/xiaowan/subline/2022-02-22_核查";
        String c = "/Users/meihongliang/Working/xiaowan/subline/2022-03-09";
        String d = "/Users/meihongliang/Working/xiaowan/subline";

        //设置输出流
        File zipFile = new File("/Users/meihongliang/Working/xiaowan/zip");
        ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile));
    }

    @Test
    void testZip() throws FileNotFoundException {
        File file = new File("/Users/meihongliang/Working/xiaowan/subline/2022-02-14");
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());
        // File zip = ZipUtil.zip("/Users/meihongliang/Working/xiaowan/subline");
    }

    @Test
    public void longTest(){
        List<Long> delIds = new ArrayList<>();
        delIds.add(1L);
        delIds.add(2L);
        delIds.add(3L);
        delIds.add(4L);
        Long[] longs = delIds.toArray(new Long[0]);
        System.out.println(longs.length);
    }

}
