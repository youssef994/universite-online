package com.microservices.Repository;


import com.microservices.model.Seance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface SeanceRepository extends JpaRepository<Seance, String> {
    Seance findByCodeS(String codeS);

}
