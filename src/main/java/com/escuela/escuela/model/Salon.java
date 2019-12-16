package com.escuela.escuela.model;

//import java.util.Set;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.OneToMany;

@Entity
public class Salon {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "bloque",length = 1)	
	private String bloque;
	@Column(name = "numero",length = 4)	
	private Integer numero;	
	
	
//	@OneToMany(targetEntity = Curso.class)
//	@Column(name = "curso")
//	private Set<Curso> cursos;
//	
	
	public Salon() {
		
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getBloque() {
		return bloque;
	}


	public void setBloque(String bloque) {
		this.bloque = bloque;
	}


	public Integer getNumero() {
		return numero;
	}


	public void setNumero(Integer numero) {
		this.numero = numero;
	}


//	public Set<Curso> getCursos() {
//		return cursos;
//	}
//
//
//	public void setCursos(Set<Curso> cursos) {
//		this.cursos = cursos;
//	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bloque == null) ? 0 : bloque.hashCode());
		//result = prime * result + ((cursos == null) ? 0 : cursos.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Salon other = (Salon) obj;
		if (bloque == null) {
			if (other.bloque != null)
				return false;
		} else if (!bloque.equals(other.bloque))
			return false;
//		if (cursos == null) {
//			if (other.cursos != null)
//				return false;
//		} else if (!cursos.equals(other.cursos))
//			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}
	
	
	
	
}
