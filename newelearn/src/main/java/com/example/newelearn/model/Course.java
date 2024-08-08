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
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String category;
    private String difficultyLevel;
    private String syllabus;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "uid")
    private User user;

    @OneToMany(mappedBy = "course")
    @JsonIgnore
    private List<CourseRating> ratings;

    @OneToMany(mappedBy = "course")
    @JsonIgnore
    private List<Assignment> assignments;
    @OneToMany(mappedBy = "course")
    @JsonIgnore
    private List<Enrollment> enrollments;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<SubModule> submodules;
}
