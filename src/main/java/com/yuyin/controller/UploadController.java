package com.yuyin.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yuyin.common.pojo.UploadResult;
import com.yuyin.common.util.JsonUtils;
import com.yuyin.service.UploadService;

/**
 * 文件上传Controller用于图片和音乐上传,返回UploadResult的json格式
 * @Title:UploadController
 * @author hxiaope
 * @date 2017年3月1日下午6:44:10
 * @version 1.0
 */
@Controller
public class UploadController {

	@Autowired
	private UploadService uploadService;//文件上传接口
	
	@ResponseBody
	@RequestMapping("/upload/picture")
	public String uploadPicture(@RequestParam MultipartFile picFile) throws IOException{
		if(picFile!=null){
		Map result = uploadService.uploadPicture(picFile);
		String json  = JsonUtils.objectToJson(result);
		return json;
		}else{
			String json="{\"code\":3}";
			return json;
		}
	}
	
	@ResponseBody
	@RequestMapping("/upload/music")
	public String uploadMusic(@RequestParam MultipartFile mscFile) throws IOException{
		if(mscFile!=null){
		Map result = uploadService.uploadMusic(mscFile);
		String json  = JsonUtils.objectToJson(result);
		return json;
		}else{
			String json="{\"code\":3}";
			return json;
		}
	}
	
	@ResponseBody
	@RequestMapping("/upload/editPic")
	public String uploadEditPic(MultipartFile file) throws IOException{
		if(file!=null){
		UploadResult result = uploadService.uploadEditPic(file);
		String json  = JsonUtils.objectToJson(result);
		return json;
		}else{
			String json="{\"code\":3}";
			return json;
		}
	}
	
}
