package com.escuela.escuela.restController;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import com.escuela.escuela.DAO.IEstudianteDao;
import com.escuela.escuela.model.Curso;
import com.escuela.escuela.model.Estudiante;
import com.escuela.escuela.model.PeticionDTO;

@RequestMapping("/estudiantes")
@RestController
public class RestEstudianteController {

	@Autowired
	IEstudianteDao repo;
	
	@Autowired
	ICursoDao repoCurso;

	@GetMapping("/listar")
	public List<Estudiante> listar() {

		return repo.findAll();
	}

	@PostMapping("/insertar")
	public void insertar(@RequestBody Estudiante E) {

		repo.save(E);
	}
	
	@PostMapping("/materias")
	public void materias(@RequestBody PeticionDTO dto) {
		Estudiante est= new Estudiante();
		Curso cur = new Curso();
		
		est = repo.findByDocumento(dto.getDocEstudiante());
		cur = repoCurso.findByNombre(dto.getNombreCurso());
		
		Set<Curso> cursos = new HashSet<Curso>();
		cursos.add(cur);
		est.setCursos(cursos);
		
		repo.save(est);
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
