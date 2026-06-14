package com.example.skillbridge.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplicationResponse {
    private Long id;
    private String status;
    private String applicantUsername;
    private String jobTitle;
}