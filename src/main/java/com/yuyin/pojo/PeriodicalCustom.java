package com.yuyin.pojo;

import java.util.List;

/**
 * 期刊一对多查询的类
 * @Title:PeriodicalCustom
 * @author hxiaope
 * @date 2017年3月18日下午8:36:29
 * @version 1.0
 */
public class PeriodicalCustom {

	private Long id;

    private String title;

    private String imagepath;

    private String tag;

    private String author;

    private String createtime;

    private String content;
    
    private List<Music> music;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<Music> getMusic() {
		return music;
	}

	public void setMusic(List<Music> music) {
		this.music = music;
	}
    
    
}
