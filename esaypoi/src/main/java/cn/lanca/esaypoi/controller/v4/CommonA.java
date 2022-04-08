package cn.lanca.esaypoi.controller.v4;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * project name:<font size = "1"><b>小芄健康数据运营平台</b></font><br>
 * file name:<font size = "1"><b>TODO</b></font><br>
 * description:<font size = "1"><b>TODO</b></font><br>
 * company name:<font size = "1"><b>小芄医药科技（成都）有限公司-研发中心</b></font><br>
 *
 * @author <a href="mail to: meihongliang@xiaowanjiankang.com" rel="nofollow">meihongliang<br>
 * @version 1.0.0<br>
 * @since [1] [2022/4/8 10:20] [meihongliang] [新建] <br>
 */
@Data
public class CommonA {


    // 0网店商品分组 1商品品牌 2药品商品名 3商品名称 4药品通用名 5药品规格 6产品剂型 7疾病 8商品卖点 9使用剂量 10批准文号


    @ExcelProperty(value = "0网店商品分组", index = 0)
    private String a0 = "";
    @ExcelProperty(value = "1商品品牌", index = 1)
    private String a1 = "";
    @ExcelProperty(value = "2药品商品名", index = 2)
    private String a2 = "";
    @ExcelProperty(value = "3商品名称", index = 3)
    private String a3 = "";
    @ExcelProperty(value = "4药品通用名", index = 4)
    private String a4 = "";
    @ExcelProperty(value = "5药品规格", index = 5)
    private String a5 = "";
    @ExcelProperty(value = "6产品剂型", index = 6)
    private String a6 = "";
    @ExcelProperty(value = "7疾病", index = 7)
    private String a7 = "";
    @ExcelProperty(value = "8商品卖点", index = 8)
    private String a8 = "";
    @ExcelProperty(value = "9使用剂量", index = 9)
    private String a9 = "";
    @ExcelProperty(value = "10批准文号", index = 10)
    private String a10 = "";


    // 11有效期 12商品类目值 13生产企业 14药品类别 15用法 16适用人群 17条形码 18产品图片 19对应商品编码

    @ExcelProperty(value = "11有效期", index = 11)
    private String a11 = "";
    @ExcelProperty(value = "12商品类目值", index = 12)
    private String a12 = "";
    @ExcelProperty(value = "13生产企业", index = 13)
    private String a13 = "";
    @ExcelProperty(value = "14药品类别", index = 14)
    private String a14 = "";
    @ExcelProperty(value = "15用法", index = 15)
    private String a15 = "";
    @ExcelProperty(value = "16适用人群", index = 16)
    private String a16 = "";
    @ExcelProperty(value = "17条形码", index = 17)
    private String a17 = "";
    @ExcelProperty(value = "18产品图片", index = 18)
    private String a18 = "";
    @ExcelProperty(value = "19对应商品编码", index = 19)
    private String a19 = "";
    @ExcelProperty(value = "序号", index = 20)
    private String a20 = "";

    @ExcelProperty(value = "批准文号", index = 21)
    private String b1 = "";
    @ExcelProperty(value = "药品规格", index = 22)
    private String b2 = "";

    private String key = "";

}
