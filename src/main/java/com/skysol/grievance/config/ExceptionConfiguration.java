package com.skysol.grievance.config;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages="com.skysol.grievance")
@EnableWebMvc
public class ExceptionConfiguration extends WebMvcConfigurerAdapter{

		final static Logger logger = Logger.getLogger(ExceptionConfiguration.class);

		@Bean
	    public SimpleMappingExceptionResolver createSimpleMappingExceptionResolver() {
			if(logger.isInfoEnabled()){
				logger.info("=== createSimpleMappingExceptionResolver method starts ===" );
			}
			SimpleMappingExceptionResolver r =
	              new SimpleMappingExceptionResolver();

	        Properties mappings = new Properties();
	        mappings.setProperty("CustomGenericException", "error");

	        r.setExceptionMappings(mappings);  // None by default
	        r.setDefaultErrorView("error");    // No default
	        r.setExceptionAttribute("ex");     // Default is "exception"
//	        r.setWarnLogCategory("example.MvcLogger");     // No default
	        if(logger.isInfoEnabled()){
				logger.info("=== createSimpleMappingExceptionResolver method Ends ===" );
			}
	        return r;
	    }
	
}
