package com.hsz.maven.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hsz.maven.dao.RoleDao;
import com.hsz.maven.model.Role;
import com.hsz.maven.utils.MyHibernateDaoSupport;

@Repository("roleDao")
@Transactional
public class RoleDaoImpl extends MyHibernateDaoSupport implements RoleDao {

	@Override
	public void addRole(Role role) {
		getHibernateTemplate().save(role);
	}

	@Override
	public List<Role> getAllRoles() {
		
		return (List<Role>) getHibernateTemplate().find("FROM Role");
	}

	@Override
	public Role getRoleById(int role_id) {
		
		return getHibernateTemplate().get(Role.class, role_id);
	}

	@Override
	public void updateRole(Role role) {
		
		getHibernateTemplate().update(role);

	}

	@Override
	public void deleteRoleById(int role_id) {
		Role role = getHibernateTemplate().get(Role.class, role_id);
		getHibernateTemplate().delete(role);
	}

}
