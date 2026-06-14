package com.example.skillbridge.service;

import com.example.skillbridge.entity.JobPost;

import java.util.List;

public interface JobPostService {
    JobPost save(JobPost jobPost);

    List<JobPost> findAll();

    JobPost findById(Long id);

    void delete(Long id);
}
