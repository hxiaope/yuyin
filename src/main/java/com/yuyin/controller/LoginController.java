package com.yuyin.controller;

import com.yuyin.common.util.CookieUtils;
import com.yuyin.common.util.MD5Utils;
import com.yuyin.pojo.User;
import com.yuyin.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 登录操作的Controller
 * @Title:LoginController
 * @author hxiaope
 * @date 2017年1月12日上午10:41:28
 * @version 1.0
 */
@Controller
public class LoginController{

	@Autowired
	private BaseService baseService;
	
	/* 用户登录逻辑
	 * @param email
	/* @param password
	/* @return 200账户不存在 201密码错误 400登录成功保存Session and Cookies
	/* @throws Exception
	 */
	@RequestMapping(value = "/login",method={RequestMethod.POST})
	@ResponseBody
	public String login(String email,String password,HttpSession session,HttpServletRequest request,HttpServletResponse response) throws Exception{
		List<User> list = baseService.findByEmail(email);
		if(list.size()==0){
			return "404";//用户不存在
		}
		String ps= MD5Utils.getMD5(password);
		if(list.get(0).getPassword().equals(ps)){
			session.setAttribute("id", list.get(0).getId());
			session.setAttribute("email", list.get(0).getEmail());
			CookieUtils.setCookie(request, response, "userId", list.get(0).getId().toString(),-1,true);
			CookieUtils.setCookie(request, response, "userName", list.get(0).getNickname(),-1,true);
			CookieUtils.setCookie(request, response, "headImage", list.get(0).getHeadimage(),-1,true);
			return "200";//成功登录
		}
		else{
			return "400";//密码错误
		}
		//return "200";
	}
	/**
	 * 管理员登录逻辑
	 * @param email
	 * @param password
	 * @param session
	 * @param request
	 * @param response
	 * @return 404账户不存在 400密码或身份错误 200登录成功保存Session and Cookies
	 * @throws Exception
	 */
	@RequestMapping(value = "/loginAdmin",method={RequestMethod.POST})
	@ResponseBody
	public String Adminlogin(String email,String password,HttpSession session,HttpServletRequest request,HttpServletResponse response) throws Exception{
		List<User> list = baseService.findByEmail(email);
		if(list.size()==0){
			return "404";//用户不存在
		}
		String ps= MD5Utils.getMD5(password);
		if (list.get(0).getPassword().equals(ps)&&list.get(0).getRole()==1) {
			session.setAttribute("id", list.get(0).getId());
			session.setAttribute("email", list.get(0).getEmail());
			CookieUtils.setCookie(request, response, "userId", list.get(0).getId().toString(),-1,true);
			CookieUtils.setCookie(request, response, "userName", list.get(0).getNickname(),-1,true);
			CookieUtils.setCookie(request, response, "headImage", list.get(0).getHeadimage(),-1,true);
			return "200";//成功登录
		} else {
			return "400";//密码错误
		}
	}

	/**
	 * 注册返回首页
	 * @param email
	 * @param password
	 * @param nickname
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/register",method={RequestMethod.POST})
	@ResponseBody
	public String SignUp(String email,String password,String nickname,HttpSession session,HttpServletRequest request,HttpServletResponse response) throws Exception{
		String ps= MD5Utils.getMD5(password);
		User result = baseService.insertUser(email, ps, nickname);
		if(result!=null){
			session.setAttribute("id", result.getId());
			session.setAttribute("email", result.getEmail());
			CookieUtils.setCookie(request, response, "userId",result.getId().toString(),-1,true);
			CookieUtils.setCookie(request, response, "userName", result.getNickname(),-1,true);
			CookieUtils.setCookie(request, response, "headImage", result.getHeadimage(),-1,true);
			return "200";
		}
		return "400";
	}
	/**
	 * 登出功能清除session和Cookies
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/logout")
	public String Logout(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		session.invalidate();
		CookieUtils.setCookie(request, response, "userId", null,-1,true);
		CookieUtils.setCookie(request, response, "userName", null,-1,true);
		CookieUtils.setCookie(request, response, "headImage", null,-1,true);
		return  "200";
	}
}
