package com.hsz.maven.dao;

import java.util.List;

import com.hsz.maven.model.Module;

public interface ModuleDao {

	public void addModule(Module module); // 添加模块
	public List<Module> getAllModule();  //显示所有模块
	public Module getModuleById(int module_id); // 根据ID查询
	public void deleteModuleById(int module_id); // 删除模块根据ID
	public void updateModule(Module module); // 更新Moduel
}
