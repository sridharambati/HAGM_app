package com.skysol.grievance.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.skysol.grievance.model.User;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

	public User findById(int id) {
		return getByKey(id);
	}

	public User findByUser(String userName) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("username", userName));
		User user= (User) crit.uniqueResult();
		return user;
	}

	
}
