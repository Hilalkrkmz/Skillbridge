package com.example.skillbridge.service;

import com.example.skillbridge.entity.Category;

import java.util.List;

public interface CategoryService {
    Category save(Category category);

    List<Category> findAll();

    Category findById(Long id);

    void delete(Long id);
}
