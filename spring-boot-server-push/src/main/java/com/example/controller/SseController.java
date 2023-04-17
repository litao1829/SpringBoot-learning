package com.example.controller;

import com.example.domain.Certificate;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@Slf4j
public class SseController {
    @RequestMapping(value = "/sse/msg",method = RequestMethod.GET,produces = "text/event-stream;charset=UTF-8")
    public ResponseBodyEmitter pushMsg(){
        SseEmitter emitter=new SseEmitter(100L);
        log.info("emitter push msg ...");
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        List<String> list=List.of("aaa","bbb","ccc");
//        String str="hello msg";
        double price=Math.random()*1000+1;
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=new Date();
        String msg= format.format(date)+"股票价格:"+price;
//        Certificate certificate=new Certificate(format.format(date),price);
//        ObjectMapper objectMapper=new ObjectMapper();
//        String value=null;
//        try {
//             value= objectMapper.writeValueAsString(certificate);
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
        try {
            emitter.send(msg, MediaType.TEXT_EVENT_STREAM);
        } catch (IOException e) {
            throw  new RuntimeException(e);
        }
        return  emitter;
    }
}
