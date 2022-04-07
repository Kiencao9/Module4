package com.codegym.model;

import org.springframework.web.multipart.MultipartFile;

public class BlogForm {
    private Long id;

    private String content;

    private String name;

    private MultipartFile image;

    private String time;

    public BlogForm() {
    }

    public BlogForm(Long id, String content, String name, MultipartFile image, String time) {
        this.id = id;
        this.content = content;
        this.name = name;
        this.image = image;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
