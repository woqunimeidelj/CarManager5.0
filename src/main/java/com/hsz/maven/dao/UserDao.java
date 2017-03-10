package com.hsz.maven.dao;

import java.util.List;

import com.hsz.maven.model.User;
public interface UserDao {

	public void addUser(User user); // 添加用户
	public List<User> getAllUser(); // 显示所有用户
	public User getUserById(int user_id); // 根据ID查询
	public User getUserByName(String username); // 根据用户名查询
	public User checkUser(User user); // 审核登录
	public void deleteUserById(int user_id); // 根据ID删除
	public void updateUser(User user); // 修改用户
}
