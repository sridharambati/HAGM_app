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
	
	public void saveGrievance() throws Exception{
		if(logger.isInfoEnabled()){
			logger.info("=== GrievanceServiceImpl saveGrievance start ===");
		}
		Grievance grievance  = new Grievance();
		grievance.setMemberId(new Integer(11111));
		grievance.setMemberSSN(new Long(1231231234));
		grievance.setMemberName("skysol");
		grievance.setInsuranceType("Full Coverage");
		grievance.setGrievanceType("Complaint");
		grievance.setRequestedDate(new Date());
		grievance.setStatus("Requested");
		grievance.setUser(userService.getUser());
		grievanceDao.saveGrievance(grievance);
		if(logger.isInfoEnabled()){
			logger.info("=== GrievanceServiceImpl saveGrievance end ===" );
		}
	}

	

}
