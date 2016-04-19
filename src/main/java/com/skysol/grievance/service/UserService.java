package com.skysol.grievance.service;

import com.skysol.grievance.model.User;

public interface UserService {

	User findById(int id);
	
	User findByUser(String userName);
	
}