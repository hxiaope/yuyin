package com.yuyin.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yuyin.common.pojo.CommonResult;
import com.yuyin.common.util.JsonUtils;
import com.yuyin.pojo.EssayVo;
import com.yuyin.pojo.Music;
import com.yuyin.pojo.Periodical;
import com.yuyin.pojo.SingleVo;
import com.yuyin.service.EssayService;
import com.yuyin.service.MusicService;
import com.yuyin.service.PeriodicalMusicService;
import com.yuyin.service.PeriodicalService;
import com.yuyin.service.SingleService;
import com.yuyin.service.TagManagerService;

/**
 * 用于新增的Controller
 * @Title:InsertController
 * @author hxiaope
 * @date 2017年1月12日下午2:58:02
 * @version 1.0
 */
@Controller
public class InsertController {

	@Autowired
	private TagManagerService tagManagerService;
	@Autowired
	private SingleService singleService;
	@Autowired
	private EssayService essayService;
	@Autowired
	private MusicService musicService;
	@Autowired
	private PeriodicalService periodicalService;
	@Autowired
	private PeriodicalMusicService periodicalMusicService;
	
	
	/*插入标签
	 * @param param
	/* @return
	 */
	@ResponseBody
	@RequestMapping("/tag/insert")
	public CommonResult addTag(String param) {
		return tagManagerService.addTag(param);
	}
	/* 插入单曲
	 * @param vo
	/* @return
	/* @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/single/insert")
	public CommonResult addSingle(SingleVo vo)throws Exception{
		CommonResult result = singleService.addSingle(vo);
		return result;
	}
	/* 新增专栏
	 * @param vo
	/* @return
	/* @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/essay/insert")
	public CommonResult addEssay(EssayVo vo)throws Exception{
		CommonResult result = essayService.addEssay(vo);
		return result;
	}
	/* 增加音乐
	 * @param music
	/* @return
	/* @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/music/insert")
	public CommonResult addMusic(Music music)throws Exception{
		CommonResult result = musicService.insertMusic(music);
		return result;
	}
	/* 新增期刊
	 * @param periodical
	/* @param list
	/* @return
	/* @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/periodical/insert")
	public CommonResult addPeriodical(String periodical,String list)throws Exception{
		try{
		if(StringUtils.isNotBlank(periodical)&&StringUtils.isNotBlank(list)){
		System.out.println(periodical);
		Periodical periodical2 = JsonUtils.jsonToPojo(periodical, Periodical.class);
		System.out.println(periodical2.toString());
		List<Music> list2 = JsonUtils.jsonToList(list, Music.class);
		System.out.println(list2);
		if(periodical2!=null && list2.size()>0){
			//先插入期刊返回主键
			CommonResult result = periodicalService.insertPeriodical(periodical2);
			//插入中间表2个参数 result.data-list
			Long periodicalId=(Long) result.getData();
			periodicalMusicService.inserPeriodicalMusic(periodicalId, list2);
			return CommonResult.build(400, "success");
		}else{
			return CommonResult.build(200, "error");
		}
		}
		else
			return CommonResult.build(200, "error");
		}catch(Exception e){
			return CommonResult.build(200, "error");
		}
	}
}
