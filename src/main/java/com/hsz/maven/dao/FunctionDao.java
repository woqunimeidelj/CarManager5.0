package com.hsz.maven.dao;

import java.util.List;

import com.hsz.maven.model.Function;
import com.hsz.maven.model.Module;

public interface FunctionDao {

	public void addFunction(Function function); // 添加功能
	public List<Function> getAllFunction(); // 显示所有功能
	public List<Function> getFunction(int module_id); 
	public void deleteFunctionById(int function_id); // 删除功能根据ID
	public void updateFunction(Function function); // 更新Function
	public Function getFunctionById(int function_id); // 根据ID查询
}
