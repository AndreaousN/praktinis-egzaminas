package com.spring.Foodapp.service;

import com.spring.Foodapp.model.Catering;
import com.spring.Foodapp.repository.CateringRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CateringServiceImpl implements CateringService {
    @Autowired
    private CateringRepository cateringRepository;
    @Override
    public void save(Catering catering) {
        cateringRepository.save(catering);
    }

    @Override
    public List<Catering> getAll(){
        return cateringRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        cateringRepository.deleteById(id);
    }
    @Override
    public Optional<Catering> findById(int id) {
        return cateringRepository.findById(id);
    }

    @Override
    public List<Catering> findCateringsByName(String query) {
        return cateringRepository.findByNameContainingIgnoreCase(query);
    }


    @Override
    public List<Catering> findByIdIn(List<Integer> ids) {
        return cateringRepository.findByIdIn(ids);
    }
}
