package com.skysol.grievance.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.skysol.grievance.model.mongo.Grievance;
import com.skysol.grievance.model.mongo.UserRepo;

@Repository("grivanceDao")
public class GrievanceDaoImpl extends AbstractDao<Integer, Grievance> implements GrievanceDao {

	final static Logger logger = Logger.getLogger(GrievanceDaoImpl.class);
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public List<Grievance> getAllAppealsByUser(UserRepo user){
		if(logger.isInfoEnabled()){
			logger.info("=== GrievanceDaoImpl getAllAppealsByUser start ===");
		}
		List<Grievance> grievances=null;
		try{
			Query query = new Query();
			query.addCriteria(Criteria.where("user.username").is(user.getUsername()));
			grievances = mongoTemplate.find(query, Grievance.class);
			logger.info("query - " + query.toString());
		}catch(Exception ex){
			if(logger.isInfoEnabled()){
				logger.info("=== GrievanceDaoImpl getAllAppealsByUser ===",ex );
			}
		}
		if(logger.isInfoEnabled()){
			logger.info("=== GrievanceDaoImpl getAllAppealsByUser end ===");
		}
		return grievances;
	}
	
	public void saveGrievance(Grievance grievance) throws Exception{
		if(logger.isInfoEnabled()){
			logger.info("=== GrievanceDaoImpl saveGrievance start ===");
		}
		mongoTemplate.save(grievance);
		if(logger.isInfoEnabled()){
			logger.info("Grievance and User data saved successfully!!");
			logger.info("=== GrievanceDaoImpl saveGrievance end ===");
		}
	}
	
}
