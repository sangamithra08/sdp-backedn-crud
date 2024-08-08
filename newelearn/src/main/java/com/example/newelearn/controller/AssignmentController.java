package com.example.newelearn.controller;

import com.example.newelearn.model.Assignment;
import com.example.newelearn.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assignments")
public class AssignmentController {

    @Autowired
    private AssignmentService assignmentService;

    @PostMapping("/add/{courseId}/{userId}")
    public Assignment createAssignment(@RequestBody Assignment assignment, @PathVariable Long courseId, @PathVariable Long userId) {
        return assignmentService.createAssignment(courseId, userId, assignment);
    }

    @GetMapping("/course/{courseId}")
    public List<Assignment> getAssignmentsForCourse(@PathVariable Long courseId) {
        return assignmentService.getAssignmentsForCourse(courseId);
    }

    @GetMapping("/user/{userId}")
    public List<Assignment> getAssignmentsByUser(@PathVariable Long userId) {
        return assignmentService.getAssignmentsByUser(userId);
    }

    @GetMapping("/{assid}")
    public Assignment getAssignmentById(@PathVariable Long assid) {
        return assignmentService.getAssignmentById(assid);
    }

    @PutMapping("/{assid}")
    public Assignment updateAssignment(@PathVariable Long assid, @RequestBody Assignment updatedAssignment) {
        return assignmentService.updateAssignment(assid, updatedAssignment);
    }

    @DeleteMapping("/{assid}")
    public void deleteAssignment(@PathVariable Long assid) {
        assignmentService.deleteAssignment(assid);
    }
}
