package com.escuela.escuela.model;

public class PeticionDTO {
	private String nombreCurso;
	private String emailPro;
	private Integer numSalon;

	public PeticionDTO() {

	}

	public String getNombreCurso() {
		return nombreCurso;
	}

	public void setNombreCurso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
	}

	public String getEmailPro() {
		return emailPro;
	}

	public void setEmailPro(String emailPro) {
		this.emailPro = emailPro;
	}

	public Integer getNumSalon() {
		return numSalon;
	}

	public void setNumSalon(Integer codSalon) {
		this.numSalon = codSalon;
	}

}
