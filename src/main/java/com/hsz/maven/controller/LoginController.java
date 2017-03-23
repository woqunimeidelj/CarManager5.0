package com.hsz.maven.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
	
	@RequestMapping("/loginsubmit")
	public String loginSubmit(HttpServletRequest request,HttpServletResponse response,User user,String autoLogin,Model model){
		User users = userServer.login(user);
		int maxAGE = 60*60*12;
		if(users != null && users.getState() == 2){
			HttpSession session = request.getSession();
			// 统一登陆认证，保存用户到session,权限管理
			session.setAttribute("user_id", users.getUser_id()	);
			// 选择保存登录信息
			if("true".equals(autoLogin)){
				saveCookie(response, user, maxAGE);
			}else{
				saveCookie(response, user, 0);
			}
			return "main";
		}else if(users != null && users.getState() ==1){
			model.addAttribute("error", "用户正在审核中！！！");
			return "login";
		}else{
			model.addAttribute("error", "用户名或密码错误！！！");
			return "login";
		}
	}
	
		//保存用户信息到cookie
		public void saveCookie(HttpServletResponse response,User user,int maxAGE){
			Cookie cookie_name = new Cookie("username", user.getUsername());
			Cookie cookie_psw = new Cookie("password", user.getPassword());
			cookie_name.setMaxAge(maxAGE);
			cookie_psw.setMaxAge(maxAGE);
			response.addCookie(cookie_name);
			response.addCookie(cookie_psw);
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
	@RequestMapping("/form")
	public String form(){
		return "/homepage1";
	}
}
