package com.example.newelearn.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;
    private String name;
    private String email;
    private String password;
    private String role;
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Course> createdCourses;
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Assignment> assignments;
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Enrollment> enrollments;
}
