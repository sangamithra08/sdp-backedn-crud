package com.example.newelearn.controller;


import com.example.newelearn.model.CourseRating;
import com.example.newelearn.service.CourseRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class CourseRatingController {

    @Autowired
    private CourseRatingService courseRatingService;

    @PostMapping("/add/{courseId}/{userId}")
    public CourseRating addRating(@PathVariable Long courseId, @PathVariable Long userId, @RequestBody CourseRating courseRating) {
        return courseRatingService.addRating(courseId, userId, courseRating);
    }

    @GetMapping("/course/{courseId}")
    public List<CourseRating> getRatingsForCourse(@PathVariable Long courseId) {
        return courseRatingService.getRatingsForCourse(courseId);
    }
}
