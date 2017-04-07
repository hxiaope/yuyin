package com.yuyin.service.Implement;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yuyin.common.pojo.CommonResult;
import com.yuyin.common.pojo.PageResult;
import com.yuyin.mapper.MarkMapper;
import com.yuyin.pojo.Mark;
import com.yuyin.pojo.MarkExample;
import com.yuyin.service.TagManagerService;
/**
 * 
 * @Title:TagManagerServiceImpl
 * @author hxiaope
 * @date 2017年2月26日下午7:44:55
 * @version 1.0
 */
@Service("TagManagerService")
public class TagManagerServiceImpl implements TagManagerService {

	@Autowired
	private MarkMapper markMapper;
	
	/* 查询标签列表
	 * @param page
	/* @param rows
	/* @param tagParam
	/* @return
	 */
	@Override
	public PageResult findTagList(int page, int rows, String tagParam) {
		MarkExample example = new MarkExample();
		if(StringUtils.isNotBlank(tagParam)){
			tagParam="%"+tagParam+"%";
			example.createCriteria().andTagLike(tagParam);
		}
		PageHelper.startPage(page, rows);
		List<Mark> list = markMapper.selectByExample(example);
		PageResult result = new PageResult();
		result.setRows(list);
		PageInfo<Mark> pageInfo =new PageInfo<>(list);
		result.setPageSize(pageInfo.getPages());
		result.setPageNum(pageInfo.getPageNum());
		result.setTotal(pageInfo.getTotal());
		result.setOffset(pageInfo.getStartRow());
		result.setEndOffset(pageInfo.getEndRow());
		result.setPageRow(pageInfo.getPageSize());
		return result;
	}

	/* 新增标签
	 * @param addTagParam
	/* @return
	 */
	@Override
	public CommonResult addTag(String addTagParam) {
		try{
		Mark mark = new Mark();
		mark.setTag(addTagParam);
		markMapper.insert(mark);
		}catch(Exception e){
			throw e;
		}
		return CommonResult.build(01, "新增成功");
	}

	@Override
	public CommonResult delTag(long id) {
		try{
			markMapper.deleteByPrimaryKey(id);
		}catch(Exception e){
			throw e;
		}
		return CommonResult.build(01, "删除成功");
	}

	@Override
	public CommonResult modifyTag(Mark mark) {
		try{
			markMapper.updateByPrimaryKey(mark);
		}catch(Exception e){
			throw e;
		}
		return CommonResult.build(01, "修改成功");
	}

	@Override
	public CommonResult queryAll() {
		try{
			List<Mark> list = markMapper.queryAll();
			return CommonResult.build(400, "success", list);
		}catch(Exception e) {
			throw e;
		}
	}

}
