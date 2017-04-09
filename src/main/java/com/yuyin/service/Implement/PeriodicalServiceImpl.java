package com.yuyin.service.Implement;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yuyin.common.pojo.CommonResult;
import com.yuyin.common.pojo.PageResult;
import com.yuyin.mapper.PeriodicalMapper;
import com.yuyin.pojo.Periodical;
import com.yuyin.pojo.PeriodicalCustom;
import com.yuyin.pojo.PeriodicalExample;
import com.yuyin.service.PeriodicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * 期刊业务实现类
 * @Title:PeriodicalServiceImpl
 * @author hxiaope
 * @date 2017年3月15日下午3:34:19
 * @version 1.0
 */
@Service("PeriodicalService")
public class PeriodicalServiceImpl implements PeriodicalService {

	@Autowired
	private PeriodicalMapper periodicalMapper;
	
	/* 新增期刊
	 * @param periodical
	/* @return
	/* @throws Exception
	 */
	@Override
	public CommonResult insertPeriodical(Periodical periodical) throws Exception {
		try{
			Periodical record = new Periodical();
			PeriodicalExample record1=new PeriodicalExample();
			//record.setId(IDUtils.getId());
			record.setTitle(periodical.getTitle());
			record.setImagepath(periodical.getImagepath());
			record.setTag(periodical.getTag());
			record.setCreatetime(periodical.getCreatetime());
			record.setAuthor(periodical.getAuthor());
			record.setContent(periodical.getContent());
			periodicalMapper.insert(record);
			record1.createCriteria().andTitleEqualTo(record.getTitle());
			List<Periodical> list = periodicalMapper.selectByExample(record1);
			if (list.size()==0){
				return CommonResult.build(404, "error");
			}
			return CommonResult.build(400, "success", list.get(0).getId());
		}catch(Exception e){
			return CommonResult.build(200, "Exception");
		}
	}
	/* 删除、批量删除
	 * @param ids
	/* @return
	/* @throws Exception
	 */
	@Override
	public CommonResult delPeriodical(Long[] ids) throws Exception {
		try{
			periodicalMapper.deletePeriodical(ids);
			return CommonResult.build(400, "success");
		}catch(Exception e){
			return CommonResult.build(200, "Exception");
		}
	}
	@Override
	public PageResult queryPeriodicalList(String title, int pageNum, int pageRow) throws Exception {
		try{
			Periodical record = new Periodical();
			PageResult result = new PageResult();
			record.setTitle(title);
			PageHelper.startPage(pageNum, pageRow);
			List<PeriodicalCustom> list = periodicalMapper.queryPeriodicalList(record);
			PageInfo<PeriodicalCustom> pageInfo = new PageInfo<>(list);
			result.setTotal(pageInfo.getTotal());
			result.setRows(list);
			result.setPageSize(pageInfo.getPages());
			result.setPageNum(pageInfo.getPageNum());
			return result;
		}catch(Exception e){
			throw e;
		}
	}
	@Override
	public PageResult queryPerOneTable(int pageNum, int pageRow) throws Exception {
		try{
			PageResult result = new PageResult();
			PageHelper.startPage(pageNum, pageRow);
			List<PeriodicalCustom> list = periodicalMapper.queryPerOneTable();
			PageInfo<PeriodicalCustom> pageInfo = new PageInfo<>(list);
			result.setTotal(pageInfo.getTotal());
			result.setRows(list);
			result.setPageSize(pageInfo.getPages());
			result.setPageNum(pageInfo.getPageNum());
			return result;
		}catch(Exception e){
			throw e;
		}
	}
	@Override
	public PeriodicalCustom queryPeriodicalId(Long id) throws Exception {
		PeriodicalCustom pc = periodicalMapper.queryPeriodicalID(id);
		return pc;
	}

}
