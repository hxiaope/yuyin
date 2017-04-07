package com.yuyin.pojo;

public class Music {
    private Long id;

    private String musicname;

    private String singer;

    private String album;

    private String musicimage;

    private String musicpath;

    private String musictime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMusicname() {
        return musicname;
    }

    public void setMusicname(String musicname) {
        this.musicname = musicname == null ? null : musicname.trim();
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer == null ? null : singer.trim();
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album == null ? null : album.trim();
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

    public String getMusictime() {
        return musictime;
    }

    public void setMusictime(String musictime) {
        this.musictime = musictime == null ? null : musictime.trim();
    }
}