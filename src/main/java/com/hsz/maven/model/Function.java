package com.hsz.maven.model;

import java.util.Set;

/**
 * 功能
 * @author scxh
 *
 */
public class Function {

	private int function_id;
	private String function_code; // 功能名称
	private String description; // 功能描述
	private Module module; // 多端持有一端实例
	private Set<Role> roleLists;
	
	public Function() {
		
	}

	public Function(String function_code, String description,Module module) {
		
		this.function_code = function_code;
		this.description = description;
		this.module = module;
	}
	
	
	public Function(int function_id, String function_code, String description,Module module) {
		
		this.function_id = function_id;
		this.function_code = function_code;
		this.description = description;
		this.module = module;
	}

	public int getFunction_id() {
		return function_id;
	}

	public void setFunction_id(int function_id) {
		this.function_id = function_id;
	}

	public String getFunction_code() {
		return function_code;
	}

	public void setFunction_code(String function_code) {
		this.function_code = function_code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public Set<Role> getRoleLists() {
		return roleLists;
	}

	public void setRoleLists(Set<Role> roleLists) {
		this.roleLists = roleLists;
	}

	@Override
	public String toString() {
		return "Function [function_id=" + function_id + ", function_code=" + function_code + ", description="
				+ description + ",module=" + module +"]";
	}
	
}
