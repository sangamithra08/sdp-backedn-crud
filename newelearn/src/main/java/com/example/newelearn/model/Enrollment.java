package com.example.newelearn.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean isEnrolled;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user; // Relationship with Student

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course; // Relationship with Course
}
