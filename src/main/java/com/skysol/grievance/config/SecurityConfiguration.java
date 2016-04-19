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
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		if(logger.isDebugEnabled()){
			logger.debug("=== SecurityConfiguration configureGlobal ===");
		}
		auth.inMemoryAuthentication()
		.withUser("skysol").password("123456").roles("USER");
		
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		if(logger.isDebugEnabled()){
			logger.debug("=== SecurityConfiguration configure ===");
		}
		httpSecurity
		.formLogin().loginPage("/login")
        .usernameParameter("username").passwordParameter("password")
        .and()
        .authorizeRequests()
//        .antMatchers("/").permitAll()
       // .anyRequest().hasRole("USER");
		.antMatchers(HttpMethod.POST,"/login").access("hasRole('USER')");
//		.antMatchers("/").permitAll()
		//.anyRequest().authenticated()
             
           // .and().logout();
       // .and().csrf();
		
		/*httpSecurity.requiresChannel().anyRequest().requiresSecure()
		.and().authorizeRequests()
		.antMatchers("/auth/**", "/login", "/signup", "/forgotPassword").permitAll()
		.anyRequest().hasAnyRole("ANONYMOUS, USER");*/
             
	}
}
