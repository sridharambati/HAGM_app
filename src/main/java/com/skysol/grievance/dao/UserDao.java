package com.skysol.grievance.dao;

import com.skysol.grievance.model.User;

public interface UserDao {

	User findById(int id);
	
	User findByUser(String sso);
	
}

