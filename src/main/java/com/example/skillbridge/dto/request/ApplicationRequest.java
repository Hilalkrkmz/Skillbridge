package com.example.skillbridge.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplicationRequest {
    private Long userId;
    private Long jobPostId;
    private String coverLetter;
}
