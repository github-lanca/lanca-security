package cn.lanca.service.impl;

import cn.lanca.config.YouzanProperties;
import cn.lanca.service.IYZUserService;
import cn.lanca.vo.base.AjaxResult;
import cn.lanca.vo.user.CreateUserVo;
import cn.lanca.vo.user.CustomerGetVo;
import cn.lanca.vo.user.CustomerMemberVo;
import com.youzan.cloud.open.sdk.common.exception.SDKException;
import com.youzan.cloud.open.sdk.core.client.auth.Token;
import com.youzan.cloud.open.sdk.core.client.core.YouZanClient;
import com.youzan.cloud.open.sdk.gen.v1_0_0.api.YouzanScrmCustomerCreateMember;
import com.youzan.cloud.open.sdk.gen.v1_0_0.api.YouzanUsersInfoQuery;
import com.youzan.cloud.open.sdk.gen.v1_0_0.model.YouzanScrmCustomerCreateMemberParams;
import com.youzan.cloud.open.sdk.gen.v1_0_0.model.YouzanScrmCustomerCreateMemberResult;
import com.youzan.cloud.open.sdk.gen.v1_0_0.model.YouzanUsersInfoQueryParams;
import com.youzan.cloud.open.sdk.gen.v1_0_0.model.YouzanUsersInfoQueryResult;
import com.youzan.cloud.open.sdk.gen.v3_0_0.api.YouzanScrmCustomerCreate;
import com.youzan.cloud.open.sdk.gen.v3_0_0.model.YouzanScrmCustomerCreateParams;
import com.youzan.cloud.open.sdk.gen.v3_0_0.model.YouzanScrmCustomerCreateResult;
import com.youzan.cloud.open.sdk.gen.v3_0_0.model.YouzanScrmCustomerGetParams;
import com.youzan.cloud.open.sdk.gen.v3_0_0.model.YouzanScrmCustomerGetResult;
import com.youzan.cloud.open.sdk.gen.v3_1_1.api.YouzanScrmCustomerGet;
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
        YouzanScrmCustomerCreateMemberParams.YouzanScrmCustomerCreateMemberParamsMemberinfo memberinfo  = new YouzanScrmCustomerCreateMemberParams.YouzanScrmCustomerCreateMemberParamsMemberinfo();
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
            log.error("xxx:{}",e.getMessage());
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
            log.info("获取会员概要异常:{}",e.getMessage());
        }
        return AjaxResult.success(result);
    }
}
