package com.hsz.maven.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hsz.maven.model.Function;
import com.hsz.maven.model.Module;
import com.hsz.maven.server.FunctionServer;
import com.hsz.maven.server.ModuleServer;


@Controller
@RequestMapping("function")
public class FunctionController {

	@Autowired
	private FunctionServer functionServer;
	
	@Autowired
	private ModuleServer moduleServer;
	
	
	/**
	 * 1.登录到添加功能界面
	 * @param model
	 * @return
	 */
	//function/login_function.do
	@RequestMapping("login_function")
	public String loginFunction(Model model){
		
		return "function/add_function";
	}
	
	/**
	 * 2.执行添加功能操作
	 * @param function
	 * @param model
	 * @return
	 */
	//function/addfunction.do
	@RequestMapping("addfunction")
	public String addFunction(Integer module_id, String function_code,@RequestParam("description") String description) {
		Module module = moduleServer.getModuleById(module_id);
		
		Function function = new Function(function_code,description,module);
		functionServer.addFunction(function);
		return "redirect:/function/showfunction.do?module_id=" + module_id;
	}
	
	/**
	 * 3.显示功能列表界面
	 * @param map
	 * @return
	 */
	//function/showfunction.do
	@RequestMapping("showfunction")
	public String listFunction(Integer module_id,Map<String ,List<Function>> map,Model model) {
		List<Function> functionLists = functionServer.getFunction(module_id);
		
		Module module = moduleServer.getModuleById(module_id);	
		map.put("functionLists", functionLists);
		model.addAttribute("module_id",module_id);
		model.addAttribute("module", module);
		return "function/list_function";
		
	}
	
	/**
	 * 4.根据ID删除功能
	 * @param function_id
	 * @return
	 */
	//function/deletefunction.do
	@RequestMapping("deletefunction")
	public String deleteFunction(Integer function_id,Model model){
		int module_id = functionServer.getFunctionById(function_id).getModule().getModule_id();
		functionServer.deleteFunctionById(function_id);
		model.addAttribute("module_id", module_id);
		return "redirect:/function/showfunction.do";
		
	}
	
	
	@RequestMapping("updatefunction")
	public String updateFunction(Function function,Model model) {
		functionServer.updateFunction(function);
		return null;
		
	}
}
