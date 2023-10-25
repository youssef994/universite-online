package com.microservices.Repositories;
import com.microservices.Model.Club;
import com.microservices.Model.Formulaire;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface formulaireRepository extends CrudRepository<Formulaire, Integer>  {
        }

