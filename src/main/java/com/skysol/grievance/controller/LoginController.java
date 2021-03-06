package com.skysol.grievance.controller;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.skysol.grievance.model.User;
import com.skysol.grievance.model.mongo.UserRepo;
import com.skysol.grievance.service.UserService;
import com.skysol.grievance.utilities.StringUtils;

@Controller
public class LoginController {
	
	final static Logger logger = Logger.getLogger(LoginController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/")
	public ModelAndView loginPage(){
		if(logger.isInfoEnabled()){
			logger.info("=== login requested ===" );
		}
		return new ModelAndView("login");
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginPage(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		if(logger.isInfoEnabled()){
			logger.info("=== loginPage started LoginController ===" );
		}
		String username=request.getParameter("username");
		String password=request.getParameter("password");
//		username="skysol";
//		password="sky1234";
		ModelAndView model = null;
		User user = null;
		try {
			if(StringUtils.isValidString(username)  
					&&  StringUtils.isValidString(password)){
				user = userService.findByUser(username);
				if(user != null){
					if(username.equalsIgnoreCase(user.getUsername())
							&& password.equalsIgnoreCase(user.getPassword())){
						UserRepo userRepo = new UserRepo();
						userRepo.setId(user.getId());
						userRepo.setUsername(user.getUsername());
						userRepo.setEmailAddress(user.getEmailAddress());
						userService.addUser(userRepo);
						model = new ModelAndView("grievancepage");
						model.addObject("user", user);
					}else{
						model = new ModelAndView("error");
						model.addObject("errMsg", "Invalid User!!");
					}
				}else{
					model = new ModelAndView("error");
					model.addObject("errMsg", "User Not Found!!");
				}
				
			}else{
				model = new ModelAndView("error");
				model.addObject("errMsg", "Username and Password should not be empty!!");
			}
		} catch (Exception e) {
			logger.error("Exception occured==", e);
			model = new ModelAndView("error");
			model.addObject("errMsg", e.getMessage());
		}
		
		if(logger.isInfoEnabled()){
			logger.info("=== End of login method in LoginController ===" );
		}
		return model;
		
	}
	
	@RequestMapping(value="/index")
	public ModelAndView loadIndex(){
		if(logger.isInfoEnabled()){
			logger.info("=== load Submit Appeal page===" );
		}
		return new ModelAndView("index");
	}
	
	/*@RequestMapping(value="/track")
	public ModelAndView loadAllAppeals(){
		if(logger.isInfoEnabled()){
			logger.info("=== load Track Appeal page ===" );
		}
		return new ModelAndView("index");
	}*/
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
		if(logger.isInfoEnabled()){
			logger.info("=== logout requested ===" );
		}
		userService.addUser(null);
		return "login";
	}
	
	@RequestMapping(value="/findAllUsers", method = RequestMethod.GET)
	public ResponseEntity<List<UserRepo>> findAllUsers (HttpServletRequest request, HttpServletResponse response) {
		if(logger.isInfoEnabled()){
			logger.info("=== logout requested ===" );
		}
		List<UserRepo> users = null;
		try {
			users = userService.getAllUsers();
			for (UserRepo user : users) {
				if(logger.isInfoEnabled()){
					logger.info("=== user name ===" + user.getUsername());
					logger.info("=== password ===" + user.getPassword());
					logger.info("=== email id ===" + user.getEmailAddress());
				}
			}
		} catch (Exception e) {
			logger.error("Exception occured while calling getUser ==", e);
			ModelAndView model = new ModelAndView("error");
			model.addObject("errMsg", "Please Configuare and Run Mongo DB!!");
		}
		return new ResponseEntity<List<UserRepo>>(users, HttpStatus.OK);
	}
	
	@PostConstruct
	public void initIt() throws Exception {
		if(logger.isInfoEnabled()){
			logger.info("=== initIt method ===" );
		}
		// mongodb services sample calling code 
		/*try {
			userService.saveUser();
			List<UserRepo> users = userService.getUser();
			for (UserRepo user : users) {
				if(logger.isInfoEnabled()){
					logger.info("=== user name ===" + user.getUsername());
					logger.info("=== password ===" + user.getPassword());
					logger.info("=== email id ===" + user.getEmailAddress());
				}
			}
		} catch (Exception e) {
			logger.error("Exception occured while saving or retrving user details in to Mongodb==", e);
		}*/
		
	}
	
	@PreDestroy
	public void cleanUp() throws Exception {
		if(logger.isInfoEnabled()){
			logger.info("=== cleanup method ===" );
		}
	}
}
