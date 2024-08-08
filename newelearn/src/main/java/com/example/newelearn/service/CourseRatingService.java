package com.example.newelearn.service;

import com.example.newelearn.model.Course;
import com.example.newelearn.model.CourseRating;
import com.example.newelearn.model.User;
import com.example.newelearn.repo.CourseRatingRepo;
import com.example.newelearn.repo.CourseRepo;
import com.example.newelearn.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseRatingService {

    @Autowired
    private CourseRatingRepo courseRatingRepo;

    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    private UserRepo userRepo;

    public CourseRating addRating(Long courseId, Long userId, CourseRating courseRating) {
        Course course = courseRepo.findById(courseId).orElseThrow(() -> new RuntimeException("Course not found"));
        User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        courseRating.setCourse(course);
        courseRating.setUser(user);
        return courseRatingRepo.save(courseRating);
    }

    public List<CourseRating> getRatingsForCourse(Long courseId) {
        Course course = courseRepo.findById(courseId).orElseThrow(() -> new RuntimeException("Course not found"));
        return course.getRatings();
    }
}
