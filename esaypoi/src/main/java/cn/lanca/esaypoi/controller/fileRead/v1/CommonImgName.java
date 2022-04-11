package cn.lanca.esaypoi.controller.fileRead.v1;

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
public class CommonImgName {

    // 0序列 1药品ID 2商品名称 3批准文号 4规格 5生产企业 6基本单位 7药品通用名 8商品品牌 9网店商品分组 10药品类别

    @ExcelProperty(value = "0序列", index = 0)
    private String a0 = "";
    @ExcelProperty(value = "1药品ID", index = 1)
    private String a1 = "";
    @ExcelProperty(value = "2商品名称", index = 2)
    private String a2 = "";
    @ExcelProperty(value = "3批准文号", index = 3)
    private String a3 = "";
    @ExcelProperty(value = "4规格", index = 4)
    private String a4 = "";
    @ExcelProperty(value = "5生产企业", index = 5)
    private String a5 = "";
    @ExcelProperty(value = "6基本单位", index = 6)
    private String a6 = "";
    @ExcelProperty(value = "7药品通用名", index = 7)
    private String a7 = "";
    @ExcelProperty(value = "8商品品牌", index = 8)
    private String a8 = "";
    @ExcelProperty(value = "9网店商品分组", index = 9)
    private String a9 = "";
    @ExcelProperty(value = "10药品类别", index = 10)
    private String a10 = "";


    // 11商品类目值 12非处方甲乙类 13甲乙类功能分类 14产品剂型 15贮藏条件 16价格 17用法 18使用剂量 19用量单位 20商品卖点

    @ExcelProperty(value = "11商品类目值", index = 11)
    private String a11 = "";
    @ExcelProperty(value = "12非处方甲乙类", index = 12)
    private String a12 = "";
    @ExcelProperty(value = "13甲乙类功能分类", index = 13)
    private String a13 = "";
    @ExcelProperty(value = "14产品剂型", index = 14)
    private String a14 = "";
    @ExcelProperty(value = "15贮藏条件", index = 15)
    private String a15 = "";
    @ExcelProperty(value = "16价格", index = 16)
    private String a16 = "";
    @ExcelProperty(value = "17用法", index = 17)
    private String a17 = "";
    @ExcelProperty(value = "18使用剂量", index = 18)
    private String a18 = "";
    @ExcelProperty(value = "19用量单位", index = 19)
    private String a19 = "";
    @ExcelProperty(value = "20商品卖点", index = 20)
    private String a20 = "";

    // 21注意事项 22不良反应 23有效期 24库存 25图片名称 26商品图片

    @ExcelProperty(value = "21注意事项", index = 21)
    private String a21 = "";
    @ExcelProperty(value = "22不良反应", index = 22)
    private String a22 = "";
    @ExcelProperty(value = "23有效期", index = 23)
    private String a23 = "";
    @ExcelProperty(value = "24库存", index = 24)
    private String a24 = "";
    @ExcelProperty(value = "25图片名称", index = 25)
    private String a25 = "";
    @ExcelProperty(value = "26商品图片", index = 26)
    private String a26 = "";

}
