package cn.lanca.schedule;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * project name:<font size="1"><b>小芄健康数据运营平台</b></font><br>
 * file name:<font size="1"><b>DictTemplate</b></font><br>
 * description:<font size="1"><b>平台字典数据操作实现类</b></font><br>
 * company name:<font size="1"><b>小芄医药科技（成都）有限公司-研发中心</b></font><br>
 *
 * @author <a href="mail to: ">mei.hongliang<br>
 * @version 1.0.0<br>
 * @since 2022/3/15 11:40  <br>
 */
@Data
@TableName("spring_scheduled_cron")
public class ScheduledCorn {
    /**
     *主键id
     */
    @TableId
    private Integer cronId;
    /**
     *定时任务完整类名
     */
    private String cronKey;
    /**
     * cron表达式
     */
    private String cronExpression;
    /**
     * 任务描述
     */
    private String taskExplain;
    /**
     * 状态,1:正常;2:停用
     */
    private Integer status;
}
