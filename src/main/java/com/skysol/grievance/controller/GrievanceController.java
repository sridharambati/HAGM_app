package com.skysol.grievance.controller;


import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.skysol.grievance.model.mongo.Grievance;
import com.skysol.grievance.service.GrievanceService;

@Controller
@RequestMapping(value= "/grievance")
public class GrievanceController {
	
	final static Logger logger = Logger.getLogger(GrievanceController.class);
	
	@Autowired
	private GrievanceService grievanceService;
	
	@RequestMapping(value = "/submit", method = RequestMethod.POST)	
	public  @ResponseBody String submitGrievance(  )   {
		return "savegrievance";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)	
	public  @ResponseBody String saveGrievance(Model model, @ModelAttribute("grievance") Grievance grievance)   {
		if(logger.isInfoEnabled()){
			logger.info("=== GrievanceController saveGrievance start===" );
		}
//		ModelAndView model = null;
		try {
			grievanceService.saveGrievance();
		} catch (Exception e) {
			logger.error("Exception occured while saving grievance ==", e);
//			model = new ModelAndView("error");
			model.addAttribute("errMsg", "Exception occured while saving grievance!!");
		}
		if(logger.isInfoEnabled()){
			logger.info("=== GrievanceController saveGrievance end===" );
		}
		return "track";
	}
	
	@RequestMapping(value = "/track")
	public String showGrievancePage() {
		return "grievancepage";
	}
	
	@RequestMapping(value="/findAppealsByUser", method = RequestMethod.GET)
	public ResponseEntity<Map<String, List<Grievance>>> findAllAppealsByUser (HttpServletRequest request, HttpServletResponse response) {
		if(logger.isInfoEnabled()){
			logger.info("=== GrievanceController findAllAppealsByUser start ===" );
		}
		Map<String, List<Grievance>> grievances = null;
		List<Grievance> appeals = null;
		ModelAndView model = null;
		try {
			appeals = grievanceService.getAllAppealsByUser();
			if(appeals != null && appeals.size() > 0){
				grievances = new LinkedHashMap<>();
				grievances.put("grievances", appeals);
				for (Grievance appeal : appeals) {
					if(logger.isInfoEnabled()){
						logger.info("=== Member Name ===" + appeal.getMemberName());
						logger.info("=== Member SSN ===" + appeal.getMemberSSN());
						logger.info("=== uSER nAME ===" + appeal.getUser().getUsername());
					}
				}
			}else{
				model = new ModelAndView("error");
				model.addObject("errMsg", "There are no appeals found for this user!!");
			}
			
		} catch (Exception e) {
			logger.error("Exception occured while calling getUser ==", e);
			model = new ModelAndView("error");
			model.addObject("errMsg", "Please Configuare and Run Mongo DB!!");
		}
		if(logger.isInfoEnabled()){
			logger.info("=== GrievanceController findAllAppealsByUser end ===" );
		}
		return new ResponseEntity<Map<String, List<Grievance>>>(grievances, HttpStatus.OK);
	}

}
