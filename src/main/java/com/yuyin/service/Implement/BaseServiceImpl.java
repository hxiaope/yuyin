package com.yuyin.service.Implement;

import com.yuyin.common.pojo.CommonResult;
import com.yuyin.common.util.IDUtils;
import com.yuyin.mapper.CollectMapper;
import com.yuyin.mapper.CommentMapper;
import com.yuyin.mapper.UserMapper;
import com.yuyin.pojo.*;
import com.yuyin.service.BaseService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
/**
 * 基本业务的实现类
 * @Title:LoginServiceImpl
 * @author hxiaope
 * @date 2017年1月12日下午2:36:52
 * @version 1.0
 */
@Service("BaseService")
public class BaseServiceImpl implements BaseService {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private CollectMapper collectMapper;
	@Autowired
	private CommentMapper commentMapper;
	
	/* 用于用户登录根据Email查找一条记录
	 * @param email
	/* @param password
	/* @return
	/* @throws Exception
	 */
	@Override
	public List<User> findByEmail(String email) throws Exception {
		UserExample example = new UserExample();
		example.createCriteria().andEmailEqualTo(email);
		List<User> list = userMapper.selectByExample(example);
		return list;
	}

	/**
	 * @param email
	 * @param password
	 * @param nickname
	 * @return
	 * @throws Exception
	 */
	@Override
	public User insertUser(String email,String password,String nickname) throws Exception {
		UserExample example = new UserExample();
		example.createCriteria().andEmailEqualTo(email);
		List<User> list = userMapper.selectByExample(example);
		if(list.size()>0){
			return null;
		}
		try {
			User user = new User();
			user.setId(IDUtils.getId());
			user.setEmail(email);
			user.setNickname(nickname);
			user.setPassword(password);
			user.setHeadimage("http://192.168.2.129/images/headImage.jpg");
			user.setRole(2l);
			String data=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			user.setCreatedate(data);
			userMapper.insert(user);
			return user;
		}catch (Exception e){
			throw e;
		}
	}

	/**用户收藏
	 * @param userId
	 * @param pId
	 * @param eId
	 * @param sId
	 * @return
	 * @throws Exception
	 */
	@Override
	public CommonResult addcollect(Long userId, Long pId, Long eId, Long sId) throws Exception {
		try{
			if(userId!=null){
				if(pId!=null){
					Collect collect1 = collectMapper.selectByPeriodicalId(userId, pId);
					if(collect1!=null){
						return CommonResult.build(401,"exists");
					}
					Collect collect=new Collect();
					collect.setUserId(userId);
					collect.setPeriodicalId(pId);
					collectMapper.insert(collect);
					return CommonResult.build(200,"success");
				}else if(sId!=null){
					Collect collect2 = collectMapper.selectBySingleId(userId, sId);
					if(collect2!=null){
						return CommonResult.build(401,"exists");
					}
					Collect collect=new Collect();
					collect.setUserId(userId);
					collect.setSingleId(sId);
					collectMapper.insert(collect);
					return CommonResult.build(200,"success");
				}else if(eId!=null){
					Collect collect3 = collectMapper.selectByEssayId(userId, eId);
					if(collect3!=null){
						return CommonResult.build(401,"exists");
					}
					Collect collect=new Collect();
					collect.setUserId(userId);
					collect.setEssaysId(eId);
					collectMapper.insert(collect);
					return CommonResult.build(200,"success");
				}
				return CommonResult.build(400,"error");
		}
		return CommonResult.build(400,"error");
		}catch (Exception e){
			e.printStackTrace();
			return CommonResult.build(400,"Exception");
		}
	}

	@Override
	public CommonResult addcomment(String userInfo,Long pId,Long eId,String content) throws Exception {
		try{
			if(pId!=null && StringUtils.isNotBlank(content)&& StringUtils.isNotBlank(userInfo)){
				Comment comment =new Comment();
				comment.setPeriodicalId(pId);
				comment.setFormUser(userInfo);
				comment.setContent(content);
				String date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
				comment.setCreatetime(date);
				commentMapper.insert(comment);
				return CommonResult.build(200,"success");
			}else if(eId!=null&& StringUtils.isNotBlank(content)&& StringUtils.isNotBlank(userInfo)){
				Comment comment =new Comment();
				comment.setEssaysId(eId);
				comment.setFormUser(userInfo);
				comment.setContent(content);
				String date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
				comment.setCreatetime(date);
				commentMapper.insert(comment);
				return CommonResult.build(200,"success");
			}
			return CommonResult.build(400,"error");
		}catch (Exception e){
			e.printStackTrace();
			return CommonResult.build(400,"Exception");
		}
	}

	@Override
	public CommonResult findPeriodicalCollect(Long userId) throws Exception {
		try{
			List<CollectPeriodicalVo> list = collectMapper.queryPeriodicalCollect(userId);
			return CommonResult.build(200,"success",list);
		}catch (Exception e){
			e.printStackTrace();
			return CommonResult.build(400,"Exception");
		}
	}

	@Override
	public CommonResult findEssayCollect(Long userId) throws Exception {
		try{
			List<CollectEssayVo> list = collectMapper.queryEssayCollect(userId);
			return CommonResult.build(200,"success",list);
		}catch (Exception e){
			e.printStackTrace();
			return CommonResult.build(400,"Exception");
		}
	}

	@Override
	public CommonResult findSingelCollect(Long userId) throws Exception {
		try{
			List<CollectSingleVo> list = collectMapper.querySingleCollect(userId);
			return CommonResult.build(200,"success",list);
		}catch (Exception e){
			e.printStackTrace();
			return CommonResult.build(400,"Exception");
		}
	}

	@Override
	public CommonResult findEssayComment(Long eId) throws Exception {
		try{
			List<Comment> list = commentMapper.queryByEssayId(eId);
			return CommonResult.build(200,"success",list);
		}catch (Exception e){
			e.printStackTrace();
			return CommonResult.build(400,"error");
		}
	}

	@Override
	public CommonResult findPeriodicalComment(Long pId) throws Exception {
		try{
			List<Comment> list = commentMapper.queryByPeriodicalId(pId);
			return CommonResult.build(200,"success",list);
		}catch (Exception e){
			e.printStackTrace();
			return CommonResult.build(400,"error");
		}
	}
}
