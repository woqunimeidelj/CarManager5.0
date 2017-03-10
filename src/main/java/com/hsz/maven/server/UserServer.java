package com.hsz.maven.server;

import java.util.List;

import com.hsz.maven.model.User;

public interface UserServer {
	
	public boolean registerUser(User user); // 注册
	public User login(User user); // 登录
	public void verifyUser(User user,int role_id); // 审核
	
	//====================用户管理操作================//
	
	public void addUser(User user); // 添加用户
	public List<User> getAllUser(); // 显示所有用户
	public User getUserById(int user_id); // 根据ID查询
	public void deleteUserById(int user_id); // 根据ID删除
	public void updateUser(User user); // 修改用户
}
