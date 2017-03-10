package com.hsz.maven.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.hsz.maven.model.User;
import com.hsz.maven.server.UserServer;


@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserServer userServer;
	
	/**
	 * 登录到注册界面
	 * @return
	 */
	//register.do
	@RequestMapping("register")
	public String register(){
		return "user/add_user"; 
	}
	
	/**
	 * 1.执行注册用户操作
	 * @param user
	 * @param model
	 * @return
	 */
	//adduser.do
	@RequestMapping("adduser")
	public String addUser(User user,Model model) {
		userServer.addUser(user);
		return "redirect:/user/showuser.do";
	}
	
	/**
	 * 2.显示用户信息列表界面
	 * @param map
	 * @return
	 */
	//showuser.do
	@RequestMapping("showuser")
	public String listUser(Map<String,List<User>> map) {
		List<User> userLists = userServer.getAllUser();
		map.put("userLists", userLists);
		return "/user/list_user";
		
	}
}
