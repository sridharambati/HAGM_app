package com.skysol.grievance.config;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Component;

import com.skysol.grievance.controller.LoginController;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	final static Logger logger = Logger.getLogger(SecurityConfiguration.class);
	
	@Autowired
    CustomSuccessHandler customSuccessHandler;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		if(logger.isDebugEnabled()){
			logger.debug("=== SecurityConfiguration configureGlobal Starts ===");
		}
		auth.inMemoryAuthentication()
		.withUser("skysol").password("123456").roles("USER");
		
		if(logger.isDebugEnabled()){
			logger.debug("=== SecurityConfiguration configureGlobal Ends ===");
		}
		
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		if(logger.isDebugEnabled()){
			logger.debug("=== SecurityConfiguration configure Starts ===");
		}
		httpSecurity
		.authorizeRequests()
		//.antMatchers("/login*").access("hasRole('USER')")
		.antMatchers("/").permitAll()
		 .and()
		.formLogin().loginPage("/login").successHandler(customSuccessHandler)
        .usernameParameter("username").passwordParameter("password")
		.and().csrf();
        //.and().exceptionHandling().accessDeniedPage("/Access_Denied");
		if(logger.isDebugEnabled()){
			logger.debug("=== SecurityConfiguration configure Ends ===");
		}
	}
}
