package com.example.task;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static java.lang.System.currentTimeMillis;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class SyncTaskTest {

    @Resource
    private SyncTask syncTask;

    @Test
    void t1() throws InterruptedException {
        long start = currentTimeMillis();
        syncTask.doTaskOne();
        syncTask.doTaskTwo();
        syncTask.doTaskThree();
        long end = currentTimeMillis();

        log.info("总耗时:"+(end-start)+"毫秒");
    }
}