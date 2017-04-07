package com.yuyin.pojo;

public class Thanks {
    private Long id;

    private Long periodicalId;

    private Long userId;

    private String headimage;

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getHeadimage() {
        return headimage;
    }

    public void setHeadimage(String headimage) {
        this.headimage = headimage == null ? null : headimage.trim();
    }
}