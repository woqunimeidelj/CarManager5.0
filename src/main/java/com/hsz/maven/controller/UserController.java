package com.hsz.maven.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hsz.maven.model.Role;
import com.hsz.maven.model.User;
import com.hsz.maven.server.RoleServer;
import com.hsz.maven.server.UserServer;


@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserServer userServer;
	@Autowired
	private RoleServer roleServer;
	
	/**
	 * 2.显示用户信息列表界面
	 * @param map
	 * @return
	 */
	//user/showuser.do
	@RequestMapping("showuser")
	public String listUser(Map<String,List<User>> map) {
		List<User> userLists = userServer.getAllUser();
		map.put("userLists", userLists);
		return "/user/list_user";
		
	}
	
	/**
	 * 3.根据用户ID查询用户
	 * @param user
	 * @param model
	 * @return
	 */
	//user/seleteuser.do
	@RequestMapping("seleteuser")
	public String seleteUser(Integer user_id,Model model) {
		User user = userServer.getUserById(user_id);
		model.addAttribute("user_id", user_id);
		model.addAttribute("user", user);
		
		List<Role> roleLists =  roleServer.getAllRoles();
		
		model.addAttribute("roleLists", roleLists);
		return "/user/update_user";
		
	}
	
	/**
	 * 4.判断如果状态为3就删除
	 * 	否则就修改
	 * @param user
	 * @param user_id
	 * @param model
	 * @return
	 */
	//user/updateuser.do
	@RequestMapping("updateuser")
	public String updateUser(User user,String role_name) {
		if(user.getState() == 3){
			userServer.deleteUserById(user.getUser_id());
			return "redirect:/user/showuser.do";
		}else{
			userServer.verifyUser(user, role_name);
			return "redirect:/user/showuser.do";
			
		}
	}
}
