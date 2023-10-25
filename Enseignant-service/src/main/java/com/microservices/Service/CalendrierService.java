package com.microservices.Service;



import com.microservices.model.Seance;

import java.util.List;

public interface CalendrierService {
    List<Seance> addSeanceToEnseignant(String codeS, long id);


}
