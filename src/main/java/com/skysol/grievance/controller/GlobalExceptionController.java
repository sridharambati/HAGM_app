package com.skysol.grievance.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.skysol.grievance.config.SpringMvcInitializer;
import com.skysol.grievance.exception.CustomGenericException;

@ControllerAdvice
public abstract class GlobalExceptionController {

	final static Logger logger = Logger.getLogger(GlobalExceptionController.class);

	@ExceptionHandler(CustomGenericException.class)
	public ModelAndView handleCustomException(CustomGenericException ex) {

		if(logger.isInfoEnabled()){
			logger.info("=== GlobalExceptionController handleCustomException ===" );
		}
		ModelAndView model = new ModelAndView("error");
		model.addObject("errCode", ex.getErrCode());
		model.addObject("errMsg", ex.getErrMsg());
		return model;
	}

	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllException(Exception ex) {

		if(logger.isInfoEnabled()){
			logger.info("=== GlobalExceptionController handleAllException ===" );
		}
		ModelAndView model = new ModelAndView("error");
		model.addObject("errMsg", "this is Exception.class");
		return model;
	}
	
}