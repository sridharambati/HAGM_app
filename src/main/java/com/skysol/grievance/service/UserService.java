package com.skysol.grievance.service;

import java.util.List;

import com.skysol.grievance.model.User;
import com.skysol.grievance.model.mongo.UserRepo;

public interface UserService {

	public User findById(int id);
	
	public User findByUser(String userName);
	
	public User findByUserName(String userName);
	
	public boolean saveUser();
	
	public List<UserRepo> getUser();
	
	
}