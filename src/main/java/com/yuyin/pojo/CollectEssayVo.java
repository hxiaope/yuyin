package com.yuyin.pojo;

/**
 * Created by IntelliJ IDEA.
 * author: hxiaope
 * 2017/4/10.
 * version 1.0
 */
public class CollectEssayVo {
    private Long id;

    private Long essaysId;

    private String title;

    private String imagepath;

    private String author;

    private String createtime;

    private String subscribe;

    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEssaysId() {
        return essaysId;
    }

    public void setEssaysId(Long essaysId) {
        this.essaysId = essaysId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImagepath() {
        return imagepath;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getSubscribe() {
        return subscribe;
    }

    public void setSubscribe(String subscribe) {
        this.subscribe = subscribe;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
