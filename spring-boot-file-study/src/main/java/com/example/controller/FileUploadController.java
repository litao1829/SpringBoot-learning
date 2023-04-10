package com.example.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@RestController
public class FileUploadController {

    @Value("${web.upload-path}")
    private String upoloadpatah;

    private SimpleDateFormat df=new SimpleDateFormat("yyyyMMdd");

    @PostMapping("/upload")
    //请求的name一定要是形参名
    public String upload(MultipartFile file, HttpServletRequest request) throws IOException {
        //创建子目录，实现了在uploadpath目录中通过日期对上传的文件归类保存
        String date=df.format(new Date());
        File folder=new File(upoloadpatah+date);
        if(!folder.isDirectory()){
            folder.mkdirs();
        }


        //对上传文件重命名，避免冲突
        //获取上传的文件的文件名
        String oldname=file.getOriginalFilename();
        String newname=null;
       if(oldname!=null){
           newname= UUID.randomUUID().toString()+
                   oldname.substring(oldname.lastIndexOf("."));
       }

       //上传：文件复制搬运
        file.transferTo(new File(folder,newname));


       //返回上传后的访问路径
        String filepath=request.getScheme()+"://"+request.getServerName()+":"
                +request.getServerPort()+"/"+date+"/"+newname;
        return filepath;
    }

}
