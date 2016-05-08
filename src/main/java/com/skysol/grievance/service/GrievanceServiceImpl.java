package com.skysol.grievance.service;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skysol.grievance.dao.GrievanceDao;
import com.skysol.grievance.model.mongo.Grievance;
import com.skysol.grievance.model.mongo.UserRepo;

@Service("grievanceService")
@Transactional
public class GrievanceServiceImpl implements GrievanceService{

	final static Logger logger = Logger.getLogger(GrievanceServiceImpl.class);
	
	@Autowired
	private GrievanceDao grievanceDao;

	@Autowired
	private UserService userService;
	
	public List<Grievance> getAllAppealsByUser(){
		if(logger.isInfoEnabled()){
			logger.info("=== GrievanceServiceImpl getAllAppealsByUser start ===");
		}
		List<Grievance> appeals=null;
		UserRepo user = null;
		try{
			user = userService.getUser();
			if(user != null){
				appeals=grievanceDao.getAllAppealsByUser(userService.getUser());
			}
		}catch(Exception ex){
			if(logger.isInfoEnabled()){
				logger.info("=== UserDaoImpl getUser ===",ex );
			}
		}
		if(logger.isInfoEnabled()){
			logger.info("=== GrievanceServiceImpl getAllAppealsByUser end ===" );
		}
		return appeals;
	}
	
	public void saveGrievance(Grievance grievance) throws Exception{
		if(logger.isInfoEnabled()){
			logger.info("=== GrievanceServiceImpl saveGrievance start ===");
		}
		grievance.setStatus("Submitted");
		grievance.setUser(userService.getUser());
		grievanceDao.saveGrievance(grievance);
		if(logger.isInfoEnabled()){
			logger.info("=== GrievanceServiceImpl saveGrievance end ===" );
		}
	}

	

}
