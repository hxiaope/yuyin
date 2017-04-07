package com.yuyin.service;

import com.yuyin.common.pojo.CommonResult;
import com.yuyin.common.pojo.PageResult;
import com.yuyin.pojo.EssayVo;

/**
 * 
 * @Title:EssayService
 * @author hxiaope
 * @date 2017年3月12日下午9:42:32
 * @version 1.0
 */
public interface EssayService {
	//新增专栏
	public CommonResult addEssay(EssayVo vo) throws Exception;
	//专栏查询
	public PageResult queryEssay(String title,int pageNum,int pageRow)throws Exception;
	//删除/批量删除
	public CommonResult delEssay(Long[] ids)throws Exception;
	//更新文章
	public CommonResult updateEssay(EssayVo vo)throws Exception;
	//根据id查询
	public CommonResult queryById(Long id) throws Exception;
}
