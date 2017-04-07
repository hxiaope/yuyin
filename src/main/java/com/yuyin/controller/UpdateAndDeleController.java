package com.yuyin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yuyin.common.pojo.CommonResult;
import com.yuyin.pojo.EssayVo;
import com.yuyin.pojo.Mark;
import com.yuyin.pojo.Music;
import com.yuyin.pojo.SingleVo;
import com.yuyin.service.EssayService;
import com.yuyin.service.MusicService;
import com.yuyin.service.PeriodicalService;
import com.yuyin.service.SingleService;
import com.yuyin.service.TagManagerService;

/**
 * 修改和删除的Controller
 * @Title:UpdateAndDeleController
 * @author hxiaope
 * @date 2017年1月12日下午2:59:07
 * @version 1.0
 */
@Controller
public class UpdateAndDeleController {

	@Autowired
	private TagManagerService tagManagerService;
	@Autowired
	private MusicService musicService;
	@Autowired
	private SingleService singleService;
	@Autowired
	private EssayService essayService;
	@Autowired
	private PeriodicalService periodicalService;

	/* 删除标签
	 * @param id
	/* @return
	 */
	@ResponseBody
	@RequestMapping("/tag/delete")
	public CommonResult delTag(Long id){
		return tagManagerService.delTag(id);
	}
	/* 修改标签
	 * @param tag
	/* @param id
	/* @return
	 */
	@ResponseBody
	@RequestMapping("/tag/modify")
	public CommonResult updateTag(String tag,long id){
		Mark mark= new Mark();
		mark.setId(id);
		mark.setTag(tag);
		return tagManagerService.modifyTag(mark);
	}
	/*  批量删除Music
	 * @param list
	/* @return
	 */
	@ResponseBody
	@RequestMapping("/music/delete")
	public CommonResult delMusic(@RequestBody List<Music> list) throws Exception{
		CommonResult result = musicService.delMusic(list);
		return result;
	}
	/* 删除/批量删除单曲
	 * @param ids
	/* @return
	/* @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/single/delete")
	public CommonResult delSingle(@RequestBody Long[] ids)throws Exception{
		System.out.println(ids.toString());
		CommonResult result = singleService.delSingle(ids);
		return result;
	}
	/* 删除/批量删除专栏
	 * @param ids
	/* @return
	/* @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/essay/delete")
	public CommonResult delEssay(@RequestBody Long[] ids) throws Exception{
		System.out.println(ids.toString());
		CommonResult result = essayService.delEssay(ids);
		return result;
	}
	/* 删除/批量删除期刊
	 * @param ids
	/* @return
	/* @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/periodical/delete")
	public CommonResult delPeriodical(@RequestBody Long[] ids) throws Exception{
		System.out.println(ids.toString());
		CommonResult result = periodicalService.delPeriodical(ids);
		return result;
	}
	/* 单曲更新
	 * @param vo
	/* @return
	/* @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/single/update")
	public CommonResult updateSingle(SingleVo vo) throws Exception{
		System.out.println(vo.toString());
		CommonResult result = singleService.modifySingle(vo);
		return result;
	}
	/* 文章更新
	 * @param vo
	/* @return
	/* @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/essay/update")
	public CommonResult updateEssay(EssayVo vo) throws Exception{
		System.out.println(vo.toString());
		CommonResult result = essayService.updateEssay(vo);
		return result;
	}
}
