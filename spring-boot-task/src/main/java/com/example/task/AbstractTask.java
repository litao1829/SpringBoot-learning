package com.example.task;


import lombok.extern.slf4j.Slf4j;

import static java.lang.System.currentTimeMillis;
import static java.lang.Thread.sleep;

@Slf4j
public abstract class AbstractTask {


    public void doTaskOne() throws InterruptedException {
        log.info("开始做任务一");
        long start = currentTimeMillis();
        sleep(5000);
        long end = currentTimeMillis();

        System.out.println("完成任务一，耗时："+(end-start)+"毫秒");
    }
    public void doTaskTwo() throws InterruptedException {
        log.info("开始做任务二");
        long start = currentTimeMillis();
        sleep(3000);
        long end = currentTimeMillis();

        System.out.println("完成任务二，耗时："+(end-start)+"毫秒");
    }
    public void doTaskThree() throws InterruptedException {
        log.info("开始做任务三");
        long start = currentTimeMillis();
        sleep(1500);
        long end = currentTimeMillis();

        System.out.println("完成任务三，耗时："+(end-start)+"毫秒");
    }
}
