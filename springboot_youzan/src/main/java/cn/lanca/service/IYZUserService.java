package cn.lanca.service;

import cn.lanca.vo.base.AjaxResult;
import cn.lanca.vo.user.CreateUserVo;
import cn.lanca.vo.user.CustomerGetVo;
import cn.lanca.vo.user.CustomerMemberVo;

import java.util.List;

/**
 * project name:<font size="1"><b>小芄健康数据运营平台</b></font><br>
 * file name:<font size="1"><b>DictTemplate</b></font><br>
 * description:<font size="1"><b>平台字典数据操作实现类</b></font><br>
 * company name:<font size="1"><b>小芄医药科技（成都）有限公司-研发中心</b></font><br>
 *
 * @author <a href="mail to: ">mei.hongliang<br>
 * @version 1.0.0<br>
 * @since 2022/3/7 15:36  <br>
 */
public interface IYZUserService {

    /**
     * title: <font size="1"><b> 根据手机号批量查询客户信息</b></font><br>
     * description:<font size="1"><b> 根据手机号批量查询客户信息</b></font><br>
     *
     * @param phoneList phoneList
     * @return AjaxResult <br>
     * @author <a href="">meihongliang</a><br>
     * @since 2022/3/7 15:56 <br>
     */
    AjaxResult userInfo(List<String> phoneList);


    /**
     * title: <font size="1"><b> 创建客户到店铺</b></font><br>
     * description:<font size="1"><b> 创建客户到店铺</b></font><br>
     *
     * @param createUserVo createUserVo
     * @return AjaxResult  <br>
     * @author <a href="">meihongliang</a><br>
     * @since 2022/3/7 15:57 <br>
     */
    AjaxResult userCreate(CreateUserVo createUserVo);

    /**
     * title: <font size="1"><b>创建客户会员身份信息 </b></font><br>
     * description:<font size="1"><b> 创建客户会员身份信息</b></font><br>
     *
     * @param customerMemberVo customerMemberVo
     * @return AjaxResult <br>
     * @author <a href="">meihongliang</a><br>
     * @since 2022/3/7 17:01 <br>
     */
    AjaxResult customerCreateMember(CustomerMemberVo customerMemberVo);

    /**
     * title: <font size="1"><b> 获取会员概要</b></font><br>
     * description:<font size="1"><b>获取会员概要 </b></font><br>
     *
     * @param customerGetVo customerGetVo
     * @author <a href="">meihongliang</a><br>
     * @since 2022/3/7 17:31 <br>
     * @return  <br>
     */
    AjaxResult customerGet(CustomerGetVo customerGetVo);

}
