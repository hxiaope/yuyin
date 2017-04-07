package com.yuyin.service.Implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuyin.common.pojo.CommonResult;
import com.yuyin.common.util.IDUtils;
import com.yuyin.mapper.MusicMapper;
import com.yuyin.pojo.Music;
import com.yuyin.service.MusicService;
/**
 * 歌曲业务实现类
 * @Title:MusicServiceImpl
 * @author hxiaope
 * @date 2017年3月15日上午9:31:12
 * @version 1.0
 */
@Service("MusicService")
public class MusicServiceImpl implements MusicService {

	@Autowired
	private MusicMapper musicMapper;
	@Override
	public CommonResult insertMusic(Music music) throws Exception {
		try{
		Music record = new Music();
		record.setId(IDUtils.getId());
		record.setMusicname(music.getMusicname());
		record.setSinger(music.getSinger());
		record.setMusicimage(music.getMusicimage());
		record.setMusicpath(music.getMusicpath());
		musicMapper.insert(record);
		
		return CommonResult.build(400, "success", record);
		}catch(Exception e){
			return CommonResult.build(200, "error");
		}
	}
	@Override
	public CommonResult delMusic(List<Music> list) throws Exception {
		try{
		for(Music music : list){
			musicMapper.deleteByPrimaryKey(music.getId());
		}
		return CommonResult.build(400, "success");
		}catch(Exception e){
			return CommonResult.build(200, "error");
		}
	}

}
