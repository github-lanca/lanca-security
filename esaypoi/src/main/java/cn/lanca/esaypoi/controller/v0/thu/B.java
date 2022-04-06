package cn.lanca.esaypoi.controller;

import cn.lanca.esaypoi.util.ExcelListener;
import cn.lanca.esaypoi.vo.v0.DrugVo;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * 生成多sheet的excel文件
 *
 * @author <a href="mail to: ">mei.hongliang<br>
 * @version 1.0.0<br>
 * @since 2022/3/25 09:37  <br>
 */
public class B {
    public static void main(String[] args) throws FileNotFoundException {
        List<DrugVo> drugVos = get436();
        // List<DrugVo> list = new ArrayList<>();
        DrugVo drugVo = new DrugVo();
        drugVo.setA0("a0a0a0a0a0a0a");
        File fileName = new File("/Users/meihongliang/Downloads/fri/多sheet.xlsx");
        ExcelWriter excelWriter = null;

        try {
            // 明确下写入那个文件
            excelWriter = EasyExcel.write(fileName).build();
            for (int i = 0; i < 4; i++) {
                // 创建一个sheet
                WriteSheet sheet = EasyExcel.writerSheet(i, "sheet_" + i).head(DrugVo.class).build();
                // 写一次表
                excelWriter.write(drugVos, sheet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally");
            // 千万别忘记finish 会帮忙关闭流
            if (excelWriter != null) {
                excelWriter.finish();
            }
        }


    }

    private static List<DrugVo> get436() throws FileNotFoundException {
        ExcelListener<DrugVo> userListener55555 = new ExcelListener<>();
        String fileName36070_555 = "/Users/meihongliang/Downloads/thu/436/带图片原_436.xlsx";
        EasyExcel.read(new FileInputStream(fileName36070_555), DrugVo.class, userListener55555).sheet().doRead();
        List<DrugVo> objs = userListener55555.getObjs();
        objs.forEach(e -> e.setKey2(e.getA15() + "_" + e.getA16()));
        return objs;
    }
}
