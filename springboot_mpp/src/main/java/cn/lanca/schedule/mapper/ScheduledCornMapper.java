package cn.lanca.schedule.mapper;

import cn.lanca.schedule.ScheduledCorn;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * project name:<font size="1"><b>小芄健康数据运营平台</b></font><br>
 * file name:<font size="1"><b>DictTemplate</b></font><br>
 * description:<font size="1"><b>平台字典数据操作实现类</b></font><br>
 * company name:<font size="1"><b>小芄医药科技（成都）有限公司-研发中心</b></font><br>
 *
 * @author <a href="mail to: ">mei.hongliang<br>
 * @version 1.0.0<br>
 * @since 2022/3/15 11:39  <br>
 */
public interface ScheduledCornMapper extends BaseMapper<ScheduledCorn> {

    @Select("select * from spring_scheduled_cron where cronKey = #{cronKey}")
    ScheduledCorn findByCronKey(@Param("cronKey") String cronKey);
}
