package com.example.skillbridge.service;

import com.example.skillbridge.entity.Application;

import java.util.List;

public interface ApplicationService {
    Application save(Application application);

    List<Application> findAll();

    List<Application> findByJobPostUserId(Long userId);

    List<Application> findByUserId(Long userId);

    Application findById(Long id);

    void delete(Long id);
}
