package com.microservices.Repository;


import com.microservices.model.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EnseignantRepository extends JpaRepository<Enseignant, Long> {
	Enseignant findById(long id);
}
