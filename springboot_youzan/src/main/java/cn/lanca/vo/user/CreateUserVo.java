package cn.lanca.vo.user;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * project name:<font size="1"><b>小芄健康数据运营平台</b></font><br>
 * file name:<font size="1"><b>DictTemplate</b></font><br>
 * description:<font size="1"><b>平台字典数据操作实现类</b></font><br>
 * company name:<font size="1"><b>小芄医药科技（成都）有限公司-研发中心</b></font><br>
 *
 * @author <a href="mail to: ">mei.hongliang<br>
 * @version 1.0.0<br>
 * @since 2022/3/7 15:55  <br>
 */
@Data
public class CreateUserVo {

    /**
     * 必填**
     * 注册手机号（仅支持中国大陆地区手机号码）
     */
    @NotEmpty(message = "注册手机号不能为空")
    private String mobile;
    /**
     * 微信号
     */
    private String weiXin;
    /**
     * 性别，0：未知；1：男；2：女
     */
    private Integer gender;
    /**
     * 地域编码，需传入区级编码才会生效。使用【youzan.regions.get】接口获取地区编码，
     * 建议使用【youzan.regions.get】接口入参{“level": 0,"parent_id": 0}在响应参数中直接获取id字段（即区级地区编码）；
     * 如下示例{"parent_id": 330100,"name": "西湖区","id": 330106}取330106传入即可。
     */
    private Integer areaCode;
    /**
     * 客户信息备注
     */
    private String remark;
    /**
     * 生日(日期格式:yyyy-MM-dd HH:mm:ss)
     */
    private String birthday;
    /**
     * 姓名
     */
    private String name;
    /**
     * 归属分店
     */
    private Long ascriptionKdtId;
    /**
     * scrm渠道类型（2：伯俊），其他开发者无需使用该字段
     */
    private Integer scrmChannelType;
    /**
     * 客户来源方式（不传或0：其他，2008：系统打通）
     */
    private Integer srcWay;
    /**
     * 客户来源渠道（不传或0：其他，2000：三方门店）
     */
    private Integer srcChannel;
    /**
     * 是否授权手机号（目前创建客户时授权手机号后不会计算客户等级，需调等级设置接口设置等级）
     */
    private boolean isMobileAuth;
    /**
     * 是否需要走扩展点，不传参数默认为true，true-走扩展点 false-不走扩展点 （其中扩展点为第三方创建客户）
     */
    private boolean isDoExtPoint;
    /**
     * 用户创建时间(日期格式:yyyy-MM-dd HH:mm:ss)
     * 2020-05-13 00:00:00
     */
    private String createDate;


}
