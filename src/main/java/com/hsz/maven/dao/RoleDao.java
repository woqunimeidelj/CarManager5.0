package com.hsz.maven.dao;

import java.util.List;

import com.hsz.maven.model.Role;

public interface RoleDao {

	public void addRole(Role role); // 添加角色
	public List<Role> getAllRoles(); // 显示所有角色
	public Role getRoleById(int role_id); // 根据ID查询
	public void deleteRoleById(int role_id); // 根据ID删除
	public void updateRole(Role role); // 修改角色
	public Role getRoleByName(String role_name); // 根据角色名查询
}
