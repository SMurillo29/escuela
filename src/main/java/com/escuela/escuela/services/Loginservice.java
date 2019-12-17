package com.escuela.escuela.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.escuela.escuela.DAO.IProfesorDao;
import com.escuela.escuela.model.Profesor;

@Service
public class Loginservice implements UserDetailsService{
	
	@Autowired
	IProfesorDao prorepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Profesor profesor = new Profesor();
		profesor = prorepo.findByCorreo(username);
		UserDetails usuarioDetalle = new UserDetails(profesor.getCorreo(),profesor.getPassword());
		
		return null;
	}

}
