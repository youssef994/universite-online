package com.microservices.Repositories;

import com.microservices.Model.Evenement;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface evenmRepository extends CrudRepository<Evenement, Integer> {

    @Query(value = "SELECT * FROM Evenement  WHERE datt >= current_date", nativeQuery = true)
    List<Evenement> findByDateAfter();


}
