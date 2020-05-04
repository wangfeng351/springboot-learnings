package com.soft1851.timer.task.util;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/5/1
 * @Version 1.0
 */
@Configuration
public class SampleScheduler {
    /**
     * 实例化JobDetail,withIdentity为Job创建名字和分组，
     *usingJobData以Key-Value形式关联数据
     *即使没有Trigger关联时，也不需要删除该JobDetail
     * @return
     */
    @Bean
    public JobDetail sampleJobDetail() {
        return JobBuilder.newJob(SampleJob.class).withIdentity("sampleJob")
                .usingJobData("name", "World").storeDurably().build();
    }

    /**
     * withIntervalInSeconds： 任务执行时间间隔
     * repeatForever 任务永不停止
     * @return
     */
    @Bean
    public Trigger sampleJobTrigger() {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(2).repeatForever();

        return TriggerBuilder.newTrigger().forJob(sampleJobDetail())
                .withIdentity("sampleTrigger").withSchedule(scheduleBuilder).build();
    }
}
