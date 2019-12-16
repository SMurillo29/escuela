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

import com.escuela.escuela.DAO.ICursoDao;
import com.escuela.escuela.DAO.ISalonDao;
import com.escuela.escuela.model.Curso;
import com.escuela.escuela.model.PeticionDTO;
import com.escuela.escuela.model.Salon;

@RestController
@RequestMapping("/cursos")
public class RestCursoController {

	@Autowired
	ICursoDao repo;
	@Autowired
	ISalonDao srepo;

	@GetMapping("/listar")
	public List<Curso> listar() {

		return repo.findAll();
	}

	@PostMapping("/insertar")
	public void insertar(@RequestBody Curso c) {

		repo.save(c);
	}
	
	
	@PostMapping("/salon")
	public void nuevo_salon(@RequestBody PeticionDTO dto) {
		Curso curso = new Curso();
		Salon salon = new Salon();
		
		
		curso= repo.findByNombre(dto.getNombreCurso());
		salon= srepo.findByNumero(dto.getNumSalon());
		
		curso.setSalon(salon);
		repo.save(curso);
	}

	@PutMapping("/modificar")
	public void modificar(@RequestBody Curso c) {

		repo.save(c);
	}

	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable("id") Integer i) {
		repo.deleteById(i);

	}

}
