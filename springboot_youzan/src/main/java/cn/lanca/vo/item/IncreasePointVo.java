package cn.lanca.vo.item;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * project name:<font size="1"><b>小芄健康数据运营平台</b></font><br>
 * file name:<font size="1"><b>DictTemplate</b></font><br>
 * description:<font size="1"><b>平台字典数据操作实现类</b></font><br>
 * company name:<font size="1"><b>小芄医药科技（成都）有限公司-研发中心</b></font><br>
 *
 * @author <a href="mail to: ">mei.hongliang<br>
 * @version 1.0.0<br>
 * @since 2022/3/8 09:50  <br>
 */
@Data
public class IncreasePointVo {
    /**
     * 操作人名字，可选字段
     */
    private String operatorName;
    /**
     * 帐号类型;
     * 支持的用户账号类型 1-有赞粉丝id(有赞不同的合作渠道会生成不同渠道对应在有赞平台下的fans_id) ;
     * 2-手机号; 3-三方帐号(原open_user_id:三方App用户ID，该参数仅限购买App开店插件的商家使用) ;
     * 5-有赞用户id，用户在有赞的唯一id。推荐使用）
     */
    @NotNull(message = "帐号类型accountType 必填")
    private Integer accountType;
    /**
     * 帐号ID
     */
    //@NotEmpty(message = "accountId 帐号ID必填")
    private String accountId;
    /**
     * 积分变动描述
     */
    private String description;
    /**
     * 业务唯一标识(例如,订单号transactionId)
     */
    private String bizValue;
    /**
     * 校验客户是否存在
     */
    private boolean checkCustomer;
    /**
     * 积分变动类别;
     * 99: "开放平台操作加积分"
     */
    @NotNull(message = "eventType 积分变动类别 必填")
    private Integer eventType;
    /**
     * 冻结&消费积分值
     */
    @NotNull(message = "points 冻结&消费积分值必须有值")
    private Integer points;
    /**
     * 是否发送微信通知
     */
    private boolean sendMessage;
    /**
     * 是否需要走扩展点，
     * 默认：true(false走内部逻辑)
     */
    private boolean isDoExtPoint;
    /**
     * 外部自定义Token,用于同一transactionId的多次积分操作
     */
    private String bizToken;
    /**
     *过期时间(必须大于当前时间,且精度为天,
     * 比如:2021-01-01 10:10:10,会当 2021-01-01 00:00:00处理)
     */
    @NotNull(message = "expiredAt 必填/过期时间(必须大于当前时间,且精度为天,")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date expiredAt;


}
