package cn.lanca.vo.user;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * project name:<font size="1"><b>小芄健康数据运营平台</b></font><br>
 * file name:<font size="1"><b>DictTemplate</b></font><br>
 * description:<font size="1"><b>平台字典数据操作实现类</b></font><br>
 * company name:<font size="1"><b>小芄医药科技（成都）有限公司-研发中心</b></font><br>
 *
 * @author <a href="mail to: ">mei.hongliang<br>
 * @version 1.0.0<br>
 * @since 2022/3/7 17:28  <br>
 */
@Data
public class CustomerGetVo {
    // 3个全必填
    /**
     * 粉丝id，如果没有写0
     */
    @NotNull(message = "fansId/粉丝id，如果没有写0")
    private Long fansId;
    /**
     * fans_type
     * fansType，与fansId成对出现，目前只支持=1
     */
    @NotNull(message = "fansType与fansId成对出现，目前只支持=1")
    private Short fansType;
    /**
     * 手机号，与fansId两者二选一，如果没有则写''0"
     */
    @NotEmpty(message = "mobile 手机号,与fansId两者二选一,如果没有则写'0'")
    private String mobile;
}
