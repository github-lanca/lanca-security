package cn.lanca.controller;

import cn.lanca.service.IYZUserService;
import cn.lanca.util.YouzanUtils;
import cn.lanca.vo.base.AjaxResult;
import cn.lanca.vo.user.CreateUserVo;
import cn.lanca.vo.user.CustomerGetVo;
import cn.lanca.vo.user.CustomerMemberVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * project name:<font size="1"><b>小芄健康数据运营平台</b></font><br>
 * file name:<font size="1"><b>DictTemplate</b></font><br>
 * description:<font size="1"><b>平台字典数据操作实现类</b></font><br>
 * company name:<font size="1"><b>小芄医药科技（成都）有限公司-研发中心</b></font><br>
 *
 * @author <a href="mail to: ">mei.hongliang<br>
 * @version 1.0.0<br>
 * @since 2022/3/7 10:50  <br>
 */
@Slf4j
@RestController()
public class YZUserController {

    @Autowired
    private IYZUserService iyzUserService;

    @Autowired
    private YouzanUtils youzanUtils;

    @GetMapping("util/getRegions")
    public AjaxResult getRegions(){
        return youzanUtils.getRegions();
    }

    /**
     * 用户查询接口
     * https://doc.youzanyun.com/detail/API/0/2193
     *
     * @param phoneList phoneList
     * @return Object
     */
    @PostMapping("/yzUser/userInfo")
    public AjaxResult userInfo(@RequestBody List<String> phoneList) {
        if (CollectionUtils.isEmpty(phoneList)){
            return AjaxResult.error("请至少传递一个参数");
        }
        return iyzUserService.userInfo(phoneList);
    }


    /**
     *API名称：创建客户到店铺
     * @return
     */
    @PostMapping("/yzUser/userCreate")
    public AjaxResult userCreate(@RequestBody @Validated CreateUserVo createUserVo) {
        if (ObjectUtils.isEmpty(createUserVo)){
            return AjaxResult.error("参数不能为空");
        }
        return iyzUserService.userCreate(createUserVo);
    }

    //------------------------------
    // #5.获取会员概要
    @PostMapping("/yzUser/customerGet")
    public AjaxResult customerGet(@RequestBody @Validated CustomerGetVo customerGetVo){
        //
        if (ObjectUtils.isEmpty(customerGetVo)){
            return AjaxResult.error("参数不能为空");
        }
        return iyzUserService.customerGet(customerGetVo);
    }


    //-------------------------------------------------
    // #6.创建客户会员身份信息
    // CustomerCreateMember
    @PostMapping("/yzUser/createMember")
    public AjaxResult customerCreateMember(@RequestBody @Validated CustomerMemberVo customerMemberVo){
        //
        if (ObjectUtils.isEmpty(customerMemberVo)){
            return AjaxResult.error("参数不能为空");
        }
        return iyzUserService.customerCreateMember(customerMemberVo);
    }
}
