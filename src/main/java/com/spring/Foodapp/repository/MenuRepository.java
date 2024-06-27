package com.spring.Foodapp.repository;

import com.spring.Foodapp.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {
    @Query("SELECT m.name FROM Menu m")
    List<String> findAllMenuNames();
}
