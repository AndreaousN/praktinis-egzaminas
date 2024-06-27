package com.spring.Foodapp.service;

import com.spring.Foodapp.model.Menu;

import java.util.List;
import java.util.Optional;

public interface MenuService {
    void save(Menu menu);

    List<String> findAllMenuNames();
    List<Menu> findAll();

    void deleteById(int id);

    Optional<Menu> findById(int id);
}
