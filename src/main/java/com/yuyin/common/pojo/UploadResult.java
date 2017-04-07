package com.yuyin.common.pojo;

import java.util.Map;

/**
 * 文件上传返回数据格式
 * @Title:UploadResult
 * @author hxiaope
 * @date 2017年3月1日下午6:38:34
 * @version 1.0
 */
@SuppressWarnings("rawtypes")
public class UploadResult {

	private long code;    //状态码 01正常02异常
	private String msg;   //信息

	private Map data;   //文件路径
	public long getCode() {
		return code;
	}
	public void setCode(long code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Map getData() {
		return data;
	}
	public void setData(Map data) {
		this.data = data;
	}
	
}
