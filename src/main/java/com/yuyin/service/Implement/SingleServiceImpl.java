package com.yuyin.service.Implement;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yuyin.common.pojo.CommonResult;
import com.yuyin.common.pojo.PageResult;
import com.yuyin.common.util.IDUtils;
import com.yuyin.mapper.MusicMapper;
import com.yuyin.mapper.SingleMapper;
import com.yuyin.pojo.Music;
import com.yuyin.pojo.Single;
import com.yuyin.pojo.SingleVo;
import com.yuyin.service.SingleService;
/**
 * 单曲业务实现类
 * @Title:SingleServiceImpl
 * @author hxiaope
 * @date 2017年3月7日上午8:34:38
 * @version 1.0
 */
@Service("SingleService")
public class SingleServiceImpl implements SingleService {

	@Autowired
	private SingleMapper singleMapper;
	@Autowired
	private MusicMapper musicMapper;
	
	/* 新增单曲
	 * @param single
	/* @return
	/* @throws Exception
	 */
	@Override
	public CommonResult addSingle(SingleVo single) throws Exception {
		try{
			if(single!=null){
				single.setMusicId(IDUtils.getId());
				single.setId(IDUtils.getId());
				Music music = new Music();
				music.setId(single.getMusicId());
				music.setAlbum(single.getAlbum());
				music.setMusicimage(single.getMusicimage());
				music.setMusicpath(single.getMusicpath());
				music.setMusicname(single.getMusicname());
				music.setSinger(single.getSinger());
				musicMapper.insert(music);
				
				Music key = musicMapper.selectByPrimaryKey(single.getMusicId());
				if(key!=null){
					Single sig =new Single();
					sig.setId(single.getId());
					sig.setMusicId(single.getMusicId());
					sig.setSinglecontent(single.getSinglecontent());
					sig.setSingleauthor(single.getSingleauthor());
					sig.setCreatetime(single.getCreatetime());
					sig.setSingleimage(single.getSingleimage());
					singleMapper.insert(sig);
					return CommonResult.build(200, "插入成功");
				}
				return CommonResult.build(400, "插入错误");
			}else{
				return CommonResult.build(400, "插入错误");
			}
		}
		catch(Exception e){
			throw e;
		}
	}

	/*
	 * @param single
	/* @return
	/* @throws Exception
	 */
	@Override
	public CommonResult modifySingle(SingleVo vo) throws Exception {
		try{
			Single single = new Single();
			single.setId(vo.getId());
			single.setMusicId(vo.getMusicId());
			single.setSingleauthor(vo.getSingleauthor());
			single.setSinglecontent(vo.getSinglecontent());
			single.setSingleimage(vo.getSingleimage());
			single.setCreatetime(vo.getCreatetime());
			singleMapper.updateByPrimaryKey(single);
			
			Music record= new Music();
			record.setId(vo.getMusicId());
			record.setAlbum(vo.getAlbum());
			record.setMusicimage(vo.getMusicimage());
			record.setMusicname(vo.getMusicname());
			record.setMusicpath(vo.getMusicpath());
			record.setMusictime(vo.getMusictime());
			record.setSinger(vo.getSinger());
			musicMapper.updateByPrimaryKey(record);
			return CommonResult.build(200, "修改成功");
		}catch(Exception e){
			throw e;
		}
	}
	/*
	 * @param ids
	/* @return
	/* @throws Exception
	 */
	@Override
	public CommonResult delSingle(Long[] ids) throws Exception {
		try{
			singleMapper.deleteSingleByIds(ids);
			return CommonResult.build(400, "删除成功");
		}catch(Exception e){
			throw e;
		}
	}
	/* 分页查询单曲
	 * @param musicname
	/* @param pageNum
	/* @param pageRow
	/* @return
	/* @throws Exception
	 */
	@Override
	public PageResult querySingleList(String musicname, int pageNum, int pageRow) throws Exception {
		SingleVo vo = new SingleVo();
		if(StringUtils.isNoneBlank(musicname)){
			vo.setMusicname(musicname);
		}
		PageHelper.startPage(pageNum,pageRow);
		List<SingleVo> list = singleMapper.queryList(vo);
		PageResult result = new PageResult();
		PageInfo<SingleVo> pageInfo =new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());//总记录数
		result.setRows(list);
		result.setPageSize(pageInfo.getPages());//总页数
		result.setPageNum(pageInfo.getPageNum());
		return result;
	}

}
