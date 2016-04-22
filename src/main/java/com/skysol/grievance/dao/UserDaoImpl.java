package com.skysol.grievance.dao;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.skysol.grievance.config.SecurityConfiguration;
import com.skysol.grievance.model.User;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

	final static Logger logger = Logger.getLogger(UserDaoImpl.class);
	
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

	
}
