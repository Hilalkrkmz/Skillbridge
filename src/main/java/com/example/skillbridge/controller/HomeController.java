package com.example.skillbridge.controller;

import com.example.skillbridge.entity.Role;
import com.example.skillbridge.entity.User;
import com.example.skillbridge.service.ApplicationService;
import com.example.skillbridge.service.JobPostService;
import com.example.skillbridge.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;

@Controller
public class HomeController {
    private final JobPostService jobPostService;
    private final ApplicationService applicationService;
    private final UserService userService;

    public HomeController(JobPostService jobPostService,
                          ApplicationService applicationService,
                          UserService userService) {
        this.jobPostService = jobPostService;
        this.applicationService = applicationService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("userCount", userService.findAll().size());
        model.addAttribute("jobCount", jobPostService.findAll().size());
        model.addAttribute("applicationCount", applicationService.findAll().size());
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @GetMapping("/job-create")
    public String jobCreate(Principal principal) {
        User user = userService.findByEmail(principal.getName());
        if (user == null || user.getRole() != Role.EMPLOYER) {
            return "redirect:/jobs";
        }
        return "job-create";
    }

    @GetMapping("/jobs")
    public String jobs(Model model) {
        model.addAttribute("jobs", jobPostService.findAll());
        return "jobs";
    }

    @GetMapping("/jobs/delete/{id}")
    public String deleteJob(@PathVariable Long id) {
        jobPostService.delete(id);
        return "redirect:/jobs";
    }

    @GetMapping("/profile")
    public String profile(Model model, Principal principal) {
        User user = userService.findByEmail(principal.getName());
        model.addAttribute("user", user);
        return "profile";
    }

    @GetMapping("/applications")
    public String applications(Model model, Principal principal) {
        User user = userService.findByEmail(principal.getName());

        if (user.getRole() == Role.EMPLOYER) {
            model.addAttribute("applications",
                    applicationService.findByJobPostUserId(user.getId()));
        } else {
            model.addAttribute("applications",
                    applicationService.findByUserId(user.getId()));
        }

        return "applications";
    }
}