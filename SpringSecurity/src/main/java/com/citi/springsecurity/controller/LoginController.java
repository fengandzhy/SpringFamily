package com.citi.springsecurity.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	@RequestMapping("/")
    public ModelAndView showHome() {
		ModelAndView modelAndView = new ModelAndView("/home");
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        modelAndView.addObject("name", name);
        return modelAndView;
    }
	
	@RequestMapping("/loginError")
    public ModelAndView errorPage(HttpServletRequest req) {
		ModelAndView modelAndView = new ModelAndView("/login");
		AuthenticationException exp = (AuthenticationException)req.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
		modelAndView.addObject("error", true);
		if(exp instanceof BadCredentialsException){
			modelAndView.addObject("error_msg", "用户名或密码错误");
		} else if(exp instanceof AccountExpiredException){
			modelAndView.addObject("error_msg", "账户过期");
		} else if(exp instanceof LockedException){
			modelAndView.addObject("error_msg", "账户已被锁");
		}
		return modelAndView;
    }
	
	@RequestMapping("/loginSuccess")
    public ModelAndView logout(HttpServletRequest req) {
		ModelAndView modelAndView = new ModelAndView("/login");		
		modelAndView.addObject("logout", true);
		modelAndView.addObject("msg", "已注销");
		return modelAndView;
    }
	
	
    @RequestMapping("/admin")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String printAdmin() {
        return "如果你看见这句话，说明你有ROLE_ADMIN角色";
    }

    @RequestMapping("/user")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_USER')")
    public String printUser() {
        return "如果你看见这句话，说明你有ROLE_USER角色";
    }
}
