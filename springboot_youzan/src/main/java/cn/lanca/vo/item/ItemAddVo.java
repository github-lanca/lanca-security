package cn.lanca.vo.user.item;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * project name:<font size="1"><b>小芄健康数据运营平台</b></font><br>
 * file name:<font size="1"><b>DictTemplate</b></font><br>
 * description:<font size="1"><b>平台字典数据操作实现类</b></font><br>
 * company name:<font size="1"><b>小芄医药科技（成都）有限公司-研发中心</b></font><br>
 *
 * @author <a href="mail to: ">mei.hongliang<br>
 * @version 1.0.0<br>
 * @since 2022/3/8 14:43  <br>
 */
@Data
public class ItemAddVo {
    /**
     * 商品详情页内容。字数要大于5个字符，小于25000个字符（含html格式编码），
     * 受违禁词控制，敏感词说明：详见文档
     */
    @NotEmpty(message = "desc 商品详情页内容 字数要大于5个字符，小于25000个字符")
    private String desc;
    /**
     * 是否支持退款。true：支持；false：不支持。
     * 仅对虚拟商品、电子卡券有效
     */
    private boolean supportRefund;
    /**
     * 商品图片Id列表，用英文逗号分隔，最多上传15张。
     * 使用【youzan.materials.storage.platform.img.upload】接口上传获取图片id。注：测试店铺最大支持上传30M，以","进行分割
     */
    @NotNull(message = "imageIds 商品图片Id列表")
    private List<Long> imageIds;
    /**
     * 商品类型，
     * 0-实物商品,60-虚拟商品,61-电子卡劵，63-茶饮烘焙
     */
    @NotNull(message = "itemType 商品类型")
    private Integer itemType;
    /**
     * 商品价格，单位：分
     */
    @NotNull(message = "price 商品价格，单位：分")
    private Long price;
    /**
     * 商品标题。不能超过100字，受违禁词控制，敏感词说明：
     */
    @NotEmpty(message = "tcitle 商品标题。不能超过100字")
    private String title;
    /**
     * 商品库存， 无sku情况下库存必填，如果有sku则无效
     */
    @NotNull(message = "quantity 商品库存,无sku情况下库存必填,如果有sku则无效")
    private Long quantity;
    /**
     * 是否隐藏商品库存，在商品展示时不显示商品的库存，
     * 0-显示库存，1-不显示库存，默认0
     */
    @NotNull(message = "hideStock 是否隐藏商品库存")
    private Integer hideStock;

}
