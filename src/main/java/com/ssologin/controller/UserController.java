package com.ssologin.controller;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jasig.cas.client.authentication.AttributePrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssologin.pojo.User;
import com.ssologin.service.Impl.UserServiceImpl;

@Controller
public class UserController {
	@Autowired
	private UserServiceImpl userService;
	
//	@RequestMapping("/")
//	public String index(HttpServletRequest request,Model model) {
//		AttributePrincipal principal = (AttributePrincipal) request.getUserPrincipal();
//		Map<String, Object> attributes = principal.getAttributes();
//		String id = attributes.get("id").toString();
//		String password = attributes.get("password").toString();
//		Integer isAdmin = Integer.parseInt(attributes.get("isAdmin").toString());
//		model.addAttribute("isAdmin",isAdmin);
//		return "redirect:/userList";
//	}
	
	@RequestMapping({"/","/userList"})
	public String userList(Model model,HttpServletRequest request) {
		//获取cas服务端返回的值
		AttributePrincipal principal = (AttributePrincipal) request.getUserPrincipal();
		Map<String, Object> attributes = principal.getAttributes();
		Integer isAdmin = Integer.parseInt(attributes.get("isAdmin").toString());
		List<User> user = userService.findAllUsers();
		//发送isAdmin到前端，对身份进行判断
		model.addAttribute("isAdmin",isAdmin);
		model.addAttribute("users",user);
		return "userList";
	}
	
	@RequestMapping("/insertPage")
	public String addUser(){
		return "insertPage";
	}
	
	@PostMapping("/add")
	public String addUser(User user) {
		userService.addUser(user);
		return "redirect:/userList";
	}
		
	@GetMapping("/del/{id}")
	public String deleteUser(@PathVariable String id) {
		userService.deleteUserById(id);
		return "redirect:/userList";
	}
	
	@GetMapping("/updatePage/{id}")
	public String updateUser(@PathVariable String id,Model model) {
		User user = userService.findById(id);
		model.addAttribute("user",user);
		return "updatePage";
	}
	
	@PostMapping("/update")
	public String update(User user) {
		userService.updateUserById(user);
		return "redirect:/userList";
	}
	
	@GetMapping("/all")
	public List<User> findAll() {
		return userService.findAllUsers();
	}
	
	
	@RequestMapping("/goto")
	public String gotoPage(HttpServletRequest request,Model model) {
		model.addAttribute("flag","success");
		return "jump";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:http://sso.com:8080/cas/logout?service=http://localhost:8090/";
	}
}
