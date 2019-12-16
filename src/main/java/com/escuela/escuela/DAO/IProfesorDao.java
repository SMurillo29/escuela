package com.escuela.escuela.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escuela.escuela.model.Profesor;

public interface IProfesorDao extends JpaRepository<Profesor, Integer>{
	
	Profesor findByCorreo(String correo);
	
}
