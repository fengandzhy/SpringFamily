package com.citi.springboot.multiupload.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MultiUploadController {
	
	
	@RequestMapping(path = "/multiupload", method=RequestMethod.GET)
	public String uploadIndex() {
		return "/thymeleaf/multiupload/upload";
	}
	
	
}
