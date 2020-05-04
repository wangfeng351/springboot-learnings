package com.soft1851.timer.task.util;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/5/1
 * @Version 1.0
 */
public class SampleJob extends QuartzJobBean {
    //定义一个SampleJob名称
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    //重写executeInternal方法，执行实际的任务
    @Override
    protected void executeInternal(JobExecutionContext context)
            throws JobExecutionException {
//        System.out.println(String.format("Hello %s!", this.name));
    }
}
