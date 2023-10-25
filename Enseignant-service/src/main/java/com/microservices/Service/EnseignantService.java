package com.microservices.Service;



import com.microservices.model.Enseignant;

import java.util.List;

public interface EnseignantService {
	String addEnseignant(Enseignant enseignant);

	String deleteEnseignant(Enseignant enseignant);
	Enseignant getOneEnseignant(long id);
	List<Enseignant> getAll();
}
