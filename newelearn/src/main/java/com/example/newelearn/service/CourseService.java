package com.example.newelearn.service;

import com.example.newelearn.model.Course;
import com.example.newelearn.model.User;
import com.example.newelearn.repo.CourseRepo;
import com.example.newelearn.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserService userService;

    public Course saveCourse(Course course){
        return courseRepo.save(course);
    }

    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }

    public Course getCourseById(Long id) {
        return courseRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Course not found with ID: " + id));
    }

    public Course createCourse(Course course, Long userID) {
        User userObj = userService.getUserById(userID);
        course.setUser(userObj);
        return courseRepo.save(course);
    }

    public List<Course> getCoursesByUserId(Long userId) {
        User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        return courseRepo.findByUser(user);
    }

    public Course updateCourse(Long id, Course course) {
        Course existingCourse = courseRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found with ID: " + id));

        existingCourse.setTitle(course.getTitle());
        existingCourse.setCategory(course.getCategory());
        existingCourse.setDifficultyLevel(course.getDifficultyLevel());
        existingCourse.setSyllabus(course.getSyllabus());

        return courseRepo.save(existingCourse);
    }

    public void deleteCourse(Long id) {
        Course existingCourse = courseRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found with ID: " + id));
        courseRepo.delete(existingCourse);
    }
}
