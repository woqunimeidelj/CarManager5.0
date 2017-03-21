package com.hsz.maven.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hsz.maven.model.Module;
import com.hsz.maven.server.ModuleServer;

@Controller
@RequestMapping("module")
public class ModuleController {
	
	@Autowired
	private ModuleServer moduleServer;
	
	/**
	 * 1.登录到添加模块界面
	 * @param model
	 * @return
	 */
	//module/addmodule.do
	@RequestMapping("loginmodule")
	public String loginModule(Model model){
		
		return "module/add_module";
	}
	
	/**
	 * 2.执行添加模块操作
	 * @param module
	 * @param model
	 * @return
	 */
	//module/addmodule.do
	@RequestMapping("addmodule")
	public String addModule(Module module,Model model) {
		moduleServer.addModule(module);
		return "redirect:/module/showmodule.do";
	}

	/**
	 * 3.显示模块列表界面
	 * @param map
	 * @return
	 */
	//module/showmodule.do
	@RequestMapping("showmodule")
	public String listModule(Map<String,List<Module>> map) {
		List<Module> moduleLists = moduleServer.getAllModule();
		map.put("moduleLists", moduleLists);
		return "/module/list_module";
		
	}
	
	/**
	 * 4.根据ID删除模块
	 * @param module_id
	 * @return
	 */
	//module/deletemodule.do
	@RequestMapping("deletemodule")
	public String deleteModule(Integer module_id) {
		moduleServer.deleteModuleById(module_id);
		return "redirect:/module/showmodule.do";
		
	}
}
