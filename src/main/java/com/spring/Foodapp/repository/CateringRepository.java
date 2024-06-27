package com.spring.Foodapp.repository;

import com.spring.Foodapp.model.Catering;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CateringRepository extends JpaRepository<Catering, Integer> {
    List<Catering> findByNameContainingIgnoreCase(String query);
    List<Catering> findByIdIn(List<Integer> ids);
}