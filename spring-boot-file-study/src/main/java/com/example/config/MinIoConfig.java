package com.example.config;


import io.minio.*;
import io.minio.errors.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Configuration
public class MinIoConfig {

    @Value("${minio.endPoint}")
    private String endPoint;

    @Value("${minio.accessKey}")
    private String accessKey;

    @Value("${minio.secretKey}")
    private String secretKey;

    private MinioClient instance;

    @PostConstruct
    public void init(){
        instance=MinioClient.builder()
                .endpoint(endPoint)
                .credentials(accessKey,secretKey)
                .build();
    }

    private boolean bucketExists(String bucketName) throws Exception{
        return  instance.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
    }

    public void makeBucket(String bucketName) throws Exception {
            boolean flag= bucketExists(bucketName);
            if(!flag){
            instance.makeBucket(MakeBucketArgs.builder()
                    .bucket(bucketName)
                    .build());
        }
    }

    public ObjectWriteResponse uploadObject(String bucketName,String objName,String filePath) throws Exception{
        return instance.uploadObject(UploadObjectArgs.builder()
                .bucket(bucketName)
                .object(objName)
                .filename(filePath).build());
    }

    public ObjectWriteResponse putObject(String bucketName, String objectName, InputStream inputStream) throws Exception{
        return instance.putObject(PutObjectArgs.builder()
                .bucket(bucketName)
                .object(objectName)
                .stream(inputStream,-1,10485760).build());
    }

    public void removeObject(String bucketName,String objName) throws Exception{
        instance.removeObject(RemoveObjectArgs.builder()
                .bucket(bucketName)
                .object(objName)
                .build());
    }


    public void removeBucket(String bucketName) throws Exception {
        boolean flag = bucketExists(bucketName);
        if (flag) {
            instance.removeBucket(RemoveBucketArgs.builder()
                    .bucket(bucketName)
                    .build());
        }
    }
}
