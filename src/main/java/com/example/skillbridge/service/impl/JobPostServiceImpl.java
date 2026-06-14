package com.example.skillbridge.service.impl;

import com.example.skillbridge.entity.JobPost;
import com.example.skillbridge.repository.JobPostRepository;
import com.example.skillbridge.service.JobPostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPostServiceImpl implements JobPostService {

    private final JobPostRepository jobPostRepository;

    public JobPostServiceImpl(JobPostRepository jobPostRepository) {
        this.jobPostRepository = jobPostRepository;
    }

    @Override
    public JobPost save(JobPost jobPost) {
        return jobPostRepository.save(jobPost);
    }

    @Override
    public List<JobPost> findAll() {
        return jobPostRepository.findAll();
    }

    @Override
    public JobPost findById(Long id) {
        return jobPostRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        jobPostRepository.deleteById(id);
    }
}
