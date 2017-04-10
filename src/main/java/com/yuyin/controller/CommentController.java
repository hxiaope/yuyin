package com.yuyin.controller;

import com.yuyin.common.pojo.CommonResult;
import com.yuyin.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by IntelliJ IDEA.
 * author: hxiaope
 * 2017/4/10.
 * version 1.0
 */
@Controller
public class CommentController {
    @Autowired
    private BaseService baseService;

    @RequestMapping("/user/comment")
    @ResponseBody
    public CommonResult insertComment(String userInfo,Long pId,Long eId,String content) throws Exception {
        return baseService.addcomment(userInfo,pId,eId,content);
    }

    @RequestMapping("/comment/essay")
    @ResponseBody
    public CommonResult getEssayComment(Long eId) throws Exception {
        return baseService.findEssayComment(eId);
    }

    @RequestMapping("/comment/periodical")
    @ResponseBody
    public CommonResult getPeriodicalComment(Long pId) throws Exception {
        return baseService.findPeriodicalComment(pId);
    }
}
