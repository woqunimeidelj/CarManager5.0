package com.hsz.maven.model;

import java.util.Set;

/**
 * 角色
 * @author scxh
 *
 */
public class Role {

	private int role_id;
	private String role_name;  // 角色名称
	private String description; // 角色描述
	private Set<User> userLists; // 一端持有多端的集合
	private Set<Function> functionLists;
	
	public Role() {
		
	}
	
	public Role(String role_name, String description) {
		
		this.role_name = role_name;
		this.description = description;
	}


	public Role(int role_id, String role_name, String description) {
		
		this.role_id = role_id;
		this.role_name = role_name;
		this.description = description;
		
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<User> getUserLists() {
		return userLists;
	}

	public void setUserLists(Set<User> userLists) {
		this.userLists = userLists;
	}

	public Set<Function> getFunctionLists() {
		return functionLists;
	}

	public void setFunctionLists(Set<Function> functionLists) {
		this.functionLists = functionLists;
	}

	@Override
	public String toString() {
		return "Role [role_id=" + role_id + ", role_name=" + role_name + ", description=" + description 
			 + "]";
	}
	
}
