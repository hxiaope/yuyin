package com.yuyin.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.yuyin.common.pojo.UploadResult;
import com.yuyin.common.util.FtpUtil;
import com.yuyin.common.util.JsonUtils;

/**
 * 
 * @Title:Test
 * @author hxiaope
 * @date 2017年3月1日下午8:47:23
 * @version 1.0
 */
public class FtpTest {

	@Test
	public void demo() throws IOException{
		String host="192.168.2.129";
		int port=21;
		String username = "ftpuser";
		String password = "ftpuser";
		String filename = "test.jpg";
		String basePath = "/home/ftpuser/www/images";
		String filePath = "/2016";
		File file = new File("D:\\photo.jpg");
		FileInputStream input = new FileInputStream(file);
		boolean flag = FtpUtil.uploadFile(host, port, username, password, basePath, filePath, filename, input);
		System.out.println(flag);
/*		UploadResult uploadResult = new UploadResult();
		uploadResult.setCode(01);
		uploadResult.setMsg("success");
		Map map =new HashMap();
		map.put("src", "13246548712332");
		uploadResult.setData(map);
		String json = JsonUtils.objectToJson(uploadResult);
		System.out.println(json);*/
	}
}
