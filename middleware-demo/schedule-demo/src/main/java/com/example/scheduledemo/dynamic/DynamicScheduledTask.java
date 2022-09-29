package com.example.scheduledemo.dynamic;

import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.util.concurrent.ScheduledFuture;

/**
 *  动态调度任务，可以随时启动、停止、修改corn
 *
 *  如果需要修改 corn ，可以先将定时任务关闭(endTask),在启动时传入新的 corn
 */
@Component
public class DynamicScheduledTask {
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;

    private ScheduledFuture future;

    public DynamicScheduledTask(final ThreadPoolTaskScheduler threadPoolTaskScheduler) {
        this.threadPoolTaskScheduler = threadPoolTaskScheduler;
    }

    /**
     * 启动定时器
     */
    public void startTask() {
        // 第一个参数为定时任务要执行的方法，第二个参数为定时任务执行的时间
        future = threadPoolTaskScheduler.schedule(this::send, new CronTrigger("* * * * * *"));
    }

    /**
     * 停止定时器
     */
    public void endTask() {
        if (future != null) {
            future.cancel(true);
        }
    }

    /**
     * 改变调度的时间，先停止定时器再启动新的定时器
     */
    public void changeTask() {
        // 停止定时器
        endTask();
        // 定义新的执行时间,并启动
        future = threadPoolTaskScheduler.schedule(this::send, new CronTrigger("* * * * * *"));
    }

    /**
     * 定时任务执行的方法
     */
    public void send(){
        TimeUsedSocket.send();
    }
}
