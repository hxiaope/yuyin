package com.yuyin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yuyin.common.pojo.CommonResult;
import com.yuyin.common.pojo.PageResult;
import com.yuyin.pojo.PeriodicalCustom;
import com.yuyin.service.EssayService;
import com.yuyin.service.PeriodicalService;
import com.yuyin.service.SingleService;
import com.yuyin.service.TagManagerService;
/**
 * 用于查询的各种Controller
 * @Title:QueryController
 * @author hxiaope
 * @date 2017年1月12日下午2:57:02
 * @version 1.0
 */
@Controller
public class QueryController {

	@Autowired
	private TagManagerService tagManagerService;
	@Autowired
	private SingleService singleService;
	@Autowired
	private EssayService essayService;
	@Autowired
	private PeriodicalService periodicalService;
	
	/* 分页标签查询
	 * @param tagParam
	/* @param pageNum
	/* @param pageRow
	/* @return
	 */
	@ResponseBody
	@RequestMapping(value="/tagManager/query",method={RequestMethod.POST})
	public PageResult findTagList(String tagParam,@RequestParam(defaultValue="1")int pageNum,@RequestParam(defaultValue="10")int pageRow){
		PageResult result = tagManagerService.findTagList(pageNum, pageRow, tagParam);
		return result;
	}
	
	/* 查询全部标签
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/tagManager/queryAll",method={RequestMethod.POST})
	public CommonResult findTagAll(){
		CommonResult commonResult = tagManagerService.queryAll();
		return commonResult;
	}
	/* 用于后台单曲分页查询
	 * @param musicname
	/* @param pageNum
	/* @param pageRow
	/* @return
	/* @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/single/query",method={RequestMethod.POST})
	public PageResult querySingle(String musicname,@RequestParam(defaultValue="1")int pageNum,@RequestParam(defaultValue="10")int pageRow) throws Exception{
		PageResult list = singleService.querySingleList(musicname, pageNum, pageRow);
		return list;
	}
	/* 用于前台单曲数据展示
	 * @param pageNum
	/* @param pageRow
	/* @return
	/* @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/single",method={RequestMethod.POST})
	public PageResult querySingleShow(@RequestParam(defaultValue="1")int pageNum,@RequestParam(defaultValue="10")int pageRow) throws Exception{
		PageResult list = singleService.querySingleList(null, pageNum, pageRow);
		return list;
	}
	/* 分页查询专栏
	 * @param title
	/* @param pageNum
	/* @param pageRow
	/* @return
	/* @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/essay/query",method={RequestMethod.POST})
	public PageResult queryEssay(String title,@RequestParam(defaultValue="1")int pageNum,@RequestParam(defaultValue="10")int pageRow) throws Exception{
		PageResult result = essayService.queryEssay(title, pageNum, pageRow);
		return result;
	}
	/* 用于前台展示专栏
	 * @param pageNum
	/* @param pageRow
	/* @return
	/* @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/essay",method={RequestMethod.POST})
	public PageResult queryEssayShow(@RequestParam(defaultValue="1")int pageNum,@RequestParam(defaultValue="10")int pageRow) throws Exception{
		PageResult result = essayService.queryEssay(null, pageNum, pageRow);
		return result;
	}

	/**
	 * 前台文章详细页展示
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/essay/{id}",method={RequestMethod.POST})
	public CommonResult queryEssayDetail(@PathVariable Long id) throws Exception{
		CommonResult result = essayService.queryById(id);
		return result;
	}
	/* 用于后台分页查询期刊
	 * @param title
	/* @param pageNum
	/* @param pageRow
	/* @return
	/* @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/periodical/query",method={RequestMethod.POST})
	public PageResult queryPeriodical(String title,@RequestParam(defaultValue="1")int pageNum,@RequestParam(defaultValue="10")int pageRow)throws Exception{
		PageResult list = periodicalService.queryPeriodicalList(title, pageNum, pageRow);
		return list;
	}
	/* 用于前台展示
	 * @param pageNum
	/* @param pageRow
	/* @return
	/* @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/periodical",method={RequestMethod.POST})
	public PageResult queryPeriodicalShow(@RequestParam(defaultValue="1")int pageNum,@RequestParam(defaultValue="10")int pageRow)throws Exception{
		PageResult list = periodicalService.queryPerOneTable(pageNum, pageRow);
		return list;
	}
	@ResponseBody
	@RequestMapping(value="/periodical/{id}",method={RequestMethod.POST})
	public CommonResult queryPeriodicalId(@PathVariable Long id)throws Exception{
		if(id!=null){
			PeriodicalCustom custom = periodicalService.queryPeriodicalId(id);
			return CommonResult.build(200, "success", custom);
		}else{
			return CommonResult.build(400, "error");
		}
	}
}
