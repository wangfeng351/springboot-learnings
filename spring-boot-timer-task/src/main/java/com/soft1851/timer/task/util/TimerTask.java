package com.soft1851.timer.task.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/5/4
 * @Version 1.0
 */
@Component
@Slf4j
public class TimerTask {
    private static final SimpleDateFormat format =
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Resource
    private WebSocketProcess webSocketProcess;

    @Scheduled(fixedDelay = 10000)
    public void sysMessage() {
        String message = "webSocket测试信息";
        webSocketProcess.sendAllMessage(message);
    }

}
