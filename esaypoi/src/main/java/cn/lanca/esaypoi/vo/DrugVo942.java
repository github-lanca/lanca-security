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
 * @since 2022/3/22 18:36  <br>
 */
@Data
public class DrugVo942 {

    /**
     *
     */
    @ExcelProperty(value = "序列", index = 0)
    private String a0;
    /**
     *
     */
    @ExcelProperty(value = "药品ID",index = 1)
    private String a1;
    /**
     *
     */
    @ExcelProperty(value = "商品名称（必填）",index = 2)
    private String a2;
    /**
     *
     */
    @ExcelProperty(value = "药品通用名",index = 3)
    private String a3;
    /**
     *
     */
    @ExcelProperty(value = "商品品牌",index = 4)
    private String a4;
    /**
     *
     */
    @ExcelProperty(value = "商品图片(需包含:药品正面图、侧面图、说明书图{清晰展示药品生产厂家的详细信息，包括生产厂家企业名称和地址})",index = 5)
    private String a5;
    /**
     *
     */
    @ExcelProperty(value = "基本单位",index = 6)
    private String a6;
    /**
     *
     */
    @ExcelProperty(value = "生产企业",index = 7)
    private String a7;
    /**
     *
     */
    @ExcelProperty(value = "条形码",index = 8)
    private String a8;
    /**
     *
     */
    @ExcelProperty(value = "网店商品分组",index = 9)
    private String a9;
    /**
     *
     */
    @ExcelProperty(value = "药品类型\n" +
            "（非处方药需填甲类乙类及跨境，其中甲类需填写三级分类）",index = 10)
    private String a10;
    /**
     *
     */
    @ExcelProperty(value = "药品类型\n" +
            "（非处方药需填甲类乙类及跨境，其中甲类需填写三级分类）",index = 11)
    private String a11;
    /**
     *
     */
    @ExcelProperty(value = "药品类型\n" +
            "（非处方药需填甲类乙类及跨境，其中甲类需填写三级分类）",index = 12)
    private String a12;
    /**
     *
     */
    @ExcelProperty(value = "药品类型\n" +
            "（非处方药需填甲类乙类及跨境，其中甲类需填写三级分类）",index = 13)
    private String a13;
    /**
     *
     */
    @ExcelProperty(value = "产品剂型",index = 14)
    private String a14;
    /**
     *
     */
    @ExcelProperty(value = "贮藏条件",index = 15)
    private String a15;
    /**
     *
     */
    @ExcelProperty(value = "批准文号",index = 16)
    private String a16;
    /**
     *
     */
    @ExcelProperty(value = "药品规格",index = 17)
    private String a17;
    /**
     *
     */
    @ExcelProperty(value = "价格（必填）",index = 18)
    private String a18;
    /**
     *
     */
    @ExcelProperty(value = "药品通用名:",index = 19)
    private String a19;
    /**
     *
     */
    @ExcelProperty(value = "产品图片",index = 20)
    private String images2;
    /**
     *
     */
    @ExcelProperty("疾病")
    private String jibing;

}
