package com.yuyin.common.pojo;
/**
 * EasyUI树形控件
 * @Title:EUTreeNode
 * @author hxiaope
 * @date 2016年10月26日上午12:36:27
 * @version 1.0
 */
public class EUTreeNode {
	
	private long id;
	private String text;
	private String state;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
