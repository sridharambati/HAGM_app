package com.skysol.grievance.config;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages="com.skysol.grievance")
@EnableWebMvc
@Import({ SecurityConfiguration.class })
public class MvcConfiguration extends WebMvcConfigurerAdapter{
	final static Logger logger = Logger.getLogger(MvcConfiguration.class);

	@Bean
	public ViewResolver getViewResolver(){
		if(logger.isInfoEnabled()){
			logger.info("=== MvcConfiguration ViewResolver ===" );
		}
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		if(logger.isInfoEnabled()){
			logger.info("=== MvcConfiguration addResourceHandlers ===" );
		}
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
		registry.addResourceHandler("/static/**").addResourceLocations("/static/");
	}
	
}
