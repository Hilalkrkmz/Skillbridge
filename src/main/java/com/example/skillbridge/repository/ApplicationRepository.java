package com.example.skillbridge.repository;

import com.example.skillbridge.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
    List<Application> findByJobPostUserId(Long userId);
    List<Application> findByUserId(Long userId);
}
