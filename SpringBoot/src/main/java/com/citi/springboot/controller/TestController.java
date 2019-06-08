package com.citi.springboot.controller;


import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import com.citi.springboot.entiry.RequestLoginBean;

/***
 * 如果只是使用@RestController注解Controller，则Controller中的方法无法返回jsp页面，配置的视图解析器InternalResourceViewResolver不起作用，返回的内容就是Return 里的内容。

例如：本来应该到success.jsp页面的，则其显示success.
 * produces改变了response的Content-Type →application/json;charset=UTF-8
 *
 */
@RestController
@RequestMapping(value = "/index", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class TestController {	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/loginbypost2", method = {RequestMethod.POST, RequestMethod.GET })
	public String loginByPost2(@RequestBody RequestLoginBean loginBean) {
		JSONObject result = new JSONObject();
		result.put("username", loginBean.getUsername());
		result.put("password", loginBean.getPassword());
		return result.toJSONString();
	}
}
