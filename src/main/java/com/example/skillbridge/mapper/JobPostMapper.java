package com.example.skillbridge.mapper;

import com.example.skillbridge.dto.request.JobPostRequest;
import com.example.skillbridge.dto.response.JobPostResponse;
import com.example.skillbridge.entity.JobPost;
import com.example.skillbridge.entity.JobType;
import org.springframework.stereotype.Component;

@Component
public class JobPostMapper {

    public JobPost toEntity(JobPostRequest request) {
        JobPost jobPost = new JobPost();
        jobPost.setTitle(request.getTitle());
        jobPost.setDescription(request.getDescription());
        jobPost.setSalary(request.getSalary());
        jobPost.setJobType(JobType.valueOf(request.getJobType()));//string i enuma cevirme
        return jobPost;
    }

    public JobPostResponse toResponse(JobPost jobPost) {
        JobPostResponse response = new JobPostResponse();
        response.setId(jobPost.getId());
        response.setTitle(jobPost.getTitle());
        response.setDescription(jobPost.getDescription());
        response.setSalary(jobPost.getSalary());
        response.setJobType(jobPost.getJobType() != null ? jobPost.getJobType().name() : null);
        response.setEmployerUsername(jobPost.getUser() != null ? jobPost.getUser().getUsername() : null);
        return response;
    }
}
