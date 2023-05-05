package com.nagarro.initializer.entities;

public class User {
	int userId;
	String password;

	public int getUserId() {
		return userId;
	}

	public void setUsername(int userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User(int userId, String password) {
		this.userId = userId;
		this.password = password;
	}

	public User() {
	}

	@Override
	public String toString() {
		return "User [User id=" + userId + ", password=" + password + "]";
	}

}
