package cn.lanca.esaypoi;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class EsaypoiApplicationTests {

    // Map<SheetName, List<Object>>
    public Map<String, List<Object>> map = new HashMap<>();

//    @Test
//    void contextLoads() {
//        List<ExcelObject> dataList = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            ExcelObject userEntity = new ExcelObject();
//            userEntity.setName("张三" + i);
//            userEntity.setAge(20 + i);
//            userEntity.setTime(new Date(System.currentTimeMillis() + i));
//            dataList.add(userEntity);
//        }
//        EasyExcel.write("/Users/meihongliang/Working/xiaowan/code/security/esaypoi/easyexcel-user1.xls", ExcelObject.class).sheet("用户信息").doWrite(dataList);
//    }
//
//    @Test
//    void readExcel() {
//        String filePath = "/Users/meihongliang/Working/xiaowan/code/security/esaypoi/easyexcel-user1.xls";
//        List<ExcelObject> list = EasyExcel.read(filePath).head(ExcelObject.class).sheet().doReadSync();
//        list.forEach(System.out::println);
//    }

    @Test
    void apachePoiTest() throws IOException, InvalidFormatException {

//        XSSFWorkbook excel = new XSSFWorkbook(OPCPackage.open(new File("/Users/meihongliang/Working/xiaowan/doc/excel/test.xlsx")));
//        System.out.println("sheet表数量: " + excel.getNumberOfSheets());
//        Sheet sheetAt = excel.getSheetAt(0);
//        for (Row cells : sheetAt) {
//            //System.out.println(cells);
//            for (Cell cell : cells) {
//                System.out.println(cell.toString());
//                //System.out.println(cell.getCellType());
//            }
//        }
        Workbook workbook = new XSSFWorkbook();
        // workbook.setSheetName(2,"sheet_自定义名称_3");
        Sheet sheet1 = workbook.createSheet("sheet_自定义名称_1");
        Sheet sheet2 = workbook.createSheet("sheet_自定义名称_2");
        // 从0开始
        Row row1 = sheet1.createRow(0);
        for (int i = 0; i < 10; i++) {
            Cell cell = row1.createCell(i);
            cell.setCellValue("sheet_11_" + i);
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
        System.out.println(workbook.getNumberOfSheets());
    }

    @Test
    void newDateTime() {

        System.out.println(StringUtils.isBlank(""));
        Instant now = Instant.now();
        System.out.println(now);

        LocalDate now1 = LocalDate.now();
        System.out.println(now1);

        LocalTime now2 = LocalTime.now();
        System.out.println(now2);
        System.out.println(now2.getSecond());
        System.out.println(now2.getNano());

    }
}
