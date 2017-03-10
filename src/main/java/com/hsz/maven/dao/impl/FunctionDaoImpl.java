package com.hsz.maven.dao.impl;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hsz.maven.dao.FunctionDao;
import com.hsz.maven.model.Function;
import com.hsz.maven.model.Module;
import com.hsz.maven.utils.MyHibernateDaoSupport;
import com.hsz.maven.utils.Utils;

@Repository("functionDao")
@Transactional
public class FunctionDaoImpl extends MyHibernateDaoSupport implements FunctionDao {

	@Override
	public void addFunction(Function function) {
		
		getHibernateTemplate().save(function);

	}

	@Override
	public List<Function> getAllFunction() {
		
		return (List<Function>) getHibernateTemplate().find("FROM Function");
	}

	@Override
	public List<Function> getFunction(int module_id) {
		Module module = getHibernateTemplate().get(Module.class, module_id);
		Set<Function> sets = module.getFunctionLists();
		return Utils.setToList(sets);
	}

	@Override
	public void deleteFunctionById(int function_id) {
		Function function = getHibernateTemplate().get(Function.class, function_id);
		getHibernateTemplate().delete(function);;
	}

	@Override
	public void updateFunction(Function function) {
		getHibernateTemplate().update(function);
		
	}

	@Override
	public Function getFunctionById(int function_id) {
		
		return getHibernateTemplate().get(Function.class, function_id);
	}

}
