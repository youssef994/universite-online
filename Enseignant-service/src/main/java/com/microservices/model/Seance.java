package com.microservices.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;



@Entity
public class Seance {
	@Id
	private String codeS;
	private String heureDeb,heureFin,date;
	private String type;

	private String jour;



	@OneToOne
	private Modulee module;

	@OneToOne
	private Enseignant enseignant;

	public Seance(String codeS, String heureDeb, String heureFin, String date
			,String type,String jour) {
		super();
		this.codeS = codeS;
		this.heureDeb = heureDeb;
		this.heureFin = heureFin;
		this.date = date;
		this.type=type;
		this.setJour(jour);
	}


	public Seance() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Enseignant getEnseignant() {
		return enseignant;
	}


	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}





	public String getCodeS() {
		return codeS;
	}

	public void setCodeS(String codeS) {
		this.codeS = codeS;
	}


	public String getHeureDeb() {
		return heureDeb;
	}

	public void setHeureDeb(String heureDeb) {
		this.heureDeb = heureDeb;
	}

	public String getHeureFin() {
		return heureFin;
	}

	public void setHeureFin(String heureFin) {
		this.heureFin = heureFin;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}


	public Modulee getModule() {
		return module;
	}


	public void setModule(Modulee module) {
		this.module = module;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getJour() {
		return jour;
	}


	public void setJour(String jour) {
		this.jour = jour;
	}


}
