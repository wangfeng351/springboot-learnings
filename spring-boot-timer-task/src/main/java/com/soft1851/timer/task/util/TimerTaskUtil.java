package com.soft1851.timer.task.util;

import lombok.SneakyThrows;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/5/1
 * @Version 1.0
 */
public class TimerTaskUtil {

    public static void atFixedSchedule(long delay, long period) {
        ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();
        Runnable runnable = new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                System.out.println("执行改任务时当前的时间为：" + LocalDateTime.now());
                Thread.sleep(4000);
                System.out.println("任务结束：" + LocalDateTime.now());
            }
        };
        ses.scheduleAtFixedRate(runnable, delay, period, TimeUnit.SECONDS);
    }

    public static void main(String[] args) {
        atFixedSchedule(2, 3);
    }
}
