package com.skysol.grievance.controller;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
		return new ModelAndView("UserManagement");
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginPage(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		if(logger.isInfoEnabled()){
			logger.info("=== loginPage started LoginController ===" );
		}
		String username=request.getParameter("username");
		String password=request.getParameter("password");
//		String username="skysol";
//		String password="sky1234";
		ModelAndView model = null;
		User user = null;
		try {
			if(StringUtils.isValidString(username)  
					&&  StringUtils.isValidString(password)){
				user = userService.findByUser(username);
				if(user != null){
					if(username.equalsIgnoreCase(user.getUsername())
							&& password.equalsIgnoreCase(user.getPassword())){
						model = new ModelAndView("welcome");
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
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
		if(logger.isInfoEnabled()){
			logger.info("=== logout requested ===" );
		}
		return "login";
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
