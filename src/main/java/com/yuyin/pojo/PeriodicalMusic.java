package com.yuyin.pojo;

public class PeriodicalMusic {
    private Long id;

    private Long periodicalId;

    private Long musicId;

    private String musicimage;

    private String musicpath;

    private String createtime;

    private String musicname;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPeriodicalId() {
        return periodicalId;
    }

    public void setPeriodicalId(Long periodicalId) {
        this.periodicalId = periodicalId;
    }

    public Long getMusicId() {
        return musicId;
    }

    public void setMusicId(Long musicId) {
        this.musicId = musicId;
    }

    public String getMusicimage() {
        return musicimage;
    }

    public void setMusicimage(String musicimage) {
        this.musicimage = musicimage == null ? null : musicimage.trim();
    }

    public String getMusicpath() {
        return musicpath;
    }

    public void setMusicpath(String musicpath) {
        this.musicpath = musicpath == null ? null : musicpath.trim();
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }

    public String getMusicname() {
        return musicname;
    }

    public void setMusicname(String musicname) {
        this.musicname = musicname == null ? null : musicname.trim();
    }
}