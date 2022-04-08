package cn.lanca.esaypoi.controller.v3;

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
 * @since 2022/3/30 10:52  <br>
 */
@Data
public class CommonOther {

    // 0序号 1业务机构 2商品编码 3品名 4规格 5生产企业 6产地 7条形码 8批准文号 9供货价 10数量(A)

    @ExcelProperty(value = "0序号", index = 0)
    private String a0 = "";
    @ExcelProperty(value = "1业务机构", index = 1)
    private String a1 = "";
    @ExcelProperty(value = "2商品编码", index = 2)
    private String a2 = "";
    @ExcelProperty(value = "3品名", index = 3)
    private String a3 = "";
    @ExcelProperty(value = "4规格", index = 4)
    private String a4 = "";
    @ExcelProperty(value = "5生产企业", index = 5)
    private String a5 = "";
    @ExcelProperty(value = "6产地", index = 6)
    private String a6 = "";
    @ExcelProperty(value = "7条形码", index = 7)
    private String a7 = "";
    @ExcelProperty(value = "8批准文号", index = 8)
    private String a8 = "";
    @ExcelProperty(value = "9供货价", index = 9)
    private String a9 = "";
    @ExcelProperty(value = "10数量(A) ", index = 10)
    private String a10 = "";

    // 11单位  12售价 13供应商名称 14最低陈列量 15新品标识 16采购状态 17商品录入时间 18剂型

    @ExcelProperty(value = "11单位", index = 11)
    private String a11 = "";
    @ExcelProperty(value = "12售价", index = 12)
    private String a12 = "";
    @ExcelProperty(value = "13供应商名称", index = 13)
    private String a13 = "";
    @ExcelProperty(value = "14最低陈列量", index = 14)
    private String a14 = "";
    @ExcelProperty(value = "15新品标识", index = 15)
    private String a015 = "";
    @ExcelProperty(value = "16采购状态", index = 16)
    private String a16 = "";
    @ExcelProperty(value = "17商品录入时间", index = 17)
    private String a17 = "";
    @ExcelProperty(value = "18剂型", index = 18)
    private String a18 = "";
    @ExcelProperty(value = "19图片地址", index = 19)
    private String a19 = "";
    @ExcelProperty(value = "20图片名称", index = 20)
    private String a20 = "";
    @ExcelProperty(value = "21多规格", index = 21)
    private String a21 = "";
    @ExcelProperty(value = "20少规格", index = 22)
    private String a22 = "";


    //
    @ExcelProperty(value = "商品卖点", index = 23)
    private String b1 = "";
    @ExcelProperty(value = "使用剂量", index = 24)
    private String b2 = "";
    @ExcelProperty(value = "有效期", index = 25)
    private String b3 = "";
    @ExcelProperty(value = "商品类目值", index = 26)
    private String b4 = "";
    @ExcelProperty(value = "药品类别", index = 27)
    private String b5 = "";
    @ExcelProperty(value = "用法", index = 28)
    private String b6 = "";
    @ExcelProperty(value = "适用人群", index = 29)
    private String b7 = "";

}
