package com.example.skillbridge.controller;

import com.example.skillbridge.entity.Application;
import com.example.skillbridge.entity.ApplicationStatus;
import com.example.skillbridge.entity.JobPost;
import com.example.skillbridge.entity.User;
import com.example.skillbridge.service.ApplicationService;
import com.example.skillbridge.service.JobPostService;
import com.example.skillbridge.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.time.LocalDateTime;

@Controller
public class ApplicationPageController {
    private final ApplicationService applicationService;
    private final JobPostService jobPostService;
    private final UserService userService;

    public ApplicationPageController(ApplicationService applicationService,
                                     JobPostService jobPostService,
                                     UserService userService) {
        this.applicationService = applicationService;
        this.jobPostService = jobPostService;
        this.userService = userService;
    }

    @PostMapping("/apply")
    public String apply(Application application) {
        applicationService.save(application);
        return "redirect:/applications";
    }

    @GetMapping("/applications/apply/{jobId}")
    public String apply(@PathVariable Long jobId, Principal principal) {
        User user = userService.findByEmail(principal.getName());
        JobPost jobPost = jobPostService.findById(jobId);

        Application application = new Application();
        application.setApplicationDate(LocalDateTime.now());
        application.setStatus(ApplicationStatus.PENDING);
        application.setJobPost(jobPost);
        application.setUser(user);

        applicationService.save(application);
        return "redirect:/applications";
    }

    @GetMapping("/applications/{id}/approve")
    public String approve(@PathVariable Long id) {
        Application app = applicationService.findById(id);
        app.setStatus(ApplicationStatus.APPROVED);
        applicationService.save(app);
        return "redirect:/applications";
    }

    @GetMapping("/applications/{id}/reject")
    public String reject(@PathVariable Long id) {
        Application app = applicationService.findById(id);
        app.setStatus(ApplicationStatus.REJECTED);
        applicationService.save(app);
        return "redirect:/applications";
    }
}