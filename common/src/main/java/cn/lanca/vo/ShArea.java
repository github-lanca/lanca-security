package cn.lanca.vo;

import lombok.Data;

/**
 * project name:<font size="1"><b>小芄健康数据运营平台</b></font><br>
 * file name:<font size="1"><b>DictTemplate</b></font><br>
 * description:<font size="1"><b>平台字典数据操作实现类</b></font><br>
 * company name:<font size="1"><b>小芄医药科技（成都）有限公司-研发中心</b></font><br>
 *
 * @author <a href="mail to: ">mei.hongliang<br>
 * @version 1.0.0<br>
 * @since 2022/3/25 11:23  <br>
 */
@Data
public class ShArea {

    private Long id;
    private Long pid;
    private String shortName;
    private String name;
    private String mergeName;
    private Integer level;
    private String pinyin;
    private String code;
    private String zipCode;
    private String first;
    private String lng;
    private String lat;


}
