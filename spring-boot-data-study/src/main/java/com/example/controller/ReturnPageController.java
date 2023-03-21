package com.example.controller;

import com.example.domain.Discuss;
import com.example.repository.DiscussRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class ReturnPageController {

    @Autowired
    private DiscussRepository discussRepository;

    @GetMapping("/page")
    @ResponseBody
    public List<Discuss> getpage(Integer page,Integer size){
        List<Discuss> discussByPage=null;
        if(page!=null&&size!=null)
        {
            Pageable pageable= PageRequest.of(page,size);
            discussByPage = discussRepository.getDiscussByPage(pageable);
        }
        else {
            Pageable pageable= PageRequest.of(0,2);
             discussByPage= discussRepository.getDiscussByPage(pageable);
        }
        return discussByPage;
    }
}
