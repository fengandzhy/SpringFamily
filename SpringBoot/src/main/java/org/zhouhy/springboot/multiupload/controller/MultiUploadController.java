package org.zhouhy.springboot.multiupload.controller;



import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import org.zhouhy.springboot.upload.domain.JsonData;

@Controller
public class MultiUploadController {
	
	@Value("${file.uploadFolder}")
    private String filePath;
	
	
	@RequestMapping(path = "/multiupload", method=RequestMethod.GET)
	public String uploadIndex() {
		return "/thymeleaf/multiupload/upload";
	}
	
	
	@ResponseBody
	@RequestMapping(path="/multiupload",method=RequestMethod.POST)
	public JsonData multiupload(@RequestParam("files") MultipartFile[] files,
			@RequestParam("descriptions") String[] descriptions,HttpServletRequest request) {
		
		if (null != descriptions && descriptions.length > 0) {
			for (int i=0; i < descriptions.length; i++) {
				String description = descriptions[i];
				System.out.println("description" + i + " = " + description);
			}
		}

		String destionation = filePath + File.separator;
		System.out.println("destionation = " + destionation);
		
		if (null != files && files.length > 0) {
			for (MultipartFile file : files) {
				// 测试MultipartFile接口的各个方法
				System.out.println("文件类型ContentType=" + file.getContentType());
				System.out.println("文件组件名称Name=" + file.getName());
				System.out.println("文件原名称OriginalFileName=" + file.getOriginalFilename());
				System.out.println("文件大小Size=" + file.getSize() + "byte or " + file.getSize()/1024 + "KB");
				try {
					file.transferTo(new File(destionation + File.separator + file.getOriginalFilename()));					
				} catch (IllegalStateException | IOException e) {			
					e.printStackTrace();
					return new JsonData(-1,e.getMessage());
				}
			}			
		}		
		return new JsonData(0,"success");
	}
}
