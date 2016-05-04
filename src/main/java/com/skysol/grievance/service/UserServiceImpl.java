package com.skysol.grievance.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skysol.grievance.dao.UserDao;
import com.skysol.grievance.model.User;
import com.skysol.grievance.model.mongo.UserRepo;

@Service("userService")
@Scope(value="session", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional
public class UserServiceImpl implements UserService{

	final static Logger logger = Logger.getLogger(UserServiceImpl.class);
	
	private UserRepo user;
	
	@Autowired
	private UserDao dao;

	public void addUser(UserRepo user){
		setUser(user);
	}
	
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
		UserRepo user = null;
		try{
			user = new UserRepo();
//			user.setId(new AtomicLong().incrementAndGet());
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
	
	public List<UserRepo> getAllUsers(){
		if(logger.isInfoEnabled()){
			logger.info("=== UserDaoImpl getUser start ===");
		}
		List<UserRepo> user=null;
		try{
			 user=dao.getUser();
		}catch(Exception ex){
			if(logger.isInfoEnabled()){
				logger.info("=== UserDaoImpl getUser ===",ex );
			}
		}
		return user;
	}

	public UserRepo getUser() {
		return user;
	}

	public void setUser(UserRepo user) {
		this.user = user;
	}

	
}
