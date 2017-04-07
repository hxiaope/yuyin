package com.yuyin.service.Implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuyin.mapper.PeriodicalMusicMapper;
import com.yuyin.pojo.Music;
import com.yuyin.pojo.PeriodicalMusic;
import com.yuyin.service.PeriodicalMusicService;
/**
 * 期刊音乐中间表业务实现类
 * @Title:PeriodicalMusicServiceImpl
 * @author hxiaope
 * @date 2017年3月15日下午3:50:28
 * @version 1.0
 */
@Service("PeriodicalMusicService")
public class PeriodicalMusicServiceImpl implements PeriodicalMusicService {

	@Autowired
	private PeriodicalMusicMapper periodicalMusicMapper;
	
	/* 新增期刊-音乐中间表
	 * @param periodicalId
	/* @param list
	/* @throws Exception
	 */
	@Override
	public void inserPeriodicalMusic(Long periodicalId, List<Music> list) throws Exception {
		try{
			PeriodicalMusic pm=new PeriodicalMusic();
			for(Music m :list){
				pm.setPeriodicalId(periodicalId);
				pm.setMusicId(m.getId());
				periodicalMusicMapper.insert(pm);
			}
		}catch(Exception e){
			throw e;
		}
	}
}
