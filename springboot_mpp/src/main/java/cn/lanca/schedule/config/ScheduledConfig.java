package cn.lanca.schedule.config;

import cn.lanca.schedule.mapper.ScheduledCornMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * project name:<font size="1"><b>小芄健康数据运营平台</b></font><br>
 * file name:<font size="1"><b>DictTemplate</b></font><br>
 * description:<font size="1"><b>平台字典数据操作实现类</b></font><br>
 * company name:<font size="1"><b>小芄医药科技（成都）有限公司-研发中心</b></font><br>
 *
 * @author <a href="mail to: ">mei.hongliang<br>
 * @version 1.0.0<br>
 * @since 2022/3/14 15:59  <br>
 */
@Configuration
public class ScheduledConfig /*implements SchedulingConfigurer*/ {

    @Autowired
    private ApplicationContext context;

    @Autowired
    private ScheduledCornMapper cornMapper;


//    @Override
//    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
//        List<ScheduledCorn> scheduledCorns = cornMapper.selectList(null);
//        for (ScheduledCorn springScheduledCron : scheduledCorns) {
//            Class<?> clazz;
//            Object task;
//            try {
//                clazz = Class.forName(springScheduledCron.getCronKey());
//                task = context.getBean(clazz);
//            } catch (ClassNotFoundException e) {
//                throw new IllegalArgumentException("spring_scheduled_cron表数据" + springScheduledCron.getCronKey() + "有误", e);
//            } catch (BeansException e) {
//                throw new IllegalArgumentException(springScheduledCron.getCronKey() + "未纳入到spring管理", e);
//            }
//            Assert.isAssignable(ScheduledOfTask.class, task.getClass(), "定时任务类必须实现ScheduledOfTask接口");
//            // 可以通过改变数据库数据进而实现动态改变执行周期
//            taskRegistrar.addTriggerTask(((Runnable) task),
//                    triggerContext -> {
//                        String cronExpression = cornMapper.findByCronKey(springScheduledCron.getCronKey()).getCronExpression();
//                        return new CronTrigger(cronExpression).nextExecutionTime(triggerContext);
//                    }
//            );
//        }
//    }

    @Bean
    public Executor taskExecutor() {
        return Executors.newScheduledThreadPool(10);
    }

    @Bean
    public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
        return new ThreadPoolTaskScheduler();
    }
}
