package com.hsz.maven.daoimpl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hsz.maven.dao.FunctionDao;
import com.hsz.maven.dao.ModuleDao;
import com.hsz.maven.dao.RoleDao;
import com.hsz.maven.model.Function;
import com.hsz.maven.model.Module;

public class TestCarManager {

//	private FunctionDao functionDao;
//	private ModuleDao moduleDao;
//	private RoleDao roleDao;
//	
	/**
	 * 加载spring核心配置文件applicationContext.xml
	 * 根据applicationContext.xml中配置由spring容器实例相关bean,同时扫描指定包，实例化注解类
	 */
//	@Before
//	public void before() {
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//		functionDao = (FunctionDao) ctx.getBean("functionDao");
//		moduleDao = (ModuleDao) ctx.getBean("moduleDao");
//		roleDao = (RoleDao) ctx.getBean("roleDao");
//	}
	
	/**
	 * 新建添加模块
	 */
//	@Test
//	public void testAddModule() {
//		Module module = new Module("功能管理", "对功能进行管理");
//		moduleDao.addModule(module);
//	}
	
	/**
	 * 查询所有模块
	 */
//	@Test
//	public void testGetAllModule() {
//		List<Module> moduleLists = moduleDao.getAllModule();
//		for(Module module:moduleLists){
//			System.out.println(module);
//		}
//	}
	
	
	/**
	 * 新建添加功能
	 */
//	@Test
//	public void testAddFunction() {
//		Module module = moduleDao.getModuleById(1);
//		Function function = new Function("/car/show.do", "车辆列表信息",module);
//		functionDao.addFunction(function);
//
//	}
//	
	/**
	 * 查询指定模块下的所有功能
	 */
//	@Test
//	public void testGetAllFunctionByModule(){
//		List<Function> functionLists = functionDao.getFunction(1);
//		for(Function function:functionLists){
//			System.out.println(function);
//		}
//	}
}
