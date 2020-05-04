package com.soft1851.timer.task.util;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/5/1
 * @Version 1.0
 */
public class SchedulerJob1 {
//    @Resource
//    private SampleScheduler sampleScheduler;
//
//    public void test() throws SchedulerException, IOException {
//        JobDetail job = sampleScheduler.sampleJobDetail();
//
//        job.getJobDataMap().put("name", "quertz"); //加入属性name到JobDataMap
//
//        //定义一个每秒执行一次的SimpleTrigger
//        Trigger trigger = sampleScheduler.sampleJobTrigger();
//
//        Scheduler sche = StdSchedulerFactory.getDefaultScheduler();
//        sche.scheduleJob(job, trigger);
//
//        sche.start();
//
//        System.in.read();
//
//        sche.shutdown();
//    }
//
//    public static void main(String[] args) throws IOException, SchedulerException {
//        new SchedulerJob1().test();
//    }
}
