package com.hsz.maven.server.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hsz.maven.dao.RoleDao;
import com.hsz.maven.model.Role;
import com.hsz.maven.server.RoleServer;

@Service("roleServer")
@Transactional
public class RoleServerImpl implements RoleServer {

	@Autowired
	private RoleDao roleDao;
	
	@Override
	public void addRole(Role role) {
		roleDao.addRole(role);
		
	}

	@Override
	public List<Role> getAllRoles() {
		List<Role> roleLists = roleDao.getAllRoles();
		return roleLists;
	}

	@Override
	public Role getRoleById(int role_id) {
		
		return roleDao.getRoleById(role_id);
	}

	@Override
	public void deleteRoleById(int role_id) {
		roleDao.deleteRoleById(role_id);
		
	}

	@Override
	public void updateRole(Role role) {
		roleDao.updateRole(role);
		
	}

}
