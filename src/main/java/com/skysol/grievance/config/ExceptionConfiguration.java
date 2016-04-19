package com.skysol.grievance.config;

import java.util.Properties;

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

	
	

	/*@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
	    configurer.enable();
	}*/
	
//	 	@Bean(name="simpleMappingExceptionResolver")
		@Bean
	    public SimpleMappingExceptionResolver createSimpleMappingExceptionResolver() {
	        SimpleMappingExceptionResolver r =
	              new SimpleMappingExceptionResolver();

	        Properties mappings = new Properties();
	        mappings.setProperty("CustomGenericException", "error");

	        r.setExceptionMappings(mappings);  // None by default
	        r.setDefaultErrorView("error");    // No default
	        r.setExceptionAttribute("ex");     // Default is "exception"
//	        r.setWarnLogCategory("example.MvcLogger");     // No default
	        return r;
	    }
	
}
