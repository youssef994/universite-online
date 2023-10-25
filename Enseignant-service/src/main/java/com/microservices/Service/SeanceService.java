package com.microservices.Service;



import com.microservices.model.Seance;

import java.util.List;

public interface SeanceService {
	String addSeance(Seance seance);
	String updateSeance(Seance seance);
	String deleteSeance(Seance seance);
	Seance getOneSeance(String codeS);
	List<Seance> getAll();
}
