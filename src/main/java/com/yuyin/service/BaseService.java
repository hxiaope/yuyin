package com.yuyin.service;

import java.util.List;

import com.yuyin.common.pojo.CommonResult;
import com.yuyin.pojo.User;

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
	//用户收藏
	public CommonResult addcollect(Long userId,Long pId,Long eId,Long sId) throws Exception;
	//用户评论
	public CommonResult addcomment(Long userId,Long pId,Long eId) throws Exception;
	//查找期刊收藏
	public CommonResult findPeriodicalCollect(Long userId) throws Exception;
	//查找期刊收藏
	public CommonResult findEssayCollect(Long userId) throws Exception;
	//查找期刊收藏
	public CommonResult findSingelCollect(Long userId) throws Exception;
	//查找文章评论
	public CommonResult findEssayComment(Long userId) throws Exception;
	//查找期刊评论
	public CommonResult findPeriodicalComment(Long userId) throws Exception;
}
