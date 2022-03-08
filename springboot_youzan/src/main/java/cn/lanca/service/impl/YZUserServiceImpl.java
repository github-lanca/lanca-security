package cn.lanca.service.impl;

import cn.lanca.config.YouzanProperties;
import cn.lanca.service.IYZUserService;
import cn.lanca.vo.base.AjaxResult;
import cn.lanca.vo.item.IncreasePointVo;
import cn.lanca.vo.item.ItemAddVo;
import cn.lanca.vo.item.ItemSearchVo;
import cn.lanca.vo.item.RetailSkuVo;
import cn.lanca.vo.user.CreateUserVo;
import cn.lanca.vo.user.CustomerGetVo;
import cn.lanca.vo.user.CustomerMemberVo;
import com.youzan.cloud.open.sdk.common.exception.SDKException;
import com.youzan.cloud.open.sdk.core.client.auth.Token;
import com.youzan.cloud.open.sdk.core.client.core.YouZanClient;
import com.youzan.cloud.open.sdk.gen.v1_0_0.api.YouzanItemAdd;
import com.youzan.cloud.open.sdk.gen.v1_0_0.api.YouzanItemCommonSearch;
import com.youzan.cloud.open.sdk.gen.v1_0_0.api.YouzanScrmCustomerCreateMember;
import com.youzan.cloud.open.sdk.gen.v1_0_0.api.YouzanUserOpenidGet;
import com.youzan.cloud.open.sdk.gen.v1_0_0.api.YouzanUsersInfoQuery;
import com.youzan.cloud.open.sdk.gen.v1_0_0.model.YouzanItemAddParams;
import com.youzan.cloud.open.sdk.gen.v1_0_0.model.YouzanItemAddResult;
import com.youzan.cloud.open.sdk.gen.v1_0_0.model.YouzanItemCommonSearchParams;
import com.youzan.cloud.open.sdk.gen.v1_0_0.model.YouzanItemCommonSearchResult;
import com.youzan.cloud.open.sdk.gen.v1_0_0.model.YouzanScrmCustomerCreateMemberParams;
import com.youzan.cloud.open.sdk.gen.v1_0_0.model.YouzanScrmCustomerCreateMemberResult;
import com.youzan.cloud.open.sdk.gen.v1_0_0.model.YouzanUserOpenidGetParams;
import com.youzan.cloud.open.sdk.gen.v1_0_0.model.YouzanUserOpenidGetResult;
import com.youzan.cloud.open.sdk.gen.v1_0_0.model.YouzanUsersInfoQueryParams;
import com.youzan.cloud.open.sdk.gen.v1_0_0.model.YouzanUsersInfoQueryResult;
import com.youzan.cloud.open.sdk.gen.v3_0_0.api.YouzanRetailOpenOfflineSpuRelease;
import com.youzan.cloud.open.sdk.gen.v3_0_0.api.YouzanRetailOpenSkuGet;
import com.youzan.cloud.open.sdk.gen.v3_0_0.api.YouzanRetailOpenSkuQuery;
import com.youzan.cloud.open.sdk.gen.v3_0_0.api.YouzanScrmCustomerCreate;
import com.youzan.cloud.open.sdk.gen.v3_0_0.model.YouzanRetailOpenOfflineSpuReleaseParams;
import com.youzan.cloud.open.sdk.gen.v3_0_0.model.YouzanRetailOpenOfflineSpuReleaseResult;
import com.youzan.cloud.open.sdk.gen.v3_0_0.model.YouzanRetailOpenSkuGetParams;
import com.youzan.cloud.open.sdk.gen.v3_0_0.model.YouzanRetailOpenSkuGetResult;
import com.youzan.cloud.open.sdk.gen.v3_0_0.model.YouzanRetailOpenSkuQueryParams;
import com.youzan.cloud.open.sdk.gen.v3_0_0.model.YouzanRetailOpenSkuQueryResult;
import com.youzan.cloud.open.sdk.gen.v3_0_0.model.YouzanScrmCustomerCreateParams;
import com.youzan.cloud.open.sdk.gen.v3_0_0.model.YouzanScrmCustomerCreateResult;
import com.youzan.cloud.open.sdk.gen.v3_0_0.model.YouzanScrmCustomerGetParams;
import com.youzan.cloud.open.sdk.gen.v3_0_0.model.YouzanScrmCustomerGetResult;
import com.youzan.cloud.open.sdk.gen.v3_1_1.api.YouzanScrmCustomerGet;
import com.youzan.cloud.open.sdk.gen.v4_0_0.api.YouzanCrmCustomerPointsOperateIncreasewithexpire;
import com.youzan.cloud.open.sdk.gen.v4_0_0.model.YouzanCrmCustomerPointsOperateIncreasewithexpireParams;
import com.youzan.cloud.open.sdk.gen.v4_0_0.model.YouzanCrmCustomerPointsOperateIncreasewithexpireResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Date;
import java.util.List;

/**
 * project name:<font size="1"><b>小芄健康数据运营平台</b></font><br>
 * file name:<font size="1"><b>DictTemplate</b></font><br>
 * description:<font size="1"><b>平台字典数据操作实现类</b></font><br>
 * company name:<font size="1"><b>小芄医药科技（成都）有限公司-研发中心</b></font><br>
 *
 * @author <a href="mail to: ">mei.hongliang<br>
 * @version 1.0.0<br>
 * @since 2022/3/7 15:51  <br>
 */
@Slf4j
@Service
public class YZUserServiceImpl implements IYZUserService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private YouZanClient yzClient;

    public Token getToken() {
        Token youzanToken = null;
        Object o = redisTemplate.opsForValue().get("youzanToken_" + YouzanProperties.GRANT_ID);
        if (!ObjectUtils.isEmpty(o)) {
            youzanToken = new Token(o.toString());
        }
        return youzanToken;
    }

    /**
     * title: <font size="1"><b> 根据手机号批量查询客户信息</b></font><br>
     * description:<font size="1"><b> 根据手机号批量查询客户信息</b></font><br>
     *
     * @param phoneList phoneList
     * @return AjaxResult <br>
     * @author <a href="">meihongliang</a><br>
     * @since 2022/3/7 15:56 <br>
     */
    @Override
    public AjaxResult userInfo(List<String> phoneList) {
        log.info("yzClient={}", yzClient);
        log.info("getVersion={}", yzClient.getVersion());

        Token youzanToken = getToken();
        log.info("youzanToken={}", youzanToken);
        YouzanUsersInfoQuery youzanUsersInfoQuery = new YouzanUsersInfoQuery();
        //创建参数对象,并设置参数
        YouzanUsersInfoQueryParams youzanUsersInfoQueryParams = new YouzanUsersInfoQueryParams();
        youzanUsersInfoQueryParams.setMobile(phoneList.get(0));
        youzanUsersInfoQuery.setAPIParams(youzanUsersInfoQueryParams);
        YouzanUsersInfoQueryResult result = null;
        try {
            result = yzClient.invoke(youzanUsersInfoQuery, youzanToken, YouzanUsersInfoQueryResult.class);
        } catch (SDKException e) {
            e.printStackTrace();
            return AjaxResult.error(e.getMessage());
        }
        return AjaxResult.success(result);
    }


    /**
     * title: <font size="1"><b> 创建客户到店铺</b></font><br>
     * description:<font size="1"><b> 创建客户到店铺</b></font><br>
     *
     * @param createUserVo createUserVo
     * @return AjaxResult  <br>
     * @author <a href="">meihongliang</a><br>
     * @since 2022/3/7 15:57 <br>
     */
    @Override
    public AjaxResult userCreate(CreateUserVo createUserVo) {
        YouzanScrmCustomerCreate yzCreate = new YouzanScrmCustomerCreate();
        //创建参数对象,并设置参数
        YouzanScrmCustomerCreateParams yzParams = new YouzanScrmCustomerCreateParams();
        YouzanScrmCustomerCreateParams.YouzanScrmCustomerCreateParamsCustomercreate yscccpcc = new YouzanScrmCustomerCreateParams.YouzanScrmCustomerCreateParamsCustomercreate();
        yzParams.setCustomerCreate(yscccpcc);
        yscccpcc.setGender((short) 1);
        YouzanScrmCustomerCreateParams.YouzanScrmCustomerCreateParamsContactaddress contactaddress = new YouzanScrmCustomerCreateParams.YouzanScrmCustomerCreateParamsContactaddress();
        yscccpcc.setContactAddress(contactaddress);
        contactaddress.setAreaCode(320000);
        yscccpcc.setBirthday("1995-02-7 00:00:00");
        yscccpcc.setName("授权手机号测试0445_duke");
        // duke 18080332688
//        yzParams.setMobile("18080332688");
        yzParams.setMobile(createUserVo.getMobile());
        yzParams.setScrmChannelType(2);
        YouzanScrmCustomerCreateParams.YouzanScrmCustomerCreateParamsLabelinfo ysccp = new YouzanScrmCustomerCreateParams.YouzanScrmCustomerCreateParamsLabelinfo();
        yzParams.setLabelInfo(ysccp);
        ysccp.setSrcWay(2008);
        ysccp.setSrcChannel(2000);
        yzParams.setIsMobileAuth(false);
        yzParams.setIsDoExtPoint(false);
        yzParams.setCreateDate("2022-02-7 00:00:00");
        yzCreate.setAPIParams(yzParams);
        Token youzanToken = getToken();
        YouzanScrmCustomerCreateResult result = null;
        try {
            result = yzClient.invoke(yzCreate, youzanToken, YouzanScrmCustomerCreateResult.class);
        } catch (SDKException e) {
            e.printStackTrace();
            log.info(e.getMessage());
        }
        return AjaxResult.success(result);
    }

    /**
     * title: <font size="1"><b>创建客户会员身份信息 </b></font><br>
     * description:<font size="1"><b> 创建客户会员身份信息</b></font><br>
     *
     * @param customerMemberVo customerMemberVo
     * @return AjaxResult <br>
     * @author <a href="">meihongliang</a><br>
     * @since 2022/3/7 17:01 <br>
     */
    @Override
    public AjaxResult customerCreateMember(CustomerMemberVo customerMemberVo) {

        YouzanScrmCustomerCreateMember ysccm = new YouzanScrmCustomerCreateMember();
        //创建参数对象,并设置参数
        YouzanScrmCustomerCreateMemberParams ysccmParams = new YouzanScrmCustomerCreateMemberParams();
        YouzanScrmCustomerCreateMemberParams.YouzanScrmCustomerCreateMemberParamsMemberinfo memberinfo = new YouzanScrmCustomerCreateMemberParams.YouzanScrmCustomerCreateMemberParamsMemberinfo();
        ysccmParams.setMemberInfo(memberinfo);
        memberinfo.setMemberSrcWay(0);
        memberinfo.setMemberCreatedAt(new Date());
        memberinfo.setMemberSrcChannel(0);
        ysccmParams.setYzOpenId("HU0APtqB948970131248164864");
        ysccm.setAPIParams(ysccmParams);
        YouzanScrmCustomerCreateMemberResult result = null;
        try {
            result = yzClient.invoke(ysccm, getToken(), YouzanScrmCustomerCreateMemberResult.class);
            log.info("创建客户会员身份信息");
        } catch (SDKException e) {
            e.printStackTrace();
            log.error("xxx:{}", e.getMessage());
        }
        return AjaxResult.success(result);
    }

    /**
     * title: <font size="1"><b> 获取会员概要</b></font><br>
     * description:<font size="1"><b>获取会员概要 </b></font><br>
     *
     * @param customerGetVo@author <a href="">meihongliang</a><br>
     * @return <br>
     * @since 2022/3/7 17:31 <br>
     */
    @Override
    public AjaxResult customerGet(CustomerGetVo customerGetVo) {
        YouzanScrmCustomerGet youzanScrmCustomerGet = new YouzanScrmCustomerGet();
        //创建参数对象,并设置参数
        YouzanScrmCustomerGetParams youzanScrmCustomerGetParams = new YouzanScrmCustomerGetParams();
        youzanScrmCustomerGetParams.setMobile(customerGetVo.getMobile());
        youzanScrmCustomerGetParams.setFansType(customerGetVo.getFansType());
        youzanScrmCustomerGetParams.setFansId(customerGetVo.getFansId());
        youzanScrmCustomerGet.setAPIParams(youzanScrmCustomerGetParams);
        YouzanScrmCustomerGetResult result = null;
        try {
            result = yzClient.invoke(youzanScrmCustomerGet, getToken(), YouzanScrmCustomerGetResult.class);
            log.info("获取会员概要");
        } catch (SDKException e) {
            e.printStackTrace();
            log.info("获取会员概要异常:{}", e.getMessage());
        }
        return AjaxResult.success(result);
    }

    /**
     * title: <font size="1"><b> 增加有效期积分</b></font><br>
     * description:<font size="1"><b> 增加有效期积分</b></font><br>
     *
     * @param increasePointVo increasePointVo
     * @return AjaxResult <br>
     * @author <a href="">meihongliang</a><br>
     * @since 2022/3/8 10:01 <br>
     */
    @Override
    public AjaxResult increaseWithExpire(IncreasePointVo increasePointVo) {
        YouzanCrmCustomerPointsOperateIncreasewithexpire youzanCrmCustomerPointsOperateIncreasewithexpire = new YouzanCrmCustomerPointsOperateIncreasewithexpire();
        //创建参数对象,并设置参数
        YouzanCrmCustomerPointsOperateIncreasewithexpireParams params = new YouzanCrmCustomerPointsOperateIncreasewithexpireParams();
        YouzanCrmCustomerPointsOperateIncreasewithexpireParams.YouzanCrmCustomerPointsOperateIncreasewithexpireParamsParams paramsParams = new YouzanCrmCustomerPointsOperateIncreasewithexpireParams.YouzanCrmCustomerPointsOperateIncreasewithexpireParamsParams();
        youzanCrmCustomerPointsOperateIncreasewithexpire.setAPIParams(params);
        params.setParams(paramsParams);
        YouzanCrmCustomerPointsOperateIncreasewithexpireParams.YouzanCrmCustomerPointsOperateIncreasewithexpireParamsUser paramsUser = new YouzanCrmCustomerPointsOperateIncreasewithexpireParams.YouzanCrmCustomerPointsOperateIncreasewithexpireParamsUser();
        paramsParams.setUser(paramsUser);
        paramsUser.setOperatorName("mhl_operator");
        paramsUser.setAccountType(5);
        paramsUser.setAccountId(increasePointVo.getAccountId());
        paramsParams.setDescription("mhl_手动调控_增加有效期积分");
        paramsParams.setBizValue("IN20190820029");
        paramsParams.setCheckCustomer(false);
        paramsParams.setEventType(99);
        // 冻结&消费积分值
        paramsParams.setPoints(10);
        paramsParams.setSendMessage(false);
        paramsParams.setIsDoExtPoint(true);
        paramsParams.setBizToken("AA39-904BF2F97A44");
        // 过期时间(必须大于当前时间,且精度为天,比如:2021-01-01 10:10:10,会当 2021-01-01 00:00:00处理)
//        LocalDateTime now = LocalDateTime.now();
//        LocalDateTime localDateTime = now.plusDays(7);
//        Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
//        Date from = Date.from(instant);
        paramsParams.setExpiredAt(increasePointVo.getExpiredAt());

        YouzanCrmCustomerPointsOperateIncreasewithexpireResult result = null;
        try {
            result = yzClient.invoke(youzanCrmCustomerPointsOperateIncreasewithexpire, getToken(), YouzanCrmCustomerPointsOperateIncreasewithexpireResult.class);
        } catch (SDKException e) {
            e.printStackTrace();
            return AjaxResult.error(e.getMessage());
        }
        return AjaxResult.success(result);
    }

    /**
     * title: <font size="1"><b> 批量查询店铺下商品列表</b></font><br>
     * description:<font size="1"><b> 批量查询店铺下商品列表</b></font><br>
     *
     * @param itemSearchVo itemSearchVo
     * @return AjaxResult<br>
     * @author <a href="">meihongliang</a><br>
     * @since 2022/3/8 11:17 <br>
     */
    @Override
    public AjaxResult itemBatchSearch(ItemSearchVo itemSearchVo) {
        YouzanItemCommonSearch youzanItemCommonSearch = new YouzanItemCommonSearch();
        //创建参数对象,并设置参数
        YouzanItemCommonSearchParams youzanItemCommonSearchParams = new YouzanItemCommonSearchParams();
        youzanItemCommonSearchParams.setPageSize(2);
        youzanItemCommonSearch.setAPIParams(youzanItemCommonSearchParams);
        YouzanItemCommonSearchResult result = null;
        try {
            result = yzClient.invoke(youzanItemCommonSearch, getToken(), YouzanItemCommonSearchResult.class);
        } catch (SDKException e) {
            e.printStackTrace();
            return AjaxResult.error(e.getMessage());
        }
        return AjaxResult.success(result);
    }

    /**
     * title: <font size="1"><b>#12.查询商品规格信息详情 </b></font><br>
     * description:<font size="1"><b>#12.查询商品规格信息详情 </b></font><br>
     *
     * @param retailSkuVo retailSkuVo
     * @return AjaxResult <br>
     * @author <a href="">meihongliang</a><br>
     * @since 2022/3/8 11:27 <br>
     */
    @Override
    public AjaxResult retailSkuGet(RetailSkuVo retailSkuVo) {
        YouzanRetailOpenSkuGet youzanRetailOpenSkuGet = new YouzanRetailOpenSkuGet();
//创建参数对象,并设置参数
        YouzanRetailOpenSkuGetParams getParams = new YouzanRetailOpenSkuGetParams();
        getParams.setSkuNo("");
        getParams.setWarehouseCode("");
        getParams.setSkuCode("BM585913301672953210");
        youzanRetailOpenSkuGet.setAPIParams(getParams);

        YouzanRetailOpenSkuGetResult result = null;
        try {
            result = yzClient.invoke(youzanRetailOpenSkuGet, getToken(), YouzanRetailOpenSkuGetResult.class);
        } catch (SDKException e) {
            e.printStackTrace();
            return AjaxResult.error(e.getMessage());
        }
        return AjaxResult.success(result);
    }


    @Override
    public AjaxResult getSkuList() {
        YouzanRetailOpenSkuQuery youzanRetailOpenSkuQuery = new YouzanRetailOpenSkuQuery();
        //创建参数对象,并设置参数
        YouzanRetailOpenSkuQueryParams youzanRetailOpenSkuQueryParams = new YouzanRetailOpenSkuQueryParams();
        youzanRetailOpenSkuQuery.setAPIParams(youzanRetailOpenSkuQueryParams);

        YouzanRetailOpenSkuQueryResult result = null;
        try {
            result = yzClient.invoke(youzanRetailOpenSkuQuery, getToken(), YouzanRetailOpenSkuQueryResult.class);
        } catch (SDKException e) {
            e.printStackTrace();
            return AjaxResult.error(e.getMessage());
        }
        return AjaxResult.success(result);
    }

    /**
     * title: <font size="1"><b> #13.商品新增接口</b></font><br>
     * description:<font size="1"><b>#13.商品新增接口 </b></font><br>
     *
     * @param itemAddVo itemAddVo
     * @return AjaxResult <br>
     * @author <a href="">meihongliang</a><br>
     * @since 2022/3/8 14:24 <br>
     */
    @Override
    public AjaxResult itemAdd(ItemAddVo itemAddVo) {
        YouzanItemAdd youzanItemAdd = new YouzanItemAdd();
        //创建参数对象,并设置参数
        YouzanItemAddParams youzanItemAddParams = new YouzanItemAddParams();
        YouzanItemAddParams.YouzanItemAddParamsParam paramsParam = new YouzanItemAddParams.YouzanItemAddParamsParam();
        YouzanItemAddParams.YouzanItemAddParamsItemdeliveryparam itemdeliveryparam = new YouzanItemAddParams.YouzanItemAddParamsItemdeliveryparam();
        YouzanItemAddParams.YouzanItemAddParamsDeliverysetting deliverysetting = new YouzanItemAddParams.YouzanItemAddParamsDeliverysetting();
        deliverysetting.setExpress(true);
        deliverysetting.setCityDelivery(false);
        deliverysetting.setSelfPick(false);

        itemdeliveryparam.setPostage(500L);
        itemdeliveryparam.setDeliverySetting(deliverysetting);

        paramsParam.setItemDeliveryParam(itemdeliveryparam);


        YouzanItemAddParams.YouzanItemAddParamsPostsaleparam postsaleparam = new YouzanItemAddParams.YouzanItemAddParamsPostsaleparam();
        YouzanItemAddParams.YouzanItemAddParamsRefundparam refundparam = new YouzanItemAddParams.YouzanItemAddParamsRefundparam();
        refundparam.setSupportRefund(itemAddVo.isSupportRefund());

        postsaleparam.setRefundParam(refundparam);
        paramsParam.setPostSaleParam(postsaleparam);
        // 商品图片Id列表，用英文逗号分隔，最多上传15张。
        // 使用【youzan.materials.storage.platform.img.upload】
        // 接口上传获取图片id。注：测试店铺最大支持上传30M，以","进行分割
        paramsParam.setImageIds(itemAddVo.getImageIds());
        YouzanItemAddParams.YouzanItemAddParamsItempriceparam youzanItemAddParamsItemPriceParam = new YouzanItemAddParams.YouzanItemAddParamsItempriceparam();
        // 商品价格，单位：分 44.36元
        youzanItemAddParamsItemPriceParam.setPrice(itemAddVo.getPrice());
        paramsParam.setItemType(itemAddVo.getItemType());
        paramsParam.setItemPriceParam(youzanItemAddParamsItemPriceParam);
        paramsParam.setSummary("好的商品要分享");
        paramsParam.setTitle(itemAddVo.getTitle());
        paramsParam.setQuantity(itemAddVo.getQuantity());
        paramsParam.setHideStock(itemAddVo.getHideStock());
        paramsParam.setDesc(itemAddVo.getDesc());

        youzanItemAddParams.setParam(paramsParam);
        youzanItemAdd.setAPIParams(youzanItemAddParams);
        YouzanItemAddResult result = null;
        try {
            result = yzClient.invoke(youzanItemAdd, getToken(), YouzanItemAddResult.class);
        } catch (SDKException e) {
            e.printStackTrace();
            return AjaxResult.error(e.getMessage());
        }
        return AjaxResult.success(result);
    }

    /**
     * title: <font size="1"><b> 发布商品库商品至门店</b></font><br>
     * description:<font size="1"><b> 发布商品库商品至门店</b></font><br>
     *
     * @param spuReleaseParams spuReleaseParams
     * @return AjaxResult <br>
     * @author <a href="">meihongliang</a><br>
     * @since 2022/3/8 15:46 <br>
     */
    @Override
    public AjaxResult retailOfflineSpuRelease(YouzanRetailOpenOfflineSpuReleaseParams spuReleaseParams) {
        YouzanRetailOpenOfflineSpuRelease youzanRetailOpenOfflineSpuRelease = new YouzanRetailOpenOfflineSpuRelease();
        //创建参数对象,并设置参数
        youzanRetailOpenOfflineSpuRelease.setAPIParams(spuReleaseParams);

        YouzanRetailOpenOfflineSpuReleaseResult result = null;
        try {
            result = yzClient.invoke(youzanRetailOpenOfflineSpuRelease, getToken(), YouzanRetailOpenOfflineSpuReleaseResult.class);
        } catch (SDKException e) {
            e.printStackTrace();
            return AjaxResult.error(e.getMessage());
        }
        return AjaxResult.success(result);
    }


    public AjaxResult xxx() {
        YouzanUserOpenidGet youzanUserOpenidGet = new YouzanUserOpenidGet();
        //创建参数对象,并设置参数
        YouzanUserOpenidGetParams youzanUserOpenidGetParams = new YouzanUserOpenidGetParams();
        // "accountId": "16817627329",
        youzanUserOpenidGetParams.setUserId(8108606432L);
        youzanUserOpenidGet.setAPIParams(youzanUserOpenidGetParams);
        YouzanUserOpenidGetResult result = null;
        try {
            result = yzClient.invoke(youzanUserOpenidGet, getToken(), YouzanUserOpenidGetResult.class);
        } catch (SDKException e) {
            e.printStackTrace();
            return AjaxResult.error(e.getMessage());
        }
        return AjaxResult.success(result);
    }
}
