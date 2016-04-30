package com.skysol.grievance.dao;

import java.util.List;

import com.skysol.grievance.model.User;

public interface UserDao {

	public User findById(int id);
	
	public User findByUser(String sso);
	
	public User findByUserName(String userName);
	
	public boolean saveUser(User user);
	
	public List<User> getUser();
	
}

