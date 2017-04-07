package com.yuyin.pojo;

public class Single {
    private Long id;

    private Long musicId;

    private String singleauthor;

    private String createtime;

    private String singleimage;

    private String singlecontent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMusicId() {
        return musicId;
    }

    public void setMusicId(Long musicId) {
        this.musicId = musicId;
    }

    public String getSingleauthor() {
        return singleauthor;
    }

    public void setSingleauthor(String singleauthor) {
        this.singleauthor = singleauthor == null ? null : singleauthor.trim();
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }

    public String getSingleimage() {
        return singleimage;
    }

    public void setSingleimage(String singleimage) {
        this.singleimage = singleimage == null ? null : singleimage.trim();
    }

    public String getSinglecontent() {
        return singlecontent;
    }

    public void setSinglecontent(String singlecontent) {
        this.singlecontent = singlecontent == null ? null : singlecontent.trim();
    }
}