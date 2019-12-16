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

import com.escuela.escuela.DAO.ISalonDao;
import com.escuela.escuela.model.Salon;

@RequestMapping("/salones")
@RestController
public class RestSalonController {

	@Autowired
	ISalonDao repo;

	@GetMapping("/listar")
	public List<Salon> listar() {

		return repo.findAll();
	}

	@PostMapping("/insertar")
	public void insertar(@RequestBody Salon S) {

		repo.save(S);
	}

	@PutMapping("/modificar")
	public void modificar(@RequestBody Salon S) {

		repo.save(S);
	}

	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable("id") Integer i) {
		repo.deleteById(i);

	}

}
