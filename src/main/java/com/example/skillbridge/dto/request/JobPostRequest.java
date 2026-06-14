package com.example.skillbridge.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JobPostRequest {
    private String title;
    private String description;
    private Double salary;
    private String jobType;
}
