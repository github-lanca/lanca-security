package cn.lanca.esaypoi.vo.v0;

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
public class AandBVo {

    @ExcelProperty(value = "序列", index = 0)
    private String a0 = "";
    @ExcelProperty(value = "药品ID", index = 1)
    private String a1 = "";
    @ExcelProperty(value = "商品名称", index = 2)
    private String a2 = "";
    @ExcelProperty(value = "批准文号", index = 3)
    private String a3 = "";
    @ExcelProperty(value = "规格", index = 4)
    private String a4 = "";
    @ExcelProperty(value = "生产企业", index = 5)
    private String a5 = "";
    @ExcelProperty(value = "基本单位", index = 6)
    private String a6 = "";
    @ExcelProperty(value = "药品通用名", index = 7)
    private String a7 = "";
    @ExcelProperty(value = "商品品牌", index = 8)
    private String a8 = "";
    @ExcelProperty(value = "网店商品分组", index = 9)
    private String a9 = "";
    @ExcelProperty(value = "药品类别", index = 10)
    private String a10 = "";

    @ExcelProperty(value = "商品类目值", index = 11)
    private String a11 = "";
    @ExcelProperty(value = "非处方甲乙类", index = 12)
    private String a12 = "";
    @ExcelProperty(value = "甲乙类功能分类", index = 13)
    private String a13 = "";
    @ExcelProperty(value = "产品剂型", index = 14)
    private String a14 = "";
    @ExcelProperty(value = "贮藏条件", index = 15)
    private String a15 = "";
    @ExcelProperty(value = "价格", index = 16)
    private String a16 = "";
    @ExcelProperty(value = "用法", index = 17)
    private String a17 = "";
    @ExcelProperty(value = "使用剂量", index = 18)
    private String a18 = "";
    @ExcelProperty(value = "用量单位", index = 19)
    private String a19 = "";
    @ExcelProperty(value = "商品卖点", index = 20)
    private String a20 = "";


    @ExcelProperty(value = "注意事项", index = 21)
    private String a21 = "";
    @ExcelProperty(value = "不良反应", index = 22)
    private String a22 = "";
    @ExcelProperty(value = "有效期", index = 23)
    private String a23 = "";
    @ExcelProperty(value = "库存", index = 24)
    private String a24 = "";
    @ExcelProperty(value = "图片名称", index = 25)
    private String a25 = "";
    @ExcelProperty(value = "商品图片", index = 26)
    private String a26 = "";

}
