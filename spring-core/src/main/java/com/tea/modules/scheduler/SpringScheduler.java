package com.tea.modules.scheduler;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;


/**
 * com.tea.modules.scheduler
 *
 * @author jaymin
 * @since 2021/7/19
 */
@Component
public class SpringScheduler implements SchedulingConfigurer {

    @Value("${com.tea.task.encrypt}")
    private String encryptTaskCorn;

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addTriggerTask(() -> {
            System.out.println("我是定时任务");
        }, triggerContext -> {
            System.out.println("当前cron:" + encryptTaskCorn);
            CronTrigger cronTrigger = new CronTrigger(encryptTaskCorn);
            return cronTrigger.nextExecutionTime(triggerContext);
        });
    }
}
