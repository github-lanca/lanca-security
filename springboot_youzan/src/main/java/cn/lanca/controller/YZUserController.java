package cn.lanca.controller;

import cn.lanca.service.IYZUserService;
import cn.lanca.util.YouzanUtils;
import cn.lanca.vo.base.AjaxResult;
import cn.lanca.vo.item.IncreasePointVo;
import cn.lanca.vo.item.ItemAddVo;
import cn.lanca.vo.item.ItemSearchVo;
import cn.lanca.vo.item.RetailSkuVo;
import cn.lanca.vo.user.CreateUserVo;
import cn.lanca.vo.user.CustomerGetVo;
import cn.lanca.vo.user.CustomerMemberVo;
import com.youzan.cloud.open.sdk.gen.v3_0_0.model.YouzanRetailOpenOfflineSpuReleaseParams;
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


    //------------------------------------------------
    // #10 增加有效期积分
    // API描述：增加用户积分接口（有效期积分）
    // https://open.youzanyun.com/api/youzan.crm.customer.points.operate.increasewithexpire/4.0.0
    @PostMapping("/yzUser/increaseWithExpire")
    public AjaxResult increaseWithExpire(@RequestBody @Validated IncreasePointVo increasePointVo){
        return iyzUserService.increaseWithExpire(increasePointVo);
    }



    //----------------------------------------------
    //#11.API名称：批量查询店铺下商品列表
    // https://open.youzanyun.com/api/youzan.item.common.search/1.0.0
    @PostMapping("/yzUser/itemBatchSearch")
    public AjaxResult itemBatchSearch(@RequestBody @Validated ItemSearchVo itemSearchVo){
        return iyzUserService.itemBatchSearch(itemSearchVo);
    }

    //----------------------------------------------
    // #12.查询商品规格信息详情
    // https://open.youzanyun.com/api/youzan.retail.open.sku.get/3.0.0
    // https://doc.youzanyun.com/detail/API/0/247
    @PostMapping("/yzUser/retailSkuGet")
    public AjaxResult retailSkuGet(@RequestBody @Validated RetailSkuVo retailSkuVo){
        return iyzUserService.retailSkuGet(retailSkuVo);
    }

    // getSkuList
    @PostMapping("/yzUser/getSkuList")
    public AjaxResult getSkuList(){
        return iyzUserService.getSkuList();
    }

    //----------------------------------------------
    // #13.商品新增接口
    // https://doc.youzanyun.com/detail/API/0/1113
    @PostMapping("/yzUser/itemAdd")
    public AjaxResult itemAdd(@RequestBody @Validated ItemAddVo itemAddVo){
        return iyzUserService.itemAdd(itemAddVo);
    }

    //----------------------------------------------
    // #14.发布商品库商品至门店
    // https://doc.youzanyun.com/detail/API/0/294
    // https://open.youzanyun.com/api/youzan.retail.open.offline.spu.release/3.0.0
    @PostMapping("/yzUser/retailOfflineSpuRelease")
    public AjaxResult retailOfflineSpuRelease(@RequestBody @Validated YouzanRetailOpenOfflineSpuReleaseParams spuReleaseParams){
        return iyzUserService.retailOfflineSpuRelease(spuReleaseParams);
    }
}
