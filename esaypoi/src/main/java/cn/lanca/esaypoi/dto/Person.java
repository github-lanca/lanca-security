package cn.lanca.esaypoi.dto;

import cn.lanca.esaypoi.anno.ExcelAno;
import lombok.Data;

import java.util.Date;

/**
 * person
 */
@Data
public class Person {

    @ExcelAno(value = "姓名")
    private String name;

    @ExcelAno(value = "年龄")
    private int age;

    @ExcelAno(value = "操作时间")
    private Date time = new Date();
    private String timeStr;

    public Person() {
    }


    public Person(String name, int age, String timeStr) {
        this.name = name;
        this.age = age;
        this.timeStr = timeStr;
    }
}
