package com.skysol.grievance.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.skysol.grievance.exception.CustomGenericException;

@ControllerAdvice
public abstract class GlobalExceptionController {

	@ExceptionHandler(CustomGenericException.class)
	public ModelAndView handleCustomException(CustomGenericException ex) {

		ModelAndView model = new ModelAndView("genericerror");
		model.addObject("errCode", ex.getErrCode());
		model.addObject("errMsg", ex.getErrMsg());
		/*ModelMap model = new ModelMap();
		model.addAttribute("errCode", ex.getErrCode());
		model.addAttribute("errMsg", ex.getErrMsg());
		return "login";*/
		return model;
	}

	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllException(Exception ex) {

		ModelAndView model = new ModelAndView("error");
		model.addObject("errMsg", "this is Exception.class");
//		ModelMap model = new ModelMap();
		/*model.addAttribute("errMsg", "this is Exception.class");
		return "login";*/
		return model;
	}
	
}