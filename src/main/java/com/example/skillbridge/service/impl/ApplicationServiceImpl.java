package com.example.skillbridge.service.impl;

import com.example.skillbridge.entity.Application;
import com.example.skillbridge.repository.ApplicationRepository;
import com.example.skillbridge.service.ApplicationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;

    public ApplicationServiceImpl(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @Override
    public Application save(Application application) {
        return applicationRepository.save(application);
    }

    @Override
    public List<Application> findAll() {
        return applicationRepository.findAll();
    }

    @Override
    public Application findById(Long id) {
        return applicationRepository.findById(id).orElse(null);
    }

    @Override
    public List<Application> findByJobPostUserId(Long userId) {
        return applicationRepository.findByJobPostUserId(userId);
    }

    @Override
    public List<Application> findByUserId(Long userId) {
        return applicationRepository.findByUserId(userId);
    }

    @Override
    public void delete(Long id) {
        applicationRepository.deleteById(id);
    }
}
