package com.example.skillbridge.controller;

import com.example.skillbridge.dto.request.JobPostRequest;
import com.example.skillbridge.dto.response.JobPostResponse;
import com.example.skillbridge.entity.JobPost;
import com.example.skillbridge.mapper.JobPostMapper;
import com.example.skillbridge.service.JobPostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/jobposts")
public class JobPostController {

    private final JobPostService jobPostService;
    private final JobPostMapper jobPostMapper;

    public JobPostController(JobPostService jobPostService,
                             JobPostMapper jobPostMapper) {
        this.jobPostService = jobPostService;
        this.jobPostMapper = jobPostMapper;
    }

    @PostMapping
    public JobPostResponse save(@RequestBody JobPostRequest request) {
        return jobPostMapper.toResponse(jobPostService.save(jobPostMapper.toEntity(request)));
    }

    @GetMapping
    public List<JobPostResponse> findAll() {
        return jobPostService.findAll()
                .stream()
                .map(jobPostMapper::toResponse)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public JobPostResponse findById(@PathVariable Long id) {
        return jobPostMapper.toResponse(jobPostService.findById(id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        jobPostService.delete(id);
    }
}
