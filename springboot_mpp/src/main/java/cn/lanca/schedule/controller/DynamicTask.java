package cn.lanca.schedule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;

@RestController
@Component
public class DynamicTask {

    private Map<String, ScheduledFuture<?>> taskMap = new HashMap<>();

    @Autowired
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;


    @RequestMapping("/not/startCron")
    public String startCron(String threadName) {
        // 0/5 * * * * * ?
        // */5 * * * * ?
        ScheduledFuture future = threadPoolTaskScheduler.schedule(new MyRunnable(), new CronTrigger("*/5 * * * * ?"));
        taskMap.put(threadName, future);
        System.out.println(threadName + "DynamicTask.startCron()");
        return "startCron";
    }

    @RequestMapping("/not/stopCron")
    public String stopCron(String threadName) {
        ScheduledFuture<?> future = taskMap.get(threadName);
        if (future != null) {
            future.cancel(true);
        }
        System.out.println("DynamicTask.stopCron()");
        return "stopCron";
    }



    private class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("DynamicTask.MyRunnable.run()，" + new Date());
        }
    }
}
