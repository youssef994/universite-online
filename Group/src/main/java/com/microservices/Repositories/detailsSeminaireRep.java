package com.microservices.Repositories;

import com.microservices.Model.detailsSeminaire;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface detailsSeminaireRep extends MongoRepository<detailsSeminaire,String> {
}