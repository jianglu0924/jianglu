package com.maokeshop.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
@RequestMapping("/upload")
public class UploadController {

	@ResponseBody
	@RequestMapping("/uploadPic")
	public String uploadPic(HttpServletRequest request,String fileName) throws IllegalStateException, IOException{
		//把Request转换成复杂的Request对象
		MultipartHttpServletRequest mr = (MultipartHttpServletRequest) request;
		
		//获得文件
		Map<String, MultipartFile> fileMap = mr.getFileMap();
		Set<String> keySet = fileMap.keySet();
		Iterator<String> iterator = keySet.iterator();
		String fileInputName = iterator.next();
		MultipartFile mf = fileMap.get(fileInputName);
		String originalFilename = mf.getOriginalFilename();
		
		//精确到毫秒  如果有高并发可以再加几组随机数
		String string = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
		/*Random r = new Random();
		for (int i = 0; i < 3; i++) {
			fileName = fileName+r.nextInt(10);
		}*/
		String newFileName = string + originalFilename.substring(originalFilename.lastIndexOf("."));
		
		System.out.println(newFileName);
		
		String filePath =  "E:\\upload\\";
		
		File file = new File(filePath+newFileName);
		
		mf.transferTo(file);
		if(fileName!=null&&!fileName.trim().equals("")){
			File f = new File(filePath+fileName);
			boolean b = f.delete();
			System.out.println(b);
		}
			
		
		return newFileName;
	}
	
}
