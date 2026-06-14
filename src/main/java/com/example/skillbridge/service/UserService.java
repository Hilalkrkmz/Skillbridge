package com.example.skillbridge.service;

import com.example.skillbridge.entity.User;
import com.example.skillbridge.service.UserService;

import java.util.List;

public interface UserService {

    User save(User user);

    List<User> findAll();

    User findById(Long id);

    User update(Long id, User user);

    User findByEmail(String email);

    void delete(Long id);
}