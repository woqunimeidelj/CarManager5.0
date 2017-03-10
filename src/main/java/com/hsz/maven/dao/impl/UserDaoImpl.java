package com.hsz.maven.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hsz.maven.dao.UserDao;
import com.hsz.maven.model.User;
import com.hsz.maven.utils.MyHibernateDaoSupport;

@Repository("userDao")
@Transactional
public class UserDaoImpl extends MyHibernateDaoSupport implements UserDao{

	@Override
	public void addUser(User user) {
		getHibernateTemplate().save(user);
		
	}

	@Override
	public List<User> getAllUser() {
		
		return (List<User>) getHibernateTemplate().find("FROM User");
	}


	@Override
	public void deleteUserById(int user_id) {
		User user = (User) getHibernateTemplate().find("FROM User");
		getHibernateTemplate().delete(user);
	}

	@Override
	public void updateUser(User user) {
		getHibernateTemplate().update(user);
		
	}

	@Override
	public User getUserById(int user_id) {
		
		return (User) getHibernateTemplate().find("FROM User");
	}

	@Override
	public User getUserByName(String username) {
		List<User> users = (List<User>) getHibernateTemplate().find("FROM User WHERE username = ?",username);
		if(users != null && users.size() > 0){
			return users.get(0);
		}else{
			return null;
		}
	}

	@Override
	public User checkUser(User user) {
		List<User> users = (List<User>) getHibernateTemplate().find("FROM User WHERE username = ? and password = ?",user.getUsername(),user.getPassword());
		if(users != null && users.size() > 0){
			return users.get(0);
		}else{
			return null;
		}
	}

}
