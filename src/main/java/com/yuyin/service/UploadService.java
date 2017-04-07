package com.yuyin.service;

import java.io.IOException;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.yuyin.common.pojo.UploadResult;

/**
 * 上传服务接口
 * @Title:UploadService
 * @author hxiaope
 * @date 2017年3月1日下午7:41:54
 * @version 1.0
 */
public interface UploadService {
	//上传图片
	Map uploadPicture(MultipartFile uploadFile)throws IOException;
	//上传音乐
	Map uploadMusic(MultipartFile uploadFile)throws IOException;
	//富文本编辑器上传图片
	UploadResult uploadEditPic(MultipartFile file) throws IOException;
}
