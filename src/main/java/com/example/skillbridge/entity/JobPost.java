package com.example.skillbridge.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;
import java.time.LocalDateTime;

@Entity
@Table(name = "job_posts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 1000)
    private String description;

    private Double salary;

    @Enumerated(EnumType.STRING)
    private JobType jobType;

    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id")//birden fazla ilan
    private User user;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "jobPost")//birden fazla basvuru
    private List<Application> applications;
}
