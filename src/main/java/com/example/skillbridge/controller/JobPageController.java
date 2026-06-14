package com.example.skillbridge.controller;

import com.example.skillbridge.entity.JobPost;
import com.example.skillbridge.entity.User;
import com.example.skillbridge.service.JobPostService;
import com.example.skillbridge.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.security.Principal;
import java.time.LocalDateTime;

@Controller
public class JobPageController {
    private final JobPostService jobPostService;
    private final UserService userService;

    public JobPageController(JobPostService jobPostService,
                             UserService userService) {
        this.jobPostService = jobPostService;
        this.userService = userService;
    }

    @PostMapping("/job-create")
    public String createJob(@ModelAttribute JobPost jobPost, Principal principal) {
        User user = userService.findByEmail(principal.getName());
        jobPost.setUser(user);
        jobPost.setCreatedAt(LocalDateTime.now());
        jobPostService.save(jobPost);
        return "redirect:/jobs";
    }
}