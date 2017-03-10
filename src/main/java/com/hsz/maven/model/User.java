package com.hsz.maven.model;
/**
 * 用户
 * @author scxh
 *
 */
public class User {

	private int user_id;
	private String username; // 用户名称
	private String password; // 用户密码
	private int state; //
	private Role role; // 多端持有一端集合
	
	public User() {
		
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public User(String username, String password, int state) {
		
		this.username = username;
		this.password = password;
		this.state = state;
		
	}

	public User(int user_id, String username, String password, int state,Role role) {
		
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.state = state;
		this.role = role;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", username=" + username + ", password=" + password + ", state=" + state
				+  "]";
	}

}
