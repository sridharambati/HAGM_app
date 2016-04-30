package com.skysol.grievance.config;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringMvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	final static Logger logger = Logger.getLogger(SpringMvcInitializer.class);

	@Override
	protected Class<?>[] getRootConfigClasses() {
		if(logger.isInfoEnabled()){
			logger.info("=== SpringMvcInitializer getRootConfigClasses ===" );
		}
		return new Class[] { MvcConfiguration.class, MongodbConfiguration.class};
	}
 
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}
 
	@Override
	protected String[] getServletMappings() {
		if(logger.isInfoEnabled()){
			logger.info("=== SpringMvcInitializer getServletMappings ===" );
		}
		return new String[] { "/" };
	}

}
