package com.microservices.Repositories;

import com.microservices.Model.Seminaire;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface seminaireRep extends MongoRepository<Seminaire,String> {
}