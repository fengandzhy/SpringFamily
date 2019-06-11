package com.citi.springboot.upload.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.citi.springboot.util.CommUtil;

@Configuration
public class UploadFilePathConfig implements WebMvcConfigurer{
	
	@Value("${file.staticAccessPath}")
    private String staticAccessPath;
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(staticAccessPath).addResourceLocations("file:" + System.getProperty(CommUtil.USER_DIR));
    }
	
}
