package cn.lanca.esaypoi.util;

import cn.lanca.esaypoi.anno.ExcelAno;
import cn.lanca.esaypoi.dto.Person;
import cn.lanca.esaypoi.dto.SheetVo;
import cn.lanca.esaypoi.dto.Student;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    /**
     * 准备excel工作博
     */
    private Workbook workbook = new XSSFWorkbook();

    public ExcelUtil() {

    }


    public Map<String, CellStyle> createStyles() {
        Workbook wb = workbook;
        Map<String, CellStyle> styles = new HashMap<>();
        CellStyle style = wb.createCellStyle();
        Font font = wb.createFont();
        DataFormat dataFormat = workbook.createDataFormat();
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        Font titleFont = workbook.createFont();
        titleFont.setFontName("Arial");
        titleFont.setFontHeightInPoints((short) 16);
        titleFont.setBold(true);
        style.setFont(titleFont);
        styles.put("title", style);

        style = wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setBorderRight(BorderStyle.THIN);
        style.setRightBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
        style.setBorderLeft(BorderStyle.THIN);
        style.setLeftBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
        style.setBorderTop(BorderStyle.THIN);
        style.setTopBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
        style.setBorderBottom(BorderStyle.THIN);
        style.setBottomBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
        Font dataFont = wb.createFont();
        dataFont.setFontName("Arial");
        dataFont.setFontHeightInPoints((short) 10);
        style.setFont(dataFont);
        styles.put("data", style);

        style = wb.createCellStyle();
        style.cloneStyleFrom(styles.get("data"));
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setFillForegroundColor(IndexedColors.GREY_50_PERCENT.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        Font headerFont = wb.createFont();
        headerFont.setFontName("Arial");
        headerFont.setFontHeightInPoints((short) 10);
        headerFont.setBold(true);
        headerFont.setColor(IndexedColors.WHITE.getIndex());
        style.setFont(headerFont);
        styles.put("header", style);

        style = wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        Font totalFont = wb.createFont();
        totalFont.setFontName("Arial");
        totalFont.setFontHeightInPoints((short) 10);
        style.setFont(totalFont);
        styles.put("total", style);

        style = wb.createCellStyle();
        style.cloneStyleFrom(styles.get("data"));
        style.setAlignment(HorizontalAlignment.LEFT);
        styles.put("data1", style);

        style = wb.createCellStyle();
        style.cloneStyleFrom(styles.get("data"));
        style.setAlignment(HorizontalAlignment.CENTER);
        styles.put("data2", style);

        style = wb.createCellStyle();
        style.cloneStyleFrom(styles.get("data"));
        style.setAlignment(HorizontalAlignment.RIGHT);
        styles.put("data3", style);
        return styles;
    }

    /**
     * 调用这个方法一次，就生成一个sheet表，并填充好数据
     */
    public void createSheet(SheetVo sheetVo) throws IllegalAccessException {
        Sheet sheet = workbook.createSheet(sheetVo.getSheetName());
        //
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        cellStyle.setFillForegroundColor(IndexedColors.GREY_50_PERCENT.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        CellStyle simple = workbook.createCellStyle();
        simple.setAlignment(HorizontalAlignment.CENTER);
        simple.setVerticalAlignment(VerticalAlignment.CENTER);

        DataFormat dataFormat = workbook.createDataFormat();

        Row row = sheet.createRow(0);

        Class clazz = sheetVo.getClazz();
        Field[] declaredFields = clazz.getDeclaredFields();
        for (int i = 0; i < declaredFields.length; i++) {
            Field field = declaredFields[i];
            if (field.isAnnotationPresent(ExcelAno.class)) {
                ExcelAno annotation = field.getAnnotation(ExcelAno.class);
                Cell cell = row.createCell(i);
                sheet.setColumnWidth(i,6000);
                cell.setCellStyle(cellStyle);

                String value = annotation.value();
                cell.setCellValue(value);
            }
        }
        List list = sheetVo.getList();
        for (int i = 0; i < list.size(); i++) {
            Row roww = sheet.createRow(i + 1);
            Object o1 = list.get(i);
            Field[] declaredFieldsxxx = o1.getClass().getDeclaredFields();
            for (int i1 = 0; i1 < declaredFieldsxxx.length; i1++) {
                Cell cell = roww.createCell(i1);
                Field declaredField = declaredFieldsxxx[i1];
                declaredField.setAccessible(true);
                Object o = declaredField.get(o1);
                cell.setCellStyle(simple);

                cell.setCellValue(o.toString());
            }
        }
    }


    public List<Person> getPersonList() {
        List<Person> list = new ArrayList<>();
        list.add(new Person("张三", 18, "2022-03-18 17:22:48"));
        list.add(new Person("李四", 19, "2022-03-18 18:22:48"));
        list.add(new Person("王五", 20, "2022-03-18 19:22:48"));
        list.add(new Person("赵六", 21, "2022-03-18 20:22:48"));
        list.add(new Person("田七", 22, "2022-03-18 21:22:48"));
        list.add(new Person("王八", 23, "2022-03-18 22:22:48"));
        list.add(new Person("老九", 24, "2022-03-18 23:22:48"));
        list.add(new Person("什么", 24, "2022-03-18 23:22:48"));
        return list;
    }

    public List<Student> getStudentList() {
        List<Student> list = new ArrayList<>();
        list.add(new Student(0, "张三", "男", new Date()));
        list.add(new Student(1, "李四", "男", new Date()));
        list.add(new Student(2, "王五", "男", new Date()));
        list.add(new Student(3, "赵六", "男", new Date()));
        list.add(new Student(4, "田七", "男", new Date()));
        list.add(new Student(5, "王八", "男", new Date()));
        list.add(new Student(6, "老九", "男", new Date()));
        return list;
    }

    public void createExcel() throws Exception {

        List<Person> personList = getPersonList();
        SheetVo<Person> sheetVo = new SheetVo<>(Person.class);
        sheetVo.setList(personList);
        sheetVo.setSheetName("Person统计表");
        createSheet(sheetVo);

        List<Student> studentList = getStudentList();
        SheetVo<Student> studentSheetVo = new SheetVo<>(Student.class);
        studentSheetVo.setList(studentList);
        studentSheetVo.setSheetName("学生统计表");
        createSheet(studentSheetVo);


        try {
            File file = new File("/Users/meihongliang/Working/xiaowan/doc/excel/318.xlsx");
            FileOutputStream outputStream = new FileOutputStream(file);
            excelWrite(workbook, outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 写入其他数据流
     *
     * @param workbook workbook
     * @throws IOException
     */
    private void excelWrite(Workbook workbook, OutputStream outputStream) throws IOException {
        try {
            workbook.write(outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        System.out.println(" sheet数量: " + workbook.getNumberOfSheets());
    }

    public static void main(String[] args) throws Exception {
        ExcelUtil excelUtil = new ExcelUtil();
        excelUtil.createExcel();
    }

}
