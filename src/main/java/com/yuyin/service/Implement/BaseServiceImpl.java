package com.yuyin.service.Implement;

import com.yuyin.common.pojo.CommonResult;
import com.yuyin.common.util.IDUtils;
import com.yuyin.mapper.UserMapper;
import com.yuyin.pojo.User;
import com.yuyin.pojo.UserExample;
import com.yuyin.service.BaseService;
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

	@Override
	public CommonResult addcollect(Long userId, Long pId, Long eId, Long sId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommonResult addcomment(Long userId, Long pId, Long eId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommonResult findPeriodicalCollect(Long userId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommonResult findEssayCollect(Long userId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommonResult findSingelCollect(Long userId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommonResult findEssayComment(Long userId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommonResult findPeriodicalComment(Long userId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
