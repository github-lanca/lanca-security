package cn.lanca.esaypoi.dto;

import lombok.Data;

import java.util.List;

/**
 * project name:<font size="1"><b>小芄健康数据运营平台</b></font><br>
 * file name:<font size="1"><b>DictTemplate</b></font><br>
 * description:<font size="1"><b>平台字典数据操作实现类</b></font><br>
 * company name:<font size="1"><b>小芄医药科技（成都）有限公司-研发中心</b></font><br>
 *
 * @author <a href="mail to: ">mei.hongliang<br>
 * @version 1.0.0<br>
 * @since 2022/3/18 16:41  <br>
 */
@Data
public class SheetVo<T> {

    // 表名
    private String sheetName;
    // 这个sheet对应的domain类
    private T clazz;
    // 具体数据
    private List<T> list;

}
