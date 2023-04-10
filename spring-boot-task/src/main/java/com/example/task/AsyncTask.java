package com.example.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AsyncTask extends AbstractTask{
    @Override
    @Async
    public void doTaskOne() throws InterruptedException {
        super.doTaskOne();
    }

    @Override
    @Async
    public void doTaskTwo() throws InterruptedException {
        super.doTaskTwo();
    }

    @Override
    @Async
    public void doTaskThree() throws InterruptedException {
        super.doTaskThree();
    }
}
