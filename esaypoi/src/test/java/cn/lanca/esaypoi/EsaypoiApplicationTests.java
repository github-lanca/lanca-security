package cn.lanca.esaypoi;

import cn.lanca_ip.service.IpServiceImpl;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

@SpringBootTest
class EsaypoiApplicationTests {

    // Map<SheetName, List<Object>>
    public Map<String, List<Object>> map = new HashMap<>();


    /**
     * 注入功能类
     */
    @Autowired
    private IpServiceImpl ipService;

    /**
     * 使用该方法
     */
    @Test
    void testA() {
        System.out.println("其他模块调用他人Start组件");
        // 使用该方法
        ipService.printIp();
    }

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
    public void easyExcel() {
//        String fileName = TestFileUtil.getPath() + "demo" + File.separator + "demo.xlsx";
//        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
//        EasyExcel.read(fileName, DemoData.class, new DemoDataListener()).sheet().doRead();
    }

    @Test
    public void pro() {
        Properties properties = System.getProperties();
        properties.forEach((k, v) -> {
            System.out.println(k + ":" + v);
        });
    }
}
