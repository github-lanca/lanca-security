package cn.lanca.vo.item;

import lombok.Data;

import java.util.List;

/**
 * project name:<font size="1"><b>小芄健康数据运营平台</b></font><br>
 * file name:<font size="1"><b>DictTemplate</b></font><br>
 * description:<font size="1"><b>平台字典数据操作实现类</b></font><br>
 * company name:<font size="1"><b>小芄医药科技（成都）有限公司-研发中心</b></font><br>
 *
 * @author <a href="mail to: ">mei.hongliang<br>
 * @version 1.0.0<br>
 * @since 2022/3/8 11:16  <br>
 */
@Data
public class ItemSearchVo {

    /**
     * 页码大小，传值范围1~50；
     * 大于50会报错。search_after查询方式，不限制查询总数，配合page_size使用。
     * 如使用page_no* page_size最大可获得5000条数据。
     */
    private Integer page_size;
    /**
     * 渠道信息；
     * 0-网店；1-门店；3-课程；
     */
    private Integer channel;
    /**
     * 连锁店铺场景查询网店自建商品：
     * 传值["CREATE_TYPE=1"]
     */
    private List<String> createType;
    /**
     * 商品标题，支持模糊查询；
     */
    private String title;
    /**
     * 商品SKU编码（商家为商品规格设置的外部自定义编号，可与商家外部系统对接）；
     * 最大支持传值20条,["dy123","dy345"]
     */
    private List<String> skuNos;
    /**
     * 默认必传ID_DESC；search_after必传时和sorts请求信息保持一致。
     * 需要配合page_size一起使用；传值字段[item_id]。首次请求为[]。
     * 例如sorts排序规则为created_time降序，id降序第一次请求时，search_after为[]，
     * 获取第一页的数据；接下来的每次请求search_after传入返回的最后一个商品id，
     * 其他请求参数不变，便可以获得下一页的数据。
     * [5678723]
     */
    private List<Object> searchAfter;
    /**
     * 商品编码（商家为商品设置的外部自定义编号，可与商家外部系统对接）
     * spu
     */
    private String itemNos;
    //------>
    /**
     * 最小销量；查询区间大于等于
     * 100
     */
    private Long minSoldNum;
    /**
     * 商品创建时间；查询区间小于等于 ；
     * Unix时间戳，单位：毫秒
     */
    private Long maxCreateTime;
    /**
     * 最大价格；查询区间小于等于 ；单位：分
     */
    private Long maxPrice;
    /**
     * 最大销量；查询区间小于等于
     */
    private Long maxSoldNum;
    /**
     * 商品更新时间；查询区间大于等于；Unix时间戳，单位：毫秒
     */
    private Long minUpdateTime;
    /**
     * 商品更新时间；查询区间小于等于；Unix时间戳，单位：毫秒
     */
    private Long maxUpdateTime;
    /**
     * 最小价格；查询区间大于等于；单位：分
     */
    private Long minPrice;
    /**
     * 商品创建时间；查询区间大于等于，；Unix时间戳，单位：毫秒
     */
    private Long minCreateTime;
    //------->
    /**
     * 店铺ID列表，总部查询门店或网店商品信息，连锁店铺使用字段。最大支持传值20条
     */
    private List<Long> kdtIds;
    /**
     * 商品类目ID
     */
    private List<Long> categoryIds;
    /**
     * 默认必传ID_DESC，排序类型；当使用search_after时和sorts请求信息保持一致；
     * CREATED_TIME_DESC：商品创建时间降序排列；
     * CREATED_TIME_ASC商品创建时间升序排列 ；
     * ACTUAL_SOLD_NUM_DESC：商品实际售出数量降序排列；
     * ACTUAL_SOLD_NUM_ASC：商品实际售出数量升序排列；U
     * PDATE_TIME_DESC：商品最后更新时间降序排列；
     * UPDATE_TIME_ASC：商品最后更新时间升序排列；
     * PRICE_DESC：价格降序排列；
     * PRICE_ASC:价格升序排列；
     * NUM_DESC：商品设置的序号降序排列；
     * NUM_ASC:商品设置的序号商品库存升序排列；
     * STOCK_NUM_DESC：库存数量降序排列；
     * STOCK_NUM_ASC：库存数量升序排列
     * ["CREATED_TIME_DESC","ID_DESC"]
     */
    private List<String> sorts;
    /**
     * 一级分组列表；最大支持传值20条
     */
    private List<Long> tagIds;
    /**
     * 商品销售状态，需要配合is_display=1；
     * 查询所有全部：sold_status=[0,1,2,3]；
     * 查询销售中：sold_status=[0,1,3]和 is_display=1；查
     * 询已售罄：sold_status=[2,3] 和 is_display=1；
     * 查询仓库中：sold_status=[0,1,2,3] 和 is_display=0；
     * 枚举值说明：0-非有赞平台出售商品，1-全部在售商品；2-售罄状态为全部售罄；3-售罄状态为部分售罄；
     */
    private List<Integer> soldStatuses;
    /**
     * 页数；如使用page_no* page_size最大可获得5000条数据。
     */
    private Integer pageNo;
    /**
     * 商品条码
     */
    private List<String> barcodes;
    /**
     *二级分组列表；最大支持传值20条
     */
    private List<Long> secondTagIds;
    /**
     * 是否虚拟商品，使用item_types和s_virtual判断商品类型；详情见商品类型说明：
     */
    private List<Long> isVirtuals;
    /**
     *商品类型列表；使用item_types和s_virtual判断商品类型；详情见商品类型说明：；最大支持传值20条
     */
    private List<Integer> itemTypes;
    /**
     * 商品上下架状态；
     * 0=仓库中（商品下架会在仓库中），1=出售中和已售罄；
     * 不传默认查询所有信息；可以配合sold_statuses字段查询
     */
    private Integer isDisplay;

}
