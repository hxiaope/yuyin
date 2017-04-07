package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.junit.Test;

import com.yuyin.common.util.FtpUtil;

public class FtpTest {
	@Test
	public void demo() throws IOException{
		String host="192.168.2.129";//服务器地址
		int port=21;//服务器端口
		String username = "ftpuser";//FTP登录用户名
		String password = "ftpuser";//FTP登录密码
		String filename = "test.jpg";//图片名称
		String basePath = "/home/ftpuser/www/images";//存放根目录
		String filePath = "/2016";//存放目录
		File file = new File("D:\\photo.jpg");//打开图片文件
		FileInputStream input = new FileInputStream(file);//获取输入流
		//上传成功为true，失败为false
		boolean flag = FtpUtil.uploadFile(host, port, username, password, basePath, filePath, filename, input);
		System.out.println(flag);//输出结果
	}
}
