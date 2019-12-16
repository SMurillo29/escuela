package com.escuela.escuela.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escuela.escuela.model.Curso;

public interface ICursoDao extends JpaRepository<Curso, Integer>{
	Curso findByNombre(String nombre);

}
