package com.hsz.maven.server.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hsz.maven.dao.FunctionDao;
import com.hsz.maven.model.Function;
import com.hsz.maven.server.FunctionServer;


@Service("functionServer")
@Transactional
public class FunctionServerImpl implements FunctionServer {
	
	@Autowired
	private FunctionDao functionDao;
	
	@Override
	public void addFunction(Function function) {
		functionDao.addFunction(function);

	}

	@Override
	public List<Function> getAllFunction() {
		List<Function> functionLists = functionDao.getAllFunction();
		return functionLists;
	}

	@Override
	public List<Function> getFunction(int module_id) {
		
		return functionDao.getFunction(module_id);
	}

	@Override
	public void deleteFunctionById(int function_id) {
		
		functionDao.deleteFunctionById(function_id);

	}

	@Override
	public void updateFunction(Function function) {

		functionDao.updateFunction(function);
	}

	@Override
	public Function getFunctionById(int function_id) {
		
		return functionDao.getFunctionById(function_id);
	}

}
