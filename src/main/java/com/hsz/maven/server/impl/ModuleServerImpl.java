package com.hsz.maven.server.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hsz.maven.dao.ModuleDao;
import com.hsz.maven.model.Module;
import com.hsz.maven.server.ModuleServer;

@Service("moduleServer")
@Transactional
public class ModuleServerImpl implements ModuleServer {

	@Autowired
	private ModuleDao moduleDao;
	
	@Override
	public void addModule(Module module) {
		
		moduleDao.addModule(module);

	}

	@Override
	public List<Module> getAllModule() {

		return moduleDao.getAllModule();
	}

	@Override
	public Module getModuleById(int module_id) {
		Module module = moduleDao.getModuleById(module_id);
		return module;
	}

	@Override
	public void deleteModuleById(int module_id) {
		moduleDao.deleteModuleById(module_id);

	}

	@Override
	public void updateModule(Module module) {
		moduleDao.updateModule(module);

	}

}
