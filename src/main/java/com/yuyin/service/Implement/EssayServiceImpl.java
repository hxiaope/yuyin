package com.yuyin.service.Implement;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yuyin.common.pojo.CommonResult;
import com.yuyin.common.pojo.PageResult;
import com.yuyin.common.util.IDUtils;
import com.yuyin.mapper.EssaysMapper;
import com.yuyin.mapper.MusicMapper;
import com.yuyin.pojo.EssayVo;
import com.yuyin.pojo.Essays;
import com.yuyin.pojo.Music;
import com.yuyin.service.EssayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("EssayService")
public class EssayServiceImpl implements EssayService{

	@Autowired
	private EssaysMapper essaysMapper;
	@Autowired
	private MusicMapper musicMapper;
	
	/* 新增专栏
	 * @param essay
	/* @return
	/* @throws Exception
	 */
	public CommonResult addEssay(EssayVo essay) throws Exception {
		try{
			if(essay!=null){
				essay.setMusicId(IDUtils.getId());
				//essay.setId(IDUtils.getId());
				Music music = new Music();
				music.setId(essay.getMusicId());
				music.setAlbum(essay.getAlbum());
				music.setMusicimage(essay.getMusicimage());
				music.setMusicpath(essay.getMusicpath());
				music.setMusicname(essay.getMusicname());
				music.setSinger(essay.getSinger());
				musicMapper.insert(music);
				
				Music key = musicMapper.selectByPrimaryKey(essay.getMusicId());
				
				if(key!=null){
					Essays es =new Essays();
					es.setId(essay.getId());
					es.setTitle(essay.getTitle());
					es.setMusicId(essay.getMusicId());
					es.setImagepath(essay.getImagepath());
					es.setCreatetime(essay.getCreatetime());
					es.setContent(essay.getContent());
					es.setSubscribe(essay.getSubscribe());
					es.setAuthor(essay.getAuthor());
					essaysMapper.insert(es);
					return CommonResult.build(200, "插入成功");
				}
				return CommonResult.build(400, "插入错误");
			}else{
				return CommonResult.build(400, "插入错误");
			}
		}catch(Exception e){
			throw e;
		}
	}
	/* 专栏查询
	 * @param title
	/* @param pageNum
	/* @param pageRow
	/* @return
	/* @throws Exception
	 */
	@Override
	public PageResult queryEssay(String title, int pageNum, int pageRow) throws Exception {
		try{
			EssayVo record =new EssayVo();
			PageResult result =new PageResult();
			record.setTitle(title);
			PageHelper.startPage(pageNum, pageRow);
			List<EssayVo> list = essaysMapper.queryEssayList(record);
			PageInfo<EssayVo> pageInfo =new PageInfo<>(list);
			result.setTotal(pageInfo.getTotal());
			result.setPageNum(pageInfo.getPageNum());
			result.setPageSize(pageInfo.getPages());
			result.setRows(list);
			return result;
		}catch(Exception e){
			throw e;
		}
	}
	/* 删除/批量删除
	 * @param ids
	/* @return
	/* @throws Exception
	 */
	@Override
	public CommonResult delEssay(Long[] ids) throws Exception {
		try{
			essaysMapper.deleteEssay(ids);
			return CommonResult.build(400, "操作成功");
		}catch(Exception e){
			return CommonResult.build(200, "操作异常");
		}
	}
	/* 更新文章
	 * @param vo
	/* @return
	/* @throws Exception
	 */
	@Override
	public CommonResult updateEssay(EssayVo vo) throws Exception {
		try{
			Essays es=new Essays();
			es.setId(vo.getId());
			es.setMusicId(vo.getMusicId());
			es.setAuthor(vo.getAuthor());
			es.setContent(vo.getContent());
			es.setCreatetime(vo.getCreatetime());
			es.setImagepath(vo.getImagepath());
			es.setTitle(vo.getTitle());
			essaysMapper.updateByPrimaryKey(es);
			
			Music ms=new Music();
			ms.setAlbum(vo.getAlbum());
			ms.setId(vo.getMusicId());
			ms.setMusicimage(vo.getMusicimage());
			ms.setMusicname(vo.getMusicname());
			ms.setMusicpath(vo.getMusicpath());
			ms.setMusictime(vo.getMusictime());
			ms.setSinger(vo.getSinger());
			musicMapper.updateByPrimaryKey(ms);
			
			return CommonResult.build(200, "success");
		}catch(Exception e){
			return CommonResult.build(400, "error");
		}
	}

	/**
	 * 根据id查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Override
	public CommonResult queryById(Long id) throws Exception {
		EssayVo essayVo = essaysMapper.getEssayAndMusic(id);
		return CommonResult.build(200,"suceess",essayVo);
	}

}
