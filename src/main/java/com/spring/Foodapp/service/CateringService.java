package com.spring.Foodapp.service;

import com.spring.Foodapp.model.Catering;

import java.util.List;
import java.util.Optional;

public interface CateringService {
    void save(Catering catering);
    List<Catering> getAll();
    void deleteById(int id);
    Optional<Catering> findById(int id);
    List<Catering> findCateringsByName(String query);
    List<Catering> findByIdIn(List<Integer> ids);
}
