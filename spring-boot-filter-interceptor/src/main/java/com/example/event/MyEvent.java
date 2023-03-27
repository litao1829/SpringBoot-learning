package com.example.event;

import org.springframework.context.ApplicationEvent;

import java.time.Clock;

public class MyEvent extends ApplicationEvent {


    public MyEvent(Object source) {
        super(source);
    }
}
