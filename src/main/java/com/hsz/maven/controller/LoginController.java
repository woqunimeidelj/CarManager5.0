package com.hsz.maven.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hsz.maven.model.User;
import com.hsz.maven.server.UserServer;

@Controller
public class LoginController {

	@Autowired
	private UserServer userServer;
	
	@RequestMapping("login")
	public String login(){
		return "login"; // 此处返回值login是和jsp文件名一致
	}
	
	@RequestMapping("/login_submit")
	public String loginSubmit(User user,Model model){
		if(userServer.login(user) == null){
			model.addAttribute("error", "用户名密码出错或未通过审核!");
			return "login";
		}
		return "main";
	}
	
}
