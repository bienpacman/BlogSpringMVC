package com.blog.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    private String name;
    private String content;
    private Date date;

    @ManyToOne
    private Blog blog;

    public Comment(){
        long millis = System.currentTimeMillis();
        date = new java.sql.Date(millis);
    }

    public Comment(long id, String name, String content, Date date, Blog blog) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.date = date;
        this.blog = blog;
    }

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }
}
