package com.skysol.grievance.service;

import java.util.List;

import com.skysol.grievance.model.mongo.Grievance;

public interface GrievanceService {

	public List<Grievance> getAllAppealsByUser();
	
	public void saveGrievance(Grievance grievance) throws Exception;
	
}