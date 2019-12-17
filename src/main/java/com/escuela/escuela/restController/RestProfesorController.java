package com.escuela.escuela.restController;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escuela.escuela.DAO.ICursoDao;
import com.escuela.escuela.DAO.IProfesorDao;
import com.escuela.escuela.model.Curso;
import com.escuela.escuela.model.PeticionDTO;
import com.escuela.escuela.model.Profesor;
import com.escuela.escuela.services.Issuccess;

@RequestMapping("/profesores")
@RestController
public class RestProfesorController {


	private BCryptPasswordEncoder encoder;

	@Autowired
	private IProfesorDao repo;
	
	@Autowired
	private ICursoDao  repocur;
	
	

	@GetMapping("/listar")
	public List<Profesor> listar() {

		return repo.findAll();
	}

	@PostMapping("/insertar")
	public Issuccess insertar(@RequestBody Profesor P) {
		
	 P.setPassword(encoder.encode(P.getPassword()));
		

		repo.save(P);
		
		return new Issuccess(true, "registro registrado exitosamente");
	}
	
	@PostMapping("/rcurso")
	public void insertarCurso(@RequestBody PeticionDTO peticion) {
		Profesor pro = new Profesor();
		Curso  cur = new Curso();
		pro=repo.findByCorreo(peticion.getEmailPro());	
		cur=repocur.findByNombre(peticion.getNombreCurso());
		
		Set<Curso> cursos = new HashSet<Curso>();
		cursos.add(cur);
		pro.setCursos(cursos);
		
		repo.save(pro);
		
		
	}

	@PutMapping("/modificar")
	public void modificar(@RequestBody Profesor P) {

		repo.save(P);
	}

	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable("id") Integer i) {
		repo.deleteById(i);

	}

}
