package com.example.skillbridge.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JobPostResponse {
    private Long id;
    private String title;
    private String description;
    private Double salary;
    private String jobType;
    private String employerUsername;
}
