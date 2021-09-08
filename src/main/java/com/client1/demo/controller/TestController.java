package com.client1.demo.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	
	HttpSession session;
	
	@RequestMapping("/")
	@ResponseBody
	public String test(HttpServletRequest request) {
		
		//获取请求路径
//		System.out.println(request.getRequestURI());
////		System.out.println(accept);
//		return "hello，cas";
		session = request.getSession();
		session.setAttribute("user", "name");
		return "登录成功，这里是登录系统！";
	}
	
	
	@RequestMapping("/goto")
	public String gotoPage(HttpServletRequest request,Model model) {
		System.out.println(session.getAttribute("user"));
		model.addAttribute("session",session);
		return "jump";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:http://sso.com:8080/cas/logout?service=http://localhost:8082/";
	}
}
