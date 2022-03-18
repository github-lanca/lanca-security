package cn.lanca.schedule.inter;

public interface ScheduledOfTask extends Runnable {

    /**
     * 定时任务方法
     */
    void execute();
    /**
     * 实现控制定时任务启用或禁用的功能
     */
    @Override
    default void run() {
//        ScheduledCornMapper mapper
//        ScheduledCornMapper cornMapper = SpringBeanPreparerFactory.getBean(ScheduledCornMapper.class);
//        SpringScheduledCron scheduledCron = cornMapper.findByCronKey(this.getClass().getName());
//        if (StatusEnum.DISABLED.getCode().equals(scheduledCron.getStatus())) {
//            // 任务是禁用状态
//            return;
//        }
        execute();
    }
}
