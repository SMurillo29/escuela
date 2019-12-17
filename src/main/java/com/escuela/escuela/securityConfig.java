package com.escuela.escuela;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

import com.escuela.escuela.services.Loginservice;

@Configuration
@EnableWebSecurity
public class securityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	@Autowired
	private Loginservice userDetailsService;
	
	
	
	@Bean
	public BCryptPasswordEncoder PassEncoder() {	
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();	
		
		return encoder; 		
	}
	
	

	public void addViewController(ViewControllerRegistry registro) {
		registro.addViewController("/profesores").setViewName("profesores");
		registro.addViewController("/estudiantes").setViewName("estudiantes");
		registro.addViewController("/cursos").setViewName("cursos");
		registro.addViewController("/salones").setViewName("salones");	
		
		
	}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bcrypt);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
		.authorizeRequests()
			.antMatchers("/","/profesores/insertar").permitAll().anyRequest().authenticated()
			.and().formLogin().permitAll().and().logout().permitAll();
	}
		
	

}
