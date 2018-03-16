/**
 * @(#)PoiAction.java
 * Description:	TODO ��д�ļ����ü�Ҫ˵��
 * Version :	0.0.0
 * Copyright:	Copyright (c) �������޶���Ϣ�Ƽ����޹�˾  ��Ȩ����
 * Create by:	��ͮ  2018��3��13��
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
 * TODO �ļ��ϴ�����
 * @author ��ͮ
 */
@RestController
public class DAndUAction {

	@RequestMapping("/show")
	public ModelAndView show() {
		return new ModelAndView("show");
	}
	
	/*�ļ��ϴ�*/
	@PostMapping("/upload")
	public String upload(@RequestParam("file") MultipartFile file,HttpServletRequest req) {
		//�ж��ļ��Ƿ����
		if(file.isEmpty()) {
			return "û���ҵ��ϴ����ļ�...";
		}
		//��ȡ�ļ�����
		String fileName = file.getOriginalFilename();
		//��ȡ�ļ�����չ����
		//String suffixName = fileName.substring(fileName.indexOf("."));
		//�ļ��ϴ���·��
		String filePath = "D:/tmp/";
		//�����ļ�
		File dest = new File(filePath+fileName);
		//���·��
		if(!dest.getParentFile().exists()) {
			dest.getParentFile().mkdirs();
		}
		//�ϴ�
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
			//��ȡ�ϴ��ļ��ļ���
			List<MultipartFile> list = ((MultipartHttpServletRequest)req).getFiles("file");
			//�������ձ����ļ��Ķ���
			MultipartFile file = null;
			//�ж��ļ��Ƿ����
			if(list.size()==0) {
				return "no file";
			}
			//�ļ��ϴ���·��
			String path = "D:/tmp/";
			//������--���ִ��Ч��
			BufferedOutputStream stream = null;
			for(int i=0;i<list.size();i++) {
				//��ȡ�ļ�--�����±�
				file = list.get(i);
				if(!file.isEmpty()) {
					//�ֽ�����
					byte[] bs = file.getBytes();
					//��ȡ�ļ�����
					stream = new BufferedOutputStream(new FileOutputStream(new File(path+file.getOriginalFilename())));
					//�ϴ��ļ�
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
			//�ļ���
			String fileName = "";
			if(!fileName.equals("")) {
				//��ȡ�ļ�
				File file = new File("D:/tmp/"+fileName);
				//ǿ����ʾ���ؿ�
				resp.setContentType("application/force-download");
				resp.addHeader("Content-Disposition", "attachment;fileName="+fileName);
				//ÿ�����ش�С
				byte[] bs = new byte[1024];
				//����
				try (FileInputStream fis = new FileInputStream(file);
						BufferedInputStream bis = new BufferedInputStream(fis);
						OutputStream os = resp.getOutputStream();
						){
					int i = bis.read(bs);
					//ִ������
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
