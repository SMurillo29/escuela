package com.escuela.escuela.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escuela.escuela.DAO.IEstudianteDao;
import com.escuela.escuela.model.Estudiante;

@RequestMapping("/Estudiantes")
@RestController
public class RestEstudianteController {

	@Autowired
	IEstudianteDao repo;

	@GetMapping("/listar")
	public List<Estudiante> listar() {

		return repo.findAll();
	}

	@PostMapping("/insertar")
	public void insertar(@RequestBody Estudiante E) {

		repo.save(E);
	}

	@PutMapping("/modificar")
	public void modificar(@RequestBody Estudiante E) {

		repo.save(E);
	}

	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable("id") Integer i) {
		repo.deleteById(i);

	}

}
