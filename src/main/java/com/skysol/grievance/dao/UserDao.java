package com.skysol.grievance.dao;

import java.util.List;

import com.skysol.grievance.model.User;
import com.skysol.grievance.model.mongo.UserRepo;

public interface UserDao {

	public User findById(int id);
	
	public User findByUser(String sso);
	
	public boolean saveUser(UserRepo user);
	
	public List<UserRepo> getUser();
	
}

