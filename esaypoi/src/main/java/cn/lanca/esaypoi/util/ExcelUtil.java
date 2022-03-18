package cn.lanca.esaypoi.util;

import cn.lanca.esaypoi.dto.Person;
import cn.lanca.esaypoi.dto.SheetVo;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * project name:<font size="1"><b>小芄健康数据运营平台</b></font><br>
 * file name:<font size="1"><b>DictTemplate</b></font><br>
 * description:<font size="1"><b>平台字典数据操作实现类</b></font><br>
 * company name:<font size="1"><b>小芄医药科技（成都）有限公司-研发中心</b></font><br>
 *
 * @author <a href="mail to: ">mei.hongliang<br>
 * @version 1.0.0<br>
 * @since 2022/3/18 15:12  <br>
 */
public class ExcelUtil {

    public static List<Person> personList = Arrays.asList(
            new Person("张三", 18, "2022-03-18 17:22:48"),
            new Person("李四", 19, "2022-03-18 18:22:48"),
            new Person("王五", 20, "2022-03-18 19:22:48"),
            new Person("赵六", 21, "2022-03-18 20:22:48"),
            new Person("田七", 22, "2022-03-18 21:22:48"),
            new Person("王八", 23, "2022-03-18 22:22:48"),
            new Person("老九", 24, "2022-03-18 23:22:48")
    );


    public static void get() throws Exception {
        Workbook workbook = new XSSFWorkbook();
        // workbook.setSheetName(2,"sheet_自定义名称_3");
        Sheet sheet1 = workbook.createSheet("sheet_自定义名称_1");
        Sheet sheet2 = workbook.createSheet("sheet_自定义名称_2");
        // 从0开始
        for (int i = 0; i < personList.size(); i++) {
            Row row = sheet1.createRow(i);
            Person person = personList.get(i);
            Field[] declaredFields = person.getClass().getDeclaredFields();
            for (int i1 = 0; i1 < declaredFields.length; i1++) {
                Field declaredField = declaredFields[i1];
                declaredField.setAccessible(true);
                Object value = declaredField.get(person);
                Class<?> type = declaredField.getType();
                String name = declaredField.getName();
                Cell cell = row.createCell(i1);
                cell.setCellValue(value.toString());
            }
        }

        Row row2 = sheet2.createRow(0);
        for (int i = 0; i < 10; i++) {
            Cell cell = row2.createCell(i);
            cell.setCellValue("sheet_22_" + i);
        }
        File file = new File("/Users/meihongliang/Working/xiaowan/doc/excel/318.xlsx");
        FileOutputStream outputStream = new FileOutputStream(file);
        workbook.write(outputStream);
        outputStream.flush();
        outputStream.close();
        System.out.println("sheet数量: "+workbook.getNumberOfSheets());
    }

    public static void main(String[] args) {
        try {
            get();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void teeeee(){
        List<SheetVo> list = new ArrayList<>();
        for (SheetVo sheetVo : list) {
            sheetVo.getSheetName();
        }
    }

}
