package com.yuyin.service;

import com.yuyin.common.pojo.CommonResult;
import com.yuyin.common.pojo.PageResult;
import com.yuyin.pojo.Mark;

/**
 * 标签业务接口
 * @Title:TagManagerService
 * @author hxiaope
 * @date 2017年2月26日下午7:35:49
 * @version 1.0
 */
public interface TagManagerService {
	//获取标签列表单参数查询，支持模糊
	public PageResult findTagList(int page, int rows,String tagParam);
	//新增标签
	public CommonResult addTag(String addTagParam);
	//批量删除标签
	public CommonResult delTag(long id);
	//修改标签
	public CommonResult modifyTag(Mark mark);
	//查询全部标签
	public CommonResult queryAll();
}
