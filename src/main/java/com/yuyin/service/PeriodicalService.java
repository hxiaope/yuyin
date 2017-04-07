package com.yuyin.service;

import java.util.List;

import com.yuyin.common.pojo.CommonResult;
import com.yuyin.common.pojo.PageResult;
import com.yuyin.pojo.Periodical;
import com.yuyin.pojo.PeriodicalCustom;

/**
 * 期刊接口
 * @Title:PeriodicalService
 * @author hxiaope
 * @date 2017年3月15日下午3:32:28
 * @version 1.0
 */
public interface PeriodicalService {
	//新增期刊
	public CommonResult insertPeriodical(Periodical periodical)throws Exception;
	//删除、批量删除
	public CommonResult delPeriodical(Long[] ids)throws Exception;
	//分页查询期刊
	public PageResult queryPeriodicalList(String title,int pageNum,int pageRow)throws Exception;
	//单表分页查询期刊
	public PageResult queryPerOneTable(int pageNum,int pageRow)throws Exception;
	// 根据ID连表查询
	public PeriodicalCustom queryPeriodicalId(Long id)throws Exception;
}
