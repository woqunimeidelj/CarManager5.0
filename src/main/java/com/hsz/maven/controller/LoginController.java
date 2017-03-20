package com.hsz.maven.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	
	//登录界面
	@RequestMapping("/login")
	public String login(){
		return "login"; // 此处返回值login是和jsp文件名一致
	}
	
	@RequestMapping("/login_submit")
	public String loginSubmit(HttpServletRequest request,User user,Model model){
		User users = userServer.login(user);
		if(users == null){
			model.addAttribute("error", "用户名密码出错或未通过审核!");
			return "login";
		}else{
		HttpSession session = request.getSession();
		session.setAttribute("user_id", users.getUser_id()	);
		return "main";
		}
	}
	
	/**
	 * 登录到注册界面
	 * @return
	 */
	//user/register.do
	@RequestMapping("/register")
	public String register(){
		return "/user/add_user"; 
	}
	
	/**
	 * 1.执行注册用户操作
	 * @param user
	 * @param model
	 * @return
	 */
	//user/adduser.do
	@RequestMapping("/adduser")
	public String addUser(User user,Model model) {
		userServer.addUser(user);
		return "redirect:/login.do";
	}
}
