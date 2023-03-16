package com.example.service;


import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.MultipartUpload;
import com.example.OssConfig.OssConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Service
public class UploadService {

    @Autowired
    private OssConfig ossConfig;

    public String ossUpload(MultipartFile file){
        String endpoint = ossConfig.getEndpoint();
        String ak = ossConfig.getAk();
        String secret = ossConfig.getSecret();
        String bucket = ossConfig.getBucket();
        String dir = ossConfig.getDir();
        String host = ossConfig.getHost();

        //创建OssClient实例
        OSS ossClient=new OSSClientBuilder().build(endpoint,ak,secret);

        //上传之后的路径
        String path=dir+file.getOriginalFilename();

        //获取读取文件的输入流
        InputStream inputStream=null;

        try {
            inputStream=file.getInputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //使用putObject方法上传，第一个参数是Bucket，第二个参数是路径，第三个参数是输入流
        ossClient.putObject(bucket,path,inputStream);

        //关闭
        ossClient.shutdown();
        try {
            inputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return host+path;
    }

}
