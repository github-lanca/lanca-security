package cn.lanca.esaypoi.vo;

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
 * @since 2022/3/24 16:12  <br>
 */
@Data
public class ExportVo {

    @ExcelProperty(value = "商品条码", index = 0)
    private String a0;
    @ExcelProperty(value = "商品编码", index = 1)
    private String a1 = "";
    @ExcelProperty(value = "商品名称（必填）", index = 2)
    private String a2 = "";
    @ExcelProperty(value = "网店商品分组", index = 3)
    private String a3 = "";
    @ExcelProperty(value = "商品类目值", index = 4)
    private String a4 = "";
    @ExcelProperty(value = "商品分类", index = 5)
    private String a5 = "";
    @ExcelProperty(value = "商品品牌", index = 6)
    private String a6 = "";
    @ExcelProperty(value = "商品图片名称（必填）", index = 7)
    private String a7 = "";
    @ExcelProperty(value = "尺码组名称", index = 8)
    private String a8 = "";
    @ExcelProperty(value = "商品规格项1（以商品第1行设的为准）", index = 9)
    private String a9 = "";
    @ExcelProperty(value = "商品规格值1", index = 10)
    private String a10 = "";

    @ExcelProperty(value = "商品规格项2", index = 11)
    private String a11 = "";
    @ExcelProperty(value = "商品规格值2", index = 12)
    private String a12 = "";
    @ExcelProperty(value = "商品规格项3", index = 13)
    private String a13 = "";
    @ExcelProperty(value = "商品规格值3", index = 14)
    private String a14 = "";
    @ExcelProperty(value = "商品规格条码", index = 15)
    private String a15 = "";
    @ExcelProperty(value = "商品规格编码", index = 16)
    private String a16 = "";
    @ExcelProperty(value = "价格（必填）", index = 17)
    private String a17 = "";
    @ExcelProperty(value = "标准价", index = 18)
    private String a18 = "";
    @ExcelProperty(value = "划线价", index = 19)
    private String a19 = "";
    @ExcelProperty(value = "商品详情、购物车是否显示剩余件数", index = 20)
    private String a20 = "";


    @ExcelProperty(value = "配送方式（必填）", index = 21)
    private String a21 = "";
    @ExcelProperty(value = "运费", index = 22)
    private String a22 = "";
    @ExcelProperty(value = "同城配送费用是否续重收费", index = 23)
    private String a23 = "";
    @ExcelProperty(value = "重量（kg）", index = 24)
    private String a24 = "";
    @ExcelProperty(value = "是否开启会员折扣", index = 25)
    private String a25 = "";
    @ExcelProperty(value = "是否支持买家申请换货", index = 26)
    private String a26 = "";
    @ExcelProperty(value = "是否支持7天无理由退货", index = 27)
    private String a27 = "";
    @ExcelProperty(value = "分享描述", index = 28)
    private String a28 = "";
    @ExcelProperty(value = "商品卖点", index = 29)
    private String a29 = "";
    @ExcelProperty(value = "批准文号", index = 30)
    private String a30 = "";

    @ExcelProperty(value = "生产企业", index = 31)
    private String a31 = "";
    @ExcelProperty(value = "有效期", index = 32)
    private String a32 = "";
    @ExcelProperty(value = "药品通用名", index = 33)
    private String a33 = "";
    @ExcelProperty(value = "产品剂型", index = 34)
    private String a34 = "";
    @ExcelProperty(value = "药品规格", index = 35)
    private String a35 = "";
    @ExcelProperty(value = "禁忌", index = 36)
    private String a36 = "";
    @ExcelProperty(value = "不良反应", index = 37)
    private String a37 = "";
    @ExcelProperty(value = "功能主治", index = 38)
    private String a38 = "";
    @ExcelProperty(value = "用法", index = 39)
    private String a39 = "";
    @ExcelProperty(value = "品牌", index = 40)
    private String a40 = "";

    @ExcelProperty(value = "药品分类", index = 41)
    private String a41 = "";
    @ExcelProperty(value = "药品类别", index = 42)
    private String a42 = "";
    @ExcelProperty(value = "产地", index = 43)
    private String a43 = "";
    @ExcelProperty(value = "错误信息", index = 44)
    private String a444 = "";
    @ExcelProperty(value = "图片地址", index = 45)
    private String a45 = "";


}
