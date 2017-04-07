package com.yuyin.service;

import java.util.List;

import com.yuyin.pojo.Music;

/**
 * 期刊音乐中间表接口
 * @Title:PeriodicalMusicService
 * @author hxiaope
 * @date 2017年3月15日下午3:47:28
 * @version 1.0
 */
public interface PeriodicalMusicService {

	/* 新增
	 * @param periodicalId
	/* @param music
	/* @throws Exception
	 */
	public void inserPeriodicalMusic(Long periodicalId,List<Music> music)throws Exception;
}
