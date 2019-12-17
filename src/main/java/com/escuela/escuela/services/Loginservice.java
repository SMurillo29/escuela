package com.escuela.escuela.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
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
		
		List<GrantedAuthority> roles = new ArrayList<>();
		roles.add(new SimpleGrantedAuthority("ADMIN"));
		UserDetails usuarioDetalle = new User(profesor.getCorreo(),profesor.getPassword(),roles);
		
		return usuarioDetalle;
	}

}
