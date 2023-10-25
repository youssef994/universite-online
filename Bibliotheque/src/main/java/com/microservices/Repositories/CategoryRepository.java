package com.microservices.Repositories;

import com.microservices.Entities.Category;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    public Category getByName(String name);
    public List<Category> getSubjectsByNameIsContainingIgnoreCase(String name, Sort sort);
    public boolean existsByName(String name);

}
