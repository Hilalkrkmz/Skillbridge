package com.example.skillbridge.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "profiles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bio;

    private String skills;

    private String cvPath;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
