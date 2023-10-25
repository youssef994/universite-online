package com.microservices.Repositories;

import com.microservices.Model.Club;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface clubRepository extends CrudRepository<Club, Integer>  {
}
