package com.example.task;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.Future;

import static java.lang.System.currentTimeMillis;
import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Slf4j
class AsyncTaskCallBackTest {
    @Resource
    private AsyncTaskCallBack asyncTaskCallBack;

    @Test
    void t1() throws InterruptedException {
        long start = currentTimeMillis();
        Future<String> future = asyncTaskCallBack.doTaskOneCallBack();
        Future<String> future2 = asyncTaskCallBack.doTaskTwoCallBack();
        Future<String> future3 = asyncTaskCallBack.doTaskThreeCallBack();

        while (!future.isDone()||!future2.isDone()||!future3.isDone()){
            sleep(1000);
        }
        long end = currentTimeMillis();

        log.info("总耗时:"+(end-start)+"毫秒");
    }
}