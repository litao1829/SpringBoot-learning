package com.example.config;

import io.minio.ObjectWriteResponse;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class MinIoConfigTest {

    @Resource
    private  MinIoConfig config;

    @Test
    public void makeBucket() throws Exception {
        config.makeBucket("litao");
    }

    @Test
    void uploadtest() throws  Exception{
        ObjectWriteResponse lt = config.uploadObject("litao", "a1.png", "C:\\Users\\Acer\\Desktop\\a1.png");
        log.info(lt.object());
    }
    @Test
     void removeBuket() throws Exception{
        config.removeBucket("litao");
    }
}