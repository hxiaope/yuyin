package com.yuyin.service;

import com.yuyin.common.pojo.CommonResult;
import com.yuyin.pojo.User;

import java.util.List;

/**
 * 基本业务接口
 * @Title:LoginService
 * @author hxiaope
 * @date 2017年1月12日下午2:32:53
 * @version 1.0
 */
public interface BaseService {
	//验证用户登录
	public List<User> findByEmail(String email) throws Exception;

	/**注册
	 * @param email
	 * @param password
	 * @param nickname
	 * @return
	 * @throws Exception
	 */
	public User insertUser(String email,String password,String nickname) throws Exception;
	//用户收藏
	public CommonResult addcollect(Long userId,Long pId,Long eId,Long sId) throws Exception;
	//用户评论
	public CommonResult addcomment(String userInfo,Long pId,Long eId,String content) throws Exception;
	//查找期刊收藏
	public CommonResult findPeriodicalCollect(Long userId) throws Exception;
	//查找期刊收藏
	public CommonResult findEssayCollect(Long userId) throws Exception;
	//查找期刊收藏
	public CommonResult findSingelCollect(Long userId) throws Exception;
	//查找文章评论
	public CommonResult findEssayComment(Long eId) throws Exception;
	//查找期刊评论
	public CommonResult findPeriodicalComment(Long pId) throws Exception;
}
