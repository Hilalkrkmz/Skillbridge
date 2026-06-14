package com.example.skillbridge.mapper;

import com.example.skillbridge.dto.response.ApplicationResponse;
import com.example.skillbridge.entity.Application;
import org.springframework.stereotype.Component;

@Component
public class ApplicationMapper {

    public ApplicationResponse toResponse(Application application) {
        ApplicationResponse response = new ApplicationResponse();
        response.setId(application.getId());
        response.setStatus(application.getStatus().name());
        response.setApplicantUsername(application.getUser().getUsername());
        response.setJobTitle(application.getJobPost().getTitle());
        return response;
    }
}
