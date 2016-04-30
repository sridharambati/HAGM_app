package com.skysol.grievance.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.skysol.grievance.model.User;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

	final static Logger logger = Logger.getLogger(UserDaoImpl.class);
	
	private static final String USER_COLLECTION = "user";
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public User findById(int id) {
		if(logger.isInfoEnabled()){
			logger.info("=== UserDaoImpl findById ===" );
		}
		return getByKey(id);
	}

	public User findByUser(String userName) {
		if(logger.isInfoEnabled()){
			logger.info("=== UserDaoImpl findByUser ===" );
		}
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("username", userName));
		User user= (User) crit.uniqueResult();
		return user;
	}
	
	public User findByUserName(String userName) {
		if(logger.isInfoEnabled()){
			logger.info("=== UserDaoImpl findByUserName ===" );
		}
		User user=null;
		
		return user;
	}
	
	public boolean saveUser(User user){
		try{
			mongoTemplate.insert(user,USER_COLLECTION);
			return true;
		}catch(Exception ex){
			if(logger.isInfoEnabled()){
				logger.info("=== UserDaoImpl saveUser ===",ex );
			}
			return false;
		}
	}
	
	public List<User> getUser(){
		List<User> user=null;
		try{
			 user=mongoTemplate.findAll(User.class, USER_COLLECTION);
		}catch(Exception ex){
			if(logger.isInfoEnabled()){
				logger.info("=== UserDaoImpl saveUser ===",ex );
			}
		}
		return user;
	}

	
}
