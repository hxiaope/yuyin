package com.yuyin.service;

import java.util.List;

import com.yuyin.common.pojo.CommonResult;
import com.yuyin.pojo.Music;

/**
 * 音乐类接口
 * @Title:MusicService
 * @author hxiaope
 * @date 2017年3月15日上午9:29:24
 * @version 1.0
 */
public interface MusicService {
	// 新增
	public CommonResult insertMusic(Music music)throws Exception;
	// 删除
	public CommonResult delMusic(List<Music> music) throws Exception;
}
