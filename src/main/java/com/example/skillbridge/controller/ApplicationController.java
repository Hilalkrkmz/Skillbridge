package com.example.skillbridge.controller;

import com.example.skillbridge.dto.response.ApplicationResponse;
import com.example.skillbridge.entity.Application;
import com.example.skillbridge.entity.ApplicationStatus;
import com.example.skillbridge.entity.JobPost;
import com.example.skillbridge.mapper.ApplicationMapper;
import com.example.skillbridge.service.ApplicationService;
import com.example.skillbridge.service.JobPostService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {
    private final ApplicationService applicationService;
    private final ApplicationMapper applicationMapper;

    public ApplicationController(ApplicationService applicationService,
                                 ApplicationMapper applicationMapper) {
        this.applicationService = applicationService;
        this.applicationMapper = applicationMapper;
    }

    @GetMapping
    public List<ApplicationResponse> findAll() {
        return applicationService.findAll()
                .stream()
                .map(applicationMapper::toResponse)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ApplicationResponse findById(@PathVariable Long id) {
        return applicationMapper.toResponse(applicationService.findById(id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        applicationService.delete(id);
    }
}
