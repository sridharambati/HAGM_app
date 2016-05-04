package com.skysol.grievance.dao;

import java.util.List;

import com.skysol.grievance.model.User;
import com.skysol.grievance.model.mongo.Grievance;
import com.skysol.grievance.model.mongo.UserRepo;

public interface GrievanceDao {

	public List<Grievance> getAllAppealsByUser(UserRepo user);
	
	public void saveGrievance(Grievance grievance) throws Exception;
	
}

