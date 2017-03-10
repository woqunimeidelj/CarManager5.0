package com.hsz.maven.filter;

import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hsz.maven.dao.UserDao;
import com.hsz.maven.model.Function;
import com.hsz.maven.model.Role;
import com.hsz.maven.model.User;



public class UserManager  {
	private static UserDao userDao;
	
	private static UserManager UMG = null;
	public static UserManager getInstance(){
		if(UMG==null){
			UMG = new UserManager();
			initUserManager();
		}
		return UMG;
	}
	
	public  boolean getGroupPermission(String user_id, String action) {
		boolean results = false;
		User user = (User) userDao.getUserById(Integer.parseInt(user_id));
		Role role = user.getRole();
		
		Set<Function> functionLists = role.getFunctionLists();
		for(Function fuction : functionLists){
			if(fuction.getFunction_code().equals(action)){
				results = true;
				break;
			}
		}

		return results;
	}
	public static void initUserManager(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		userDao = (UserDao) ctx.getBean("userDao");
	}

}
