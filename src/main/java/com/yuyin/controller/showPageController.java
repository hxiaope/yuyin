package com.yuyin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * 用来打开页面的集中Controller
 * @Title:showPageController
 * @author hxiaope
 * @date 2017年1月11日上午11:42:16
 * @version 1.0
 */
@Controller
public class showPageController extends BaseController{
	
	@RequestMapping("/showLogin")
	public String showPageTest(HttpServletRequest request){
		return getViewPath()+"login";
	}
	@RequestMapping("/showAdmin")
	public String showAdmin(HttpServletRequest request){
		return getViewPath()+"adminPage";
	}
	@RequestMapping("/showUserEdit")
	public String showUserEdit(HttpServletRequest request){
		return getViewPath()+"userEdit";
	}
	@RequestMapping("/showWelcome")
	public String showWelcome(HttpServletRequest request){
		return getViewPath()+"welcome";
	}
	@RequestMapping("/showQueryPeriodical")
	public String showQueryPeriodical(HttpServletRequest request){
		return getViewPath()+"queryPeriodical";
	}
	@RequestMapping("/showQuerySingle")
	public String showQuerySingle(HttpServletRequest request){
		return getViewPath()+"querySingle";
	}
	@RequestMapping("/showQueryEssay")
	public String showQueryEssay(HttpServletRequest request){
		return getViewPath()+"queryEssay";
	}
	@RequestMapping("/showAddPeriodical")
	public String showAddPeriodical(HttpServletRequest request){
		return getViewPath()+"addPeriodical";
	}
	@RequestMapping("/showAddSingle")
	public String showAddSingle(HttpServletRequest request){
		return getViewPath()+"addSingle";
	}
	@RequestMapping("/showAddEssay")
	public String showAddEssay(HttpServletRequest request){
		return getViewPath()+"addEssay";
	}
	@RequestMapping("/showTagManager")
	public String showTagManager(HttpServletRequest request){
		return getViewPath()+"tagManager";
	}
	@RequestMapping(value="/periodical",method={RequestMethod.GET})
	public String showPeriodicalList(HttpServletRequest request){
		return getViewPath()+"periodicalList";
	}
	@RequestMapping(value="/periodical/{id}",method={RequestMethod.GET})
	public String showPeriodicalDetail(HttpServletRequest request){
		return getViewPath()+"showperiodical";
	}
	@RequestMapping(value="/essay/{id}",method={RequestMethod.GET})
	public String showEssayDetail(HttpServletRequest request){
		return getViewPath()+"showEssay";
	}
	@RequestMapping(value="/essay",method={RequestMethod.GET})
	public String showEssayList(HttpServletRequest request){
		return getViewPath()+"essayList";
	}
	@RequestMapping(value="/single",method={RequestMethod.GET})
	public String showSingle(HttpServletRequest request){
		return getViewPath()+"singleList";
	}
	@RequestMapping(value="/user/{id}",method={RequestMethod.GET})
	public String showUserMain(HttpServletRequest request){
		return getViewPath()+"userMain";
	}
}
