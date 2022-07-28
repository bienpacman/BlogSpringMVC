package com.blog.models;

import javax.persistence.*;

import java.sql.Date;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
//    @Size (min = 3, message = "Min 3");
    private String name ;
    private String title ;
    private String content ;
    private String img;
    private Date date;
@ManyToOne
private Category category;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

//    public Blog() {
//        long millis=System.currentTimeMillis();
//        date=new java.sql.Date(millis);
//    }

    public Blog() {
    }

    public Blog(long id, String name, String title, String content, String img, Date date) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.content = content;
        this.img = img;
        this.date = date;
    }

    public Blog(long id, String name, String title, String content, String img, Date date, Category category) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.content = content;
        this.img = img;
        this.date = date;
        this.category = category;
    }

}
