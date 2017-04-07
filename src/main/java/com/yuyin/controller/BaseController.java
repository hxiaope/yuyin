package com.yuyin.controller;
/**
 * 基础Controller，目前用于返回页面前缀
 * @Title:BaseController
 * @author hxiaope
 * @date 2017年3月4日上午10:28:59
 * @version 1.0
 */
public class BaseController {

	/**
	 * 取得静态页面模板路径
	 */
    public String getViewPath() {
		return "/WEB-INF/pages/";
	}
}
