package com.example.controller;


import com.example.service.UploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UploadController {

    private final UploadService service;

    @GetMapping("/upload")
    @ResponseBody
    public String uploadFile(MultipartFile file){
        System.out.println("上传文件中....");
        return  service.ossUpload(file);
    }
}
