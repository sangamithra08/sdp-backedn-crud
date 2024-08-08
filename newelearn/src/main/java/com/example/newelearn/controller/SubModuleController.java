package com.example.newelearn.controller;

import com.example.newelearn.model.SubModule;
import com.example.newelearn.service.SubModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/submodules")
public class SubModuleController {

    @Autowired
    private SubModuleService subModuleService;

    @PostMapping("/add/{courseId}")
    public SubModule createSubmodule(@RequestBody SubModule submodule, @PathVariable Long courseId) {
        return subModuleService.createSubmodule(courseId, submodule);
    }

    @GetMapping("/course/{courseId}")
    public List<SubModule> getSubmodulesByCourse(@PathVariable Long courseId) {
        return subModuleService.getSubmodulesByCourse(courseId);
    }

    @GetMapping("/{id}")
    public SubModule getSubmoduleById(@PathVariable Long id) {
        return subModuleService.getSubmoduleById(id);
    }

    @PutMapping("/{id}")
    public SubModule updateSubmodule(@PathVariable Long id, @RequestBody SubModule updatedSubmodule) {
        return subModuleService.updateSubmodule(id, updatedSubmodule);
    }

    @DeleteMapping("/{id}")
    public void deleteSubmodule(@PathVariable Long id) {
        subModuleService.deleteSubmodule(id);
    }
}
