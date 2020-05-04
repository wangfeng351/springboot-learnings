package com.soft1851.timer.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//开启定时任务
@EnableScheduling
public class TimerTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(TimerTaskApplication.class, args);
    }

}
