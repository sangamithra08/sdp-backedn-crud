package com.example.newelearn.service;

import com.example.newelearn.model.Assignment;
import com.example.newelearn.model.Course;
import com.example.newelearn.model.User;
import com.example.newelearn.repo.AssignmentRepo;
import com.example.newelearn.repo.CourseRepo;
import com.example.newelearn.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssignmentService {

    @Autowired
    private AssignmentRepo assignmentRepo;

    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    private UserRepo userRepo;

    public Assignment createAssignment(Long courseId, Long userId, Assignment assignment) {
        Course course = courseRepo.findById(courseId).orElseThrow(() -> new RuntimeException("Course not found"));
        User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        assignment.setCourse(course);
        assignment.setUser(user);
        return assignmentRepo.save(assignment);
    }

    public List<Assignment> getAssignmentsForCourse(Long courseId) {
        Course course = courseRepo.findById(courseId).orElseThrow(() -> new RuntimeException("Course not found"));
        return course.getAssignments();
    }

    public List<Assignment> getAssignmentsByUser(Long userId) {
        User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        return user.getAssignments();
    }

    public Assignment getAssignmentById(Long assid) {
        return assignmentRepo.findById(assid).orElseThrow(() -> new RuntimeException("Assignment not found"));
    }

    public Assignment updateAssignment(Long assid, Assignment updatedAssignment) {
        Assignment assignment = getAssignmentById(assid);
        assignment.setTitle(updatedAssignment.getTitle());
        assignment.setDescription(updatedAssignment.getDescription());
        assignment.setDueDate(updatedAssignment.getDueDate());
        return assignmentRepo.save(assignment);
    }

    public void deleteAssignment(Long assid) {
        Assignment assignment = getAssignmentById(assid);
        assignmentRepo.delete(assignment);
    }
}
