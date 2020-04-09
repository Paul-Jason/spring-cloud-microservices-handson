package com.paulorg.photoapp.api.users.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

//	private Environment environment;
//	//Constructor based autowiring
//	@Autowired
//	public WebSecurity(Environment environment) {
//		this.environment = environment;
//	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//since we are going to use JWT we disable this.
		http.csrf().disable(); 
		http.authorizeRequests().antMatchers("/users/**").permitAll();
		
		//To permit urls only from particular ip address
//		http.authorizeRequests().antMatchers("/**")
//			.hasIpAddress(environment.getProperty("gateway.ip"));
	}

}
