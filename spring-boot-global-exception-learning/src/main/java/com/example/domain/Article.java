package com.example.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Article {
    @Min(value = 3,message = "文章id不能小于3")
    private int id;
    @NotEmpty(message = "文章标题不能为空")
    private String title;
    @Length(min = 2,max = 6,message = "作者的名字长度要在2-4之间")
    private String author;



    //前台传送到后台的格式
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    //后台传送到前台的格式
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Future(message = "需要将来的时间")
    private LocalDateTime date;

    public Article() {
    }

    public Article(int id, String title, String author, LocalDateTime date) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
