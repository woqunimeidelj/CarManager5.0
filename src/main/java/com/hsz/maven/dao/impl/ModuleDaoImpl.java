package com.hsz.maven.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hsz.maven.dao.ModuleDao;
import com.hsz.maven.model.Module;
import com.hsz.maven.utils.MyHibernateDaoSupport;

@Repository("moduleDao")
@Transactional
public class ModuleDaoImpl extends MyHibernateDaoSupport implements ModuleDao {

	@Override
	public void addModule(Module module) {
		getHibernateTemplate().save(module);

	}

	@Override
	public List<Module> getAllModule() {
		
		return (List<Module>) getHibernateTemplate().find("FROM Module");
	}

	@Override
	public Module getModuleById(int module_id) {
		
		return getHibernateTemplate().get(Module.class, module_id);
	}

	@Override
	public void deleteModuleById(int module_id) {
		Module module = getHibernateTemplate().get(Module.class, module_id);
		getHibernateTemplate().delete(module);;
	}

	@Override
	public void updateModule(Module module) {
		
		getHibernateTemplate().update(module);
	}

}
