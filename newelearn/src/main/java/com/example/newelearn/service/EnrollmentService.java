package com.example.newelearn.service;

import com.example.newelearn.model.Course;
import com.example.newelearn.model.Enrollment;
import com.example.newelearn.model.User;
import com.example.newelearn.repo.CourseRepo;
import com.example.newelearn.repo.EnrollmentRepo;
import com.example.newelearn.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentRepo enrollmentRepo;

    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    private UserRepo userRepo;

    public Enrollment createEnrollment(Long studentId, Long courseId, Enrollment enrollment) {
        Course course = courseRepo.findById(courseId).orElseThrow(() -> new RuntimeException("Course not found"));
        User user = userRepo.findById(studentId).orElseThrow(() -> new RuntimeException("Student not found"));

        enrollment.setCourse(course);
        enrollment.setUser(user);
        return enrollmentRepo.save(enrollment);
    }

    public List<Enrollment> getEnrollmentsForCourse(Long courseId) {
        Course course = courseRepo.findById(courseId).orElseThrow(() -> new RuntimeException("Course not found"));
        return course.getEnrollments();
    }

    public List<Enrollment> getEnrollmentsByStudent(Long studentId) {
        User user = userRepo.findById(studentId).orElseThrow(() -> new RuntimeException("Student not found"));
        return user.getEnrollments();
    }

    public Enrollment getEnrollmentById(Long id) {
        return enrollmentRepo.findById(id).orElseThrow(() -> new RuntimeException("Enrollment not found"));
    }

    public Enrollment updateEnrollment(Long id, Enrollment updatedEnrollment) {
        Enrollment enrollment = getEnrollmentById(id);
        enrollment.setIsEnrolled(updatedEnrollment.getIsEnrolled());
        return enrollmentRepo.save(enrollment);
    }

    public void deleteEnrollment(Long id) {
        Enrollment enrollment = getEnrollmentById(id);
        enrollmentRepo.delete(enrollment);
    }
}
