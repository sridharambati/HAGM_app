package com.skysol.grievance.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skysol.grievance.dao.UserDao;
import com.skysol.grievance.dao.UserDaoImpl;
import com.skysol.grievance.model.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

	final static Logger logger = Logger.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserDao dao;

	public User findById(int id) {
		if(logger.isInfoEnabled()){
			logger.info("=== UserServiceImpl findById ===" );
		}
		return dao.findById(id);
	}

	public User findByUser(String userName) {
		if(logger.isInfoEnabled()){
			logger.info("=== UserServiceImpl findByUser ===" );
		}
		return dao.findByUser(userName);
	}

}
