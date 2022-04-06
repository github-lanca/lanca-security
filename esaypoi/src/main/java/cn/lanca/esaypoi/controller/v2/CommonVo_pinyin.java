package cn.lanca.esaypoi.controller.v2;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * project name:<font size="1"><b>小芄健康数据运营平台</b></font><br>
 * file name:<font size="1"><b>DictTemplate</b></font><br>
 * description:<font size="1"><b>平台字典数据操作实现类</b></font><br>
 * company name:<font size="1"><b>小芄医药科技（成都）有限公司-研发中心</b></font><br>
 *
 * @author <a href="mail to: ">mei.hongliang<br>
 * @version 1.0.0<br>
 * @since 2022/3/25 14:20  <br>
 */
@Data
public class CommonVo_pinyin {

    // 商品名称 药品通用名 药品标准名首拼 基本单位	企业名称	药品类型	批准文号	规格	建议零售价 用法 用法频次

    @ExcelProperty(value = "商品名称", index = 0)
    private String a0 = "";
    @ExcelProperty(value = "药品通用名", index = 1)
    private String a1 = "";
    @ExcelProperty(value = "药品标准名首拼", index = 2)
    private String a2 = "";
    @ExcelProperty(value = "基本单位", index = 3)
    private String a3 = "";
    @ExcelProperty(value = "企业名称", index = 4)
    private String a4 = "";
    @ExcelProperty(value = "药品类型", index = 5)
    private String a5 = "";
    @ExcelProperty(value = "批准文号", index = 6)
    private String a6 = "";
    @ExcelProperty(value = "规格", index = 7)
    private String a7 = "";
    @ExcelProperty(value = "建议零售价", index = 8)
    private String a8 = "";
    @ExcelProperty(value = "用法", index = 9)
    private String a9 = "";
    @ExcelProperty(value = "用法频次", index = 10)
    private String a10 = "";

    // 	单次用量	用量单位	适应症	注意事项	不良反应	禁忌	药品重量 	药品品牌	药品条码


    @ExcelProperty(value = "单次用量", index = 11)
    private String a11 = "";
    @ExcelProperty(value = "用量单位", index = 12)
    private String a12 = "";
    @ExcelProperty(value = "适应症", index = 13)
    private String a13 = "";
    @ExcelProperty(value = "注意事项", index = 14)
    private String a14 = "";
    @ExcelProperty(value = "不良反应", index = 15)
    private String a015 = "";
    @ExcelProperty(value = "禁忌", index = 16)
    private String a16 = "";
    @ExcelProperty(value = "药品重量", index = 17)
    private String a17 = "";
    @ExcelProperty(value = "药品品牌", index = 18)
    private String a18 = "";
    @ExcelProperty(value = "药品条码", index = 19)
    private String a19 = "";

    //别名 药品渠道 药品性质 剂型

    @ExcelProperty(value = "别名", index = 20)
    private String a20 = "";
    @ExcelProperty(value = "药品渠道", index = 21)
    private String a21 = "";
    @ExcelProperty(value = "药品性质", index = 22)
    private String a22 = "";
    @ExcelProperty(value = "剂型", index = 23)
    private String a23 = "";


}
