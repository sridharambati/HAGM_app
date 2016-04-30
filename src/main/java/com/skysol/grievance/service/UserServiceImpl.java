package com.skysol.grievance.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skysol.grievance.dao.UserDao;
import com.skysol.grievance.dao.UserDaoImpl;
import com.skysol.grievance.model.User;

@Service("userService")
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
	
	public User findByUserName(String userName) {
		if(logger.isInfoEnabled()){
			logger.info("=== UserServiceImpl findByUser ===" );
		}
		return dao.findByUser(userName);
	}
	
	public boolean saveUser(){
		if(logger.isInfoEnabled()){
			logger.info("=== UserServiceImpl saveUser start===" );
		}
		User user = null;
		try{
			user = new User();
			user.setId(new Integer(1));
			user.setUsername("skysol");
			user.setPassword("sky1234");
			user.setEmailAddress("hr@skysolinc.com");
			dao.saveUser(user);
		}catch(Exception ex){
			if(logger.isInfoEnabled()){
				logger.info("=== UserDaoImpl saveUser ===",ex );
			}
		}
		return true;
	}
	
	public List<User> getUser(){
		if(logger.isInfoEnabled()){
			logger.info("=== UserDaoImpl getUser start ===");
		}
		List<User> user=null;
		try{
			 user=dao.getUser();
		}catch(Exception ex){
			if(logger.isInfoEnabled()){
				logger.info("=== UserDaoImpl getUser ===",ex );
			}
		}
		return user;
	}

	

}
