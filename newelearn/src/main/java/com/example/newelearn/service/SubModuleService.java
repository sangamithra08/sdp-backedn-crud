package com.example.newelearn.service;

import com.example.newelearn.model.Course;
import com.example.newelearn.model.SubModule;
import com.example.newelearn.repo.CourseRepo;
import com.example.newelearn.repo.SubModuleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubModuleService {

    @Autowired
    private SubModuleRepo submoduleRepo;

    @Autowired
    private CourseRepo courseRepo;

    public SubModule createSubmodule(Long courseId, SubModule submodule) {
        Course course = courseRepo.findById(courseId).orElseThrow(() -> new RuntimeException("Course not found"));
        submodule.setCourse(course);
        return submoduleRepo.save(submodule);
    }

    public List<SubModule> getSubmodulesByCourse(Long courseId) {
        Course course = courseRepo.findById(courseId).orElseThrow(() -> new RuntimeException("Course not found"));
        return course.getSubmodules();
    }

    public SubModule getSubmoduleById(Long id) {
        return submoduleRepo.findById(id).orElseThrow(() -> new RuntimeException("Submodule not found"));
    }

    public SubModule updateSubmodule(Long id, SubModule updatedSubmodule) {
        SubModule subModule = getSubmoduleById(id);
        subModule.setTitle(updatedSubmodule.getTitle());
        subModule.setDescription(updatedSubmodule.getDescription());
        return submoduleRepo.save(subModule);
    }

    public void deleteSubmodule(Long id) {
        SubModule subModule = getSubmoduleById(id);
        submoduleRepo.delete(subModule);
    }
}
