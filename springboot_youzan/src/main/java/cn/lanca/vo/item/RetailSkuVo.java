package cn.lanca.vo.user;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * project name:<font size="1"><b>小芄健康数据运营平台</b></font><br>
 * file name:<font size="1"><b>DictTemplate</b></font><br>
 * description:<font size="1"><b>平台字典数据操作实现类</b></font><br>
 * company name:<font size="1"><b>小芄医药科技（成都）有限公司-研发中心</b></font><br>
 *
 * @author <a href="mail to: ">mei.hongliang<br>
 * @version 1.0.0<br>
 * @since 2022/3/8 11:27  <br>
 */
@Data
public class RetailSkuVo {
    /**
     * 该字段已于2021-04-26号废弃取消校验，新接入开发者无需传值，已对接开发者不受影响。
     * 详情见：https://doc.youzanyun.com/resource/faq/27034/29009/33485
     */
    @JSONField(name = "retail_source")
    private String retailSource;
    /**
     * 商品条码/规格条码，支持商家自定义参数，支持英文和数字组合，店铺下唯一。
     * 可以通过youzan.retail.open.spu.query接口获取
     */
    @JSONField(name = "sku_no")
    private String skuNo;
    /**
     * 仓库编码，可通过youzan.retail.open.warehouse.query接口获取，
     * 如果不填，默认查总部商品库商品
     */
    @JSONField(name = "warehouse_code")
    private String warehouseCode;
    /**
     * 商品编码/规格编码，支持商家自定义参数，支持英文和数字组合，店铺下唯一。
     * 可通过youzan.retail.open.spu.query接口获取
     */
    @JSONField(name = "sku_code")
    private String skuCode;
}
