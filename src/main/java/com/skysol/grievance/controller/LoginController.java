package com.skysol.grievance.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.skysol.grievance.constants.ErrorConstants;
import com.skysol.grievance.exception.CustomGenericException;

@Controller
public class LoginController {

	@RequestMapping(value="/")
	public ModelAndView loginPage(){
		return new ModelAndView("login");
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginPage(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		//ModelMap model, - request param
		String username=request.getParameter("ssoId");
		String password=request.getParameter("password");
		ModelAndView model = new ModelAndView("welcome");
		
		if(username.length() > 4){
			model.addObject("user", username);
			return model;
		}else{
			/*model = new ModelAndView("genericerror");
			model.addObject("errCode", ErrorConstants.ERR_001);*/
//			model.addObject("errMsg", "Invalid Username or Password!!");
			throw new CustomGenericException(ErrorConstants.ERR_001, "This is custom message");
		}
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
		return "login";
	}

}
