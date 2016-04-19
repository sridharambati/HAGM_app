package com.skysol.grievance.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.skysol.grievance.constants.ErrorConstants;
import com.skysol.grievance.exception.CustomGenericException;
import com.skysol.grievance.model.User;
import com.skysol.grievance.service.UserService;
import com.skysol.grievance.utilities.StringUtils;

@Controller
public class LoginController {
	
	final static Logger logger = Logger.getLogger(LoginController.class);
	
	@Autowired
	private UserService userService;

	/*@RequestMapping(value="/")
	public String loginPage(){
		if(logger.isDebugEnabled()){
			logger.debug("=== login requested ===");
		}
		return "redirect:/loginPage";
	}*/
	
	@RequestMapping(value="/", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView login(){
		if(logger.isDebugEnabled()){
			logger.debug("=== login requested ===");
		}
		return new ModelAndView("login");
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginPage(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		if(logger.isInfoEnabled()){
			logger.info("=== loginPage started ===" );
		}
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		ModelAndView model = null;
		User user = null;
		try {
			if(StringUtils.isValidString(username) 
					&& StringUtils.isValidString(password)){
				user = userService.findByUser(username);
				if(user != null){
					if(username.equalsIgnoreCase(user.getUsername())
							&& password.equalsIgnoreCase(user.getPassword())){
						model = new ModelAndView("welcome");
						model.addObject("user", user);
					}else{
//						throw new CustomGenericException(ErrorConstants.ERR_001, "Invalid User!!");
						model = new ModelAndView("error");
						model.addObject("errMsg", "Invalid User!!");
					}
				}else{
//					throw new CustomGenericException(ErrorConstants.ERR_001, "User Not Found!!");
					model = new ModelAndView("error");
					model.addObject("errMsg", "User Not Found!!");
				}
				
			}else{
//				throw new CustomGenericException(ErrorConstants.ERR_002, "This is custom message");
				model = new ModelAndView("error");
				model.addObject("errMsg", "Username and Password should not empty!!");
			}
		} catch (Exception e) {
			logger.error("Exception occured==", e);
			model = new ModelAndView("error");
			model.addObject("errMsg", e.getMessage());
//			throw new CustomGenericException(ErrorConstants.ERR_003, "This is System Error");
		}
		return model;
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
		return "login";
	}

}
