package com.citi.springboot.upload.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.citi.springboot.upload.domain.JsonData;

@Controller
public class FileController {	
	
	@Value("${file.uploadFolder}")
    private String filePath;
	
	
	@ResponseBody
	@RequestMapping(path="/upload",method=RequestMethod.POST)
	public JsonData upload(@RequestParam("head_img")MultipartFile file,HttpServletRequest request) {
		
		String name = request.getParameter("name");
		System.out.println("用户名："+name);
		
		String fileName = file.getOriginalFilename();
		System.out.println("文件名："+fileName);
		
		String suffixName = fileName.substring(fileName.lastIndexOf("."));
		System.out.println("后缀名："+suffixName);
		
		fileName = UUID.randomUUID()+suffixName;
		System.out.println("转换后的文件名："+fileName);
		
		File dest = new File(filePath + fileName);
		System.out.println(dest.isAbsolute());
		
		try {
			file.transferTo(dest);
			return new JsonData(0,fileName);
		} catch (IllegalStateException | IOException e) {			
			e.printStackTrace();
			return new JsonData(-1,e.getMessage());
		}		
	}
}
