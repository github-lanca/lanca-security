package cn.lanca.esaypoi.dto;

import cn.lanca.esaypoi.anno.ExcelAno;
import lombok.Data;

import java.util.Date;

/**
 * project name:<font size="1"><b>小芄健康数据运营平台</b></font><br>
 * file name:<font size="1"><b>DictTemplate</b></font><br>
 * description:<font size="1"><b>平台字典数据操作实现类</b></font><br>
 * company name:<font size="1"><b>小芄医药科技（成都）有限公司-研发中心</b></font><br>
 *
 * @author <a href="mail to: ">mei.hongliang<br>
 * @version 1.0.0<br>
 * @since 2022/3/18 16:45  <br>
 */
@Data
public class Student {
    @ExcelAno(value = "编号")
    private int no;
    @ExcelAno(value = "名称")
    private String name;
    @ExcelAno(value = "性别")
    private String sex;
    @ExcelAno(value = "生日")
    private Date birthday;

    public Student() {
    }

    public Student(int no, String name, String sex, Date birthday) {
        this.no = no;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
    }
}
