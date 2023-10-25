package com.microservices;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClasseRepository extends JpaRepository<Classe, Long> {

    @Query("SELECT c.nomClasse FROM Classe c WHERE c.id = :classId")
    String findByNomClasse(@Param("classId") Long classId);


}
