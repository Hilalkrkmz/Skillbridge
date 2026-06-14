package com.example.skillbridge.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToOne(mappedBy = "user")
    private Profile profile;

    @OneToMany(mappedBy = "user")
    private List<JobPost> jobPosts;

    @OneToMany(mappedBy = "user")
    private List<Application> applications;

    @NotBlank(message = "Username bos olamaz")
    private String username;

    @NotBlank(message = "Email bos olamaz")
    @Email(message = "Gecerli email giriniz")
    private String email;

    @NotBlank(message = "Password bos olamaz")
    @Size(min = 6, message = "Sifre en az 6 karakter olmali")
    private String password;
}
