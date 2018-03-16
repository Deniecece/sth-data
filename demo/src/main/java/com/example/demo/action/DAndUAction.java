/**
 * @(#)PoiAction.java
 * Description:	TODO 填写文件作用简要说明
 * Version :	0.0.0
 * Copyright:	Copyright (c) 哈尔滨修盾信息科技有限公司  版权所有
 * Create by:	单彤  2018年3月13日
 */
package com.example.demo.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * TODO 文件上传下载
 * @author 单彤
 */
@RestController
public class DAndUAction {

	@RequestMapping("/show")
	public ModelAndView show() {
		return new ModelAndView("show");
	}
	
	/*文件上传*/
	@PostMapping("/upload")
	public String upload(@RequestParam("file") MultipartFile file,HttpServletRequest req) {
		//判断文件是否存在
		if(file.isEmpty()) {
			return "没有找到上传的文件...";
		}
		//获取文件名称
		String fileName = file.getOriginalFilename();
		//获取文件的扩展名称
		//String suffixName = fileName.substring(fileName.indexOf("."));
		//文件上传的路径
		String filePath = "D:/tmp/";
		//创建文件
		File dest = new File(filePath+fileName);
		//检查路径
		if(!dest.getParentFile().exists()) {
			dest.getParentFile().mkdirs();
		}
		//上传
		try{
			file.transferTo(dest);
		}catch(Exception e) {
			e.printStackTrace();
			return "failure...";
		}
		
		return "success upload";
	}
	
	@PostMapping("/uploads")
	public String t(HttpServletRequest req) {
		try {
			//获取上传文件的集合
			List<MultipartFile> list = ((MultipartHttpServletRequest)req).getFiles("file");
			//创建接收遍历文件的对象
			MultipartFile file = null;
			//判断文件是否存在
			if(list.size()==0) {
				return "no file";
			}
			//文件上传的路径
			String path = "D:/tmp/";
			//缓冲流--提高执行效率
			BufferedOutputStream stream = null;
			for(int i=0;i<list.size();i++) {
				//获取文件--按照下标
				file = list.get(i);
				if(!file.isEmpty()) {
					//字节数组
					byte[] bs = file.getBytes();
					//获取文件的流
					stream = new BufferedOutputStream(new FileOutputStream(new File(path+file.getOriginalFilename())));
					//上传文件
					stream.write(bs);
					stream.close();
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
			return "failure...";
		}		
		return "success upload";
	}
	
	@GetMapping("/download")
	public String download(HttpServletRequest req,HttpServletResponse resp) {
		try {
			//文件名
			String fileName = "";
			if(!fileName.equals("")) {
				//读取文件
				File file = new File("D:/tmp/"+fileName);
				//强制提示下载框
				resp.setContentType("application/force-download");
				resp.addHeader("Content-Disposition", "attachment;fileName="+fileName);
				//每次下载大小
				byte[] bs = new byte[1024];
				//下载
				try (FileInputStream fis = new FileInputStream(file);
						BufferedInputStream bis = new BufferedInputStream(fis);
						OutputStream os = resp.getOutputStream();
						){
					int i = bis.read(bs);
					//执行下载
					while(i!=-1) {
						os.write(bs,0,i);
						i=bis.read(bs);
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "";
	}
}
