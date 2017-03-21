package com.hsz.maven.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hsz.maven.model.Function;
import com.hsz.maven.model.Role;
import com.hsz.maven.server.FunctionServer;
import com.hsz.maven.server.RoleServer;
import com.hsz.maven.utils.Utils;


@Controller
@RequestMapping("role")
public class RoleController {

	@Autowired
	private RoleServer roleServer;
	@Autowired
	private FunctionServer functionServer; 
	
	/**
	 * 1.登录到添加角色界面
	 * @param model
	 * @return
	 */
	//role/login_role.do
	@RequestMapping("loginrole")
	public String loginRole(Model model) {
		return "role/add_role";
		
	}
	
	/**
	 * 2.执行添加角色操作
	 * @param role
	 * @param model
	 * @return
	 */
	//role/addrole.do
	@RequestMapping("addrole")
	public String addRole(Role role,Model model) {
		roleServer.addRole(role);
		return "redirect:/role/showrole.do";
		

	}
	
	/**
	 * 3.显示角色列表界面
	 * @param map
	 * @return
	 */
	//role/showrole.do
	@RequestMapping("showrole")
	public String showRole(Map<String,List<Role>> map) {
		List<Role> roleLists = roleServer.getAllRoles();
		map.put("roleLists", roleLists);
		return "role/list_role";
		
	}
	
	/**
	 * 4.根据ID删除角色
	 * @param role_id
	 * @return
	 */
	//role/deleterole.do
	@RequestMapping("deleterole")
	public String deleteRole(Integer role_id) {
		roleServer.deleteRoleById(role_id);
		return "redirect:/role/showrole.do";
		
	}
	
	/**
	 * 5.显示角色模块功能列表信息
	 * @param role_id
	 * @param map
	 * @param model
	 * @return
	 */
	//role/listrolefunction.do
	@RequestMapping("listrolefunction")
	public String listRoleAndFunction(Integer role_id,Map<String,List<Function>> map,Model model) {
		Role role  = roleServer.getRoleById(role_id);
		List<Function> functionLists = Utils.setToList(role.getFunctionLists()); // 角色已经被赋予的功能列表
		
		List<Function> functionAllLists = functionServer.getAllFunction(); // 所有模块所有功能列表
		map.put("functionLists", functionLists);
		map.put("functionAllLists", functionAllLists);
		model.addAttribute("role_id", role_id);
		model.addAttribute("role", role);
		return "role/list_role_function";
		
	}
	
	/**
	 * 6.给角色选择功能
	 * @param role_id
	 * @param selectId
	 * @return
	 */
	//role/submitrolefunction.do
	@RequestMapping("submitrolefunction")
	public String submitRoleFunction(Integer role_id,Integer[] selectId,Model model) {
		Role role = roleServer.getRoleById(role_id);
		role.getFunctionLists().clear();
		
		Set<Function> functionLists = new HashSet<Function>();
		for(Integer function_id:selectId){
			Function function = functionServer.getFunctionById(function_id);
			functionLists.add(function);
		}
		role.setFunctionLists(functionLists);
		roleServer.updateRole(role); // 更新列表
		model.addAttribute("role", role);
		return "redirect:/role/listrolefunction.do?role_id="+role_id;
		
	}
}
