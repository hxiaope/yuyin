package com.yuyin.service.Implement;

import com.yuyin.common.pojo.UploadResult;
import com.yuyin.common.util.FtpUtil;
import com.yuyin.common.util.IDUtils;
import com.yuyin.service.UploadService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
/**
 * 上传文件服务实现类
 * @Title:UploadServiceImpl
 * @author hxiaope
 * @date 2017年3月1日下午7:43:39
 * @version 1.0
 */
@SuppressWarnings("unchecked")
@Service("UploadService")
public class UploadServiceImpl implements UploadService {
	//服务器信息
	@Value("${FTP_ADDRESS}")
	private String FTP_ADDRESS;//地址 FTP_ADDRESS=139.199.206.31
	@Value("${FTP_PORT}")
	private Integer FTP_PORT; //端口 FTP_PORT=21
	@Value("${FTP_USERNAEM}")
	private String FTP_USERNAEM;//用户名 FTP_USERNAEM=root
	@Value("${FTP_PASSWORD}")
	private String FTP_PASSWORD;//密码 FTP_PASSWORD=h5*****
	@Value("${FTP_PIC_PATH}")
	private String FTP_PIC_PATH;// 图片目录 FTP_PIC_PATH=/home/ftpuser/www/images
	@Value("${FTP_MUS_PATH}")
	private String FTP_MUS_PATH; //音乐目录 FTP_MUS_PATH=/home/ftpuser/www/music
	@Value("${IMAGE_BASE_URL}")
	private String IMAGE_BASE_URL;//图片服务器的基础url IMAGE_BASE_URL=http://139.199.206.31/images
	@Value("${MUSIC_BASE_URL}")
	private String MUSIC_BASE_URL;//音乐服务器的基础url MUSIC_BASE_URL=http://139.199.206.31/music

	@Override
	public Map uploadPicture(MultipartFile uploadFile)throws IOException{
		Map resultMap = new HashMap<>();
		try {
		// 取原文件名
		String oldName = uploadFile.getOriginalFilename();
		// 生成新的文件名 IDUtils取当前时间的长整形值包含毫秒加上三位随机数
		String newName = IDUtils.getName();
		//取旧文件名的后缀.jpg/.png/.gif
		newName = newName + oldName.substring(oldName.lastIndexOf("."));
		// 上传存放的目录用当前时间的格式
		String imagePath=new DateTime().toString("/yyyy/MM/dd");
		/** 
		 * @param FTP_ADDRESS FTP服务器地址
		 * @param FTP_PORT FTP服务器端口 
		 * @param FTP_USERNAEM FTP登录账号 
		 * @param FTP_PASSWORD FTP登录密码 
		 * @param FTP_PIC_PATH FTP服务器基础目录
		 * @param imagePath FTP服务器文件存放路径。例如分日期存放：/2017/03/24。文件的路径为basePath+filePath
		 * @param newName 上传到FTP服务器上的文件名 
		 * @param uploadFile.getInputStream() 输入流 
		 * @return 成功返回true，否则返回false 
		 */  
		boolean result = FtpUtil.uploadFile(FTP_ADDRESS, FTP_PORT, FTP_USERNAEM, FTP_PASSWORD, FTP_PIC_PATH,
					imagePath, newName, uploadFile.getInputStream());
		if(!result){
			//上传失败将状态信息放入Map中返回
			resultMap.put("code", 2);
			resultMap.put("msg", "图片上传失败");
			return resultMap; 
			}
		//上传成功将状态信息以及路径IMAGE_BASE_URL+imagePath+"/"+newName放入Map中返回
		resultMap.put("code", 1);
		resultMap.put("url",IMAGE_BASE_URL+imagePath+"/"+newName);
		resultMap.put("msg", "图片上传成功");
		return resultMap;
		} catch (IOException e) {
			//发生异常将信息放入Map中返回
			resultMap.put("code", 3);
			resultMap.put("msg", "图片上传发生异常");
			return resultMap;
		}
	}

	@Override
	public Map uploadMusic(MultipartFile uploadFile)throws IOException {
		Map resultMap = new HashMap<>();
		try {
		// 生成一个新的文件名
		// 取原文件名
		String oldName = uploadFile.getOriginalFilename();
		// 生成新的文件名 UUID.randomUUID();
		String newName = IDUtils.getName();
		newName = newName + oldName.substring(oldName.lastIndexOf("."));
		// 音乐上传
		String musicPath=new DateTime().toString("/yyyy/MM/dd");
		
		boolean result = FtpUtil.uploadFile(FTP_ADDRESS, FTP_PORT, FTP_USERNAEM, FTP_PASSWORD, FTP_MUS_PATH,
				musicPath, newName, uploadFile.getInputStream());
		if(!result){
			resultMap.put("code", 2);
			resultMap.put("msg", "音乐上传失败");
			return resultMap; 
			}
		resultMap.put("code", 1);
		resultMap.put("url",MUSIC_BASE_URL+musicPath+"/"+newName);
		resultMap.put("msg", "音乐上传成功");
		return resultMap;
		} catch (IOException e) {
			resultMap.put("code", 3);
			resultMap.put("msg", "音乐上传发生异常");
			return resultMap;
		}
	}

	@Override
	public UploadResult uploadEditPic(MultipartFile file) throws IOException {
		UploadResult uploadResult = new UploadResult();
		Map map =new HashMap();
		try {
			// 生成一个新的文件名
			// 取原文件名
			String oldName = file.getOriginalFilename();
			// 生成新的文件名 UUID.randomUUID();
			String newName = IDUtils.getName();
			newName = newName + oldName.substring(oldName.lastIndexOf("."));
			// 图片上传
			String imagePath=new DateTime().toString("/yyyy/MM/dd");
			
			boolean result = FtpUtil.uploadFile(FTP_ADDRESS, FTP_PORT, FTP_USERNAEM, FTP_PASSWORD, FTP_PIC_PATH,
						imagePath, newName, file.getInputStream());
			if(!result){
				uploadResult.setCode(2);
				uploadResult.setMsg("图片上传失败");
				return uploadResult; 
				}
			uploadResult.setCode(0);
			map.put("src",IMAGE_BASE_URL+imagePath+"/"+newName);
			map.put("title",newName);
			uploadResult.setMsg("图片上传成功");
			uploadResult.setData(map);
			return uploadResult;
			} catch (IOException e) {
				uploadResult.setCode(3);
				uploadResult.setMsg("图片上传发生异常");
				return uploadResult;
			}
	}

}
