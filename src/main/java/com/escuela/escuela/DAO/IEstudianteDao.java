package com.escuela.escuela.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escuela.escuela.model.Estudiante;

public interface IEstudianteDao extends JpaRepository<Estudiante, Integer>{

}
