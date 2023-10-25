package com.microservices.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Modulee {
	@Id
	private String codeM;
	private String nomM,niveau,semestre;




	public Modulee(String codeM, String nomM, String niveau, String semestre) {
		super();
		this.codeM = codeM;
		this.nomM = nomM;
		this.niveau = niveau;
		this.semestre = semestre;
	}


	public Modulee() {
		super();
	}





	public String getCodeM() {
		return codeM;
	}
	public void setCodeM(String codeM) {
		this.codeM = codeM;
	}
	public String getNomM() {
		return nomM;
	}
	public void setNomM(String nomM) {
		this.nomM = nomM;
	}
	public String getNiveau() {
		return niveau;
	}
	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}


	public String getSemestre() {
		return semestre;
	}


	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}


}
