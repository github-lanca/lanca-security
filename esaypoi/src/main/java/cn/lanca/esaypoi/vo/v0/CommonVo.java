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
public class CommonVo {


    @ExcelProperty(value = "网店商品分组", index = 0)
    private String a0 = "";
    @ExcelProperty(value = "商品品牌", index = 1)
    private String a1 = "";
    @ExcelProperty(value = "药品商品名", index = 2)
    private String a2 = "";
    @ExcelProperty(value = "商品名称", index = 3)
    private String a3 = "";
    @ExcelProperty(value = "药品通用名", index = 4)
    private String a4 = "";
    @ExcelProperty(value = "药品规格", index = 5)
    private String a5 = "";
    @ExcelProperty(value = "产品剂型", index = 6)
    private String a6 = "";
    @ExcelProperty(value = "疾病", index = 7)
    private String a7 = "";
    @ExcelProperty(value = "商品卖点", index = 8)
    private String a8 = "";
    @ExcelProperty(value = "使用剂量", index = 9)
    private String a9 = "";
    @ExcelProperty(value = "批准文号", index = 10)
    private String a10 = "";


    @ExcelProperty(value = "有效期", index = 11)
    private String a11 = "";
    @ExcelProperty(value = "商品类目值", index = 12)
    private String a12 = "";
    @ExcelProperty(value = "生产企业", index = 13)
    private String a13 = "";
    @ExcelProperty(value = "药品类别", index = 14)
    private String a14 = "";
    @ExcelProperty(value = "用法", index = 15)
    private String a015 = "";
    @ExcelProperty(value = "适用人群", index = 16)
    private String a16 = "";
    @ExcelProperty(value = "条形码", index = 17)
    private String a17 = "";
    @ExcelProperty(value = "产品图片(数据库)", index = 18)
    private String a18 = "";
    @ExcelProperty(value = "对应商品编码", index = 19)
    private String a19 = "";


    @ExcelProperty(value = "批准文号_A", index = 20)
    private String a20 = "";
    @ExcelProperty(value = "药品规格_A_表原始规格", index = 21)
    private String a21 = "";
    @ExcelProperty(value = "药品规格_A_库原始规格", index = 22)
    private String a22 = "";

//    @ExcelProperty(value = "药品规格_B_表模糊数据", index = 23)
    @ExcelProperty(value = "序列", index = 23)
    private String a23 = "";
//    @ExcelProperty(value = "药品规格_B_库模糊数据", index = 24)
    @ExcelProperty(value = "药品ID", index = 24)
    private String a24 = "";

    @ExcelProperty(value = "序列", index = 25)
    private String a25 = "";
    @ExcelProperty(value = "药品ID", index = 26)
    private String a26 = "";

    @ExcelProperty(value = "", index = 27)
    private String key = "";
    @ExcelProperty(value = "图片名称", index = 28)
    private String key2 = "";

}
