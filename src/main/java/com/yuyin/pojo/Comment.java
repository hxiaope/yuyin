package com.yuyin.pojo;

public class Comment {
    private Long id;

    private Long periodicalId;

    private Long essaysId;

    private String createtime;

    private String formUser;

    private String toUser;

    private String content;

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

    public Long getEssaysId() {
        return essaysId;
    }

    public void setEssaysId(Long essaysId) {
        this.essaysId = essaysId;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }

    public String getFormUser() {
        return formUser;
    }

    public void setFormUser(String formUser) {
        this.formUser = formUser == null ? null : formUser.trim();
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser == null ? null : toUser.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}