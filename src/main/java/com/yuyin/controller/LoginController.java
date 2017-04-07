package com.yuyin.controller;

import com.yuyin.common.util.CookieUtils;
import com.yuyin.pojo.User;
import com.yuyin.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
public class LoginController {

	@Autowired
	private BaseService baseService;
	
	/* 用户登录逻辑
	 * @param email
	/* @param password
	/* @return 200账户不存在 201密码错误 400登录成功保存Session and Cookies
	/* @throws Exception
	 */
	@RequestMapping("/login")
	@ResponseBody
	public String login(String email,String password,HttpSession session,HttpServletRequest request,HttpServletResponse response) throws Exception{
		List<User> list = baseService.findByEmail(email);
		if(list.size()==0){
			return "404";//用户不存在
		}
		if(list.get(0).getPassword().equals(password)){
			session.setAttribute("id", list.get(0).getId());
			session.setAttribute("email", list.get(0).getEmail());
			CookieUtils.setCookie(request, response, "userId", list.get(0).getId().toString());
			CookieUtils.setCookie(request, response, "userName", list.get(0).getNickname());
			CookieUtils.setCookie(request, response, "headImage", list.get(0).getHeadimage());
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
	@RequestMapping("/loginAdmin")
	@ResponseBody
	public String Adminlogin(String email,String password,HttpSession session,HttpServletRequest request,HttpServletResponse response) throws Exception{
		List<User> list = baseService.findByEmail(email);
		if(list.size()==0){
			return "404";//用户不存在
		}
			if (list.get(0).getPassword().equals(password)&&list.get(0).getRole()==1) {
				session.setAttribute("id", list.get(0).getId());
				session.setAttribute("email", list.get(0).getEmail());
				CookieUtils.setCookie(request, response, "userId", list.get(0).getId().toString());
				CookieUtils.setCookie(request, response, "userName", list.get(0).getNickname());
				CookieUtils.setCookie(request, response, "headImage", list.get(0).getHeadimage());
				return "200";//成功登录
			} else {
				return "400";//密码错误
			}
	}
	/**
	 * 登出功能
	 * @param session
	 * @return
	 */
	@RequestMapping("/logout")
	public String Logout(HttpSession session){
		session.invalidate();
		return "login";
	}
}
