package com.codegym.model;

import javax.persistence.*;

@Entity
@Table(name = "blog_new")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "LONGTEXT")
    private String content;

    private String name;

    private String image;

    private String time;

    public Blog() {
    }

    public Blog(Long id, String content, String name, String image, String time) {
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
