package com.example.jobs;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

import static java.lang.Thread.sleep;

@Component
@Slf4j
public class ScheduledJobs {

    //方法执行完5秒后继续执行方法
//    @Scheduled(fixedDelay = 5000)
//    public void fixedDelayJob() throws InterruptedException {
//        log.info("fixedDelay开始---->"+LocalDateTime.now());
//        sleep(10*1000);
//        log.info("fixedDelay结束---->"+LocalDateTime.now());
//    }


//    @Scheduled(fixedRate = 3000)
//    public void fixedDelayJob() throws InterruptedException {
//        log.info("fixedRate开始---->"+LocalDateTime.now());
//        sleep(2*1000);
//        log.info("fixedRate结束---->"+LocalDateTime.now());
//    }

//    @Scheduled(cron = "0/10 * * * * ?")
//    public void cronJob() throws InterruptedException {
//        log.info("cronJob开始---->"+LocalDateTime.now());
//    }

    @Scheduled(cron = "0 13 15 4 4 ?")
    public void cronJob() throws InterruptedException {
        log.info("生日快乐");
    }
}

