package com.hsz.maven.server.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hsz.maven.dao.RoleDao;
import com.hsz.maven.dao.UserDao;
import com.hsz.maven.model.Role;
import com.hsz.maven.model.User;
import com.hsz.maven.server.UserServer;

@Service("userServer")
@Transactional
public class UserServerImpl implements UserServer {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RoleDao roleDao; 
	
	@Override
	public void addUser(User user) {
		userDao.addUser(user);

	}

	@Override
	public List<User> getAllUser() {
		List<User> userLists =	userDao.getAllUser();
		return userLists;
	}

	@Override
	public User getUserById(int user_id) {
		 
		return  userDao.getUserById(user_id);
	}

	@Override
	public void deleteUserById(int user_id) {
		userDao.deleteUserById(user_id);

	}

	@Override
	public void updateUser(User user,String role_name) {
		userDao.updateUser(user);

	}

	/**
     * 注册用户
     * 判断用户是否存在 
     * true 表示注册成功
     * false 注册失败
     */
	@Override
	public boolean registerUser(User user) {
		User u = userDao.getUserByName(user.getUsername());
		if(u == null ){
			userDao.addUser(user);
			return true;
		}else{
			return false;
		}
	}

	/**
	 * state 审核是否通过
	 * 1 审核未通过
	 * 2 审核 通过
	 */
	@Override
	public User login(User user) {
	User u = userDao.checkUser(user);
	if(u != null){
		int state = u.getState();
		if(state == 2){
			return u;
		}else{
			return null;
		}
	}else{
			return null;
		}
	}
	
	/**
	 * 注册用户，赋予角色
	 */
	@Override
	public void verifyUser(User user, String role_name) {
		
			Role role = roleDao.getRoleByName(role_name);
			user.setRole(role);
			userDao.updateUser(user);
		
		
	}

	@Override
	public User getUserByName(String username) {
		User user = userDao.getUserByName(username);
		return user;
	}

}
