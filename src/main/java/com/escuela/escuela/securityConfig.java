package com.escuela.escuela;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class securityConfig extends WebSecurityConfigurerAdapter{
	
	@Bean
	public BCryptPasswordEncoder encoder() {		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();		
		return encoder; 		
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bcrypt);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
		.authorizeRequests()
			.anyRequest().authenticated()
			.and()
		.formLogin().and()
		.httpBasic();
	
		
	

}
