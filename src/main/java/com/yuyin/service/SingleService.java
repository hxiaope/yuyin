package com.yuyin.service;

import com.yuyin.common.pojo.CommonResult;
import com.yuyin.common.pojo.PageResult;
import com.yuyin.pojo.Single;
import com.yuyin.pojo.SingleVo;

/**
 * 单曲业务接口
 * @Title:SingleService
 * @author hxiaope
 * @date 2017年3月7日上午8:24:27
 * @version 1.0
 */
public interface SingleService {

	/* 新增
	 * @param single
	/* @return
	/* @throws Exception
	 */
	public CommonResult addSingle(SingleVo vo) throws Exception;
	/* 单曲列表分页条件查询
	 * @param single
	/* @return
	/* @throws Exception
	 */
	public PageResult querySingleList(String musicname,int pageNum,int pageRow)throws Exception;
	/* 修改单曲
	 * @param id
	/* @param single
	/* @return
	/* @throws Exception
	 */
	public CommonResult modifySingle(SingleVo vo) throws Exception;
	/* 删除单曲
	 * @param id
	/* @return
	/* @throws Exception
	 */
	public CommonResult delSingle(Long[] ids) throws Exception;
}
