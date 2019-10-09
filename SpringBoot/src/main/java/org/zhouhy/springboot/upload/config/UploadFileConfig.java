package org.zhouhy.springboot.upload.config;

import javax.servlet.MultipartConfigElement;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;

import org.zhouhy.springboot.util.CommUtil;

@Configuration
public class UploadFileConfig {
	
	private String uploadFolder;
	
	public UploadFileConfig() {
		uploadFolder = System.getProperty(CommUtil.USER_DIR);
	}	
	
	@Bean
	public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		factory.setLocation(uploadFolder);		
		factory.setMaxFileSize(DataSize.ofKilobytes(1024*5));
		factory.setMaxRequestSize(DataSize.ofKilobytes(1024*20));		
		return factory.createMultipartConfig();		
	}
	
}
