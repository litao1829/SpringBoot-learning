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
class AsycExecutorTaskTest {

    @Resource
    private AsycExecutorTask asycExecutorTask;

    @Test
    void t1() throws InterruptedException {
        long start = currentTimeMillis();
        Future<String> future = asycExecutorTask.doTaskOneCallBack();
        Future<String> future1 = asycExecutorTask.doTaskTwoCallBack();
        Future<String> future2 = asycExecutorTask.doTaskThreeCallBack();
        while (!future.isDone()||!future1.isDone()||!future2.isDone()){
            sleep(1000);
        }
        long end = currentTimeMillis();

        log.info("总耗时:"+(end-start)+"毫秒");
    }
}