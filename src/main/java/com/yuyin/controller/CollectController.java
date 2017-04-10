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
public class CollectController {
    @Autowired
    private BaseService baseService;

    @RequestMapping("/insert/collect")
    @ResponseBody
    public CommonResult insertCollect(Long userId,Long pId,Long eId,Long sId) throws Exception{
        return baseService.addcollect(userId,pId,eId,sId);
    }

    @RequestMapping("/user/periodical")
    @ResponseBody
    public CommonResult findPeriodicalCollect(Long userId) throws Exception{
        return baseService.findPeriodicalCollect(userId);
    }

    @RequestMapping("/user/single")
    @ResponseBody
    public CommonResult findSingleCollect(Long userId) throws Exception{
        return baseService.findSingelCollect(userId);
    }

    @RequestMapping("/user/essay")
    @ResponseBody
    public CommonResult findEssayCollect(Long userId) throws Exception{
        return baseService.findEssayCollect(userId);
    }
}
