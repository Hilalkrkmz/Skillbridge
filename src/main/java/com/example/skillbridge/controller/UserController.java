package com.example.skillbridge.controller;

import com.example.skillbridge.dto.request.UserRequest;
import com.example.skillbridge.dto.response.UserResponse;
import com.example.skillbridge.entity.User;
import com.example.skillbridge.mapper.UserMapper;
import com.example.skillbridge.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping
    public UserResponse save(@RequestBody UserRequest request) {
        User user = userMapper.toEntity(request);
        return userMapper.toResponse(userService.save(user));
    }

    @GetMapping
    public List<UserResponse> findAll() {
        return userService.findAll()
                .stream()
                .map(userMapper::toResponse)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public UserResponse findById(@PathVariable Long id) {
        return userMapper.toResponse(userService.findById(id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }
}
