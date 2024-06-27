package com.spring.Foodapp.service;

import com.spring.Foodapp.model.User;

public interface UserService {
    void save(User user);
    User findByUsername(String username);
}
