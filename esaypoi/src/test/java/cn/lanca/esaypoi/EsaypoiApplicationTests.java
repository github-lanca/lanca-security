package cn.lanca.esaypoi;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;

@SpringBootTest
class EsaypoiApplicationTests {

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

        XSSFWorkbook excel = new XSSFWorkbook(OPCPackage.open(new File("/Users/meihongliang/Working/xiaowan/doc/excel/test.xlsx")));
        System.out.println("sheet表数量: " + excel.getNumberOfSheets());
        Sheet sheetAt = excel.getSheetAt(0);
        for (Row cells : sheetAt) {
            //System.out.println(cells);
            for (Cell cell : cells) {
                System.out.println(cell.toString());
                //System.out.println(cell.getCellType());
            }
        }


    }
}
