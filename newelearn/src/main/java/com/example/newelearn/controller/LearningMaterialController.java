package com.example.newelearn.controller;

import com.example.newelearn.model.LearningMaterial;
import com.example.newelearn.service.LearningMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/learning-materials")
public class LearningMaterialController {

    @Autowired
    private LearningMaterialService learningMaterialService;

    @PostMapping("/add/{submoduleId}")
    public LearningMaterial createLearningMaterial(@RequestBody LearningMaterial learningMaterial, @PathVariable Long submoduleId) {
        return learningMaterialService.createLearningMaterial(submoduleId, learningMaterial);
    }

    @GetMapping("/submodule/{submoduleId}")
    public List<LearningMaterial> getLearningMaterialsBySubmodule(@PathVariable Long submoduleId) {
        return learningMaterialService.getLearningMaterialsBySubmodule(submoduleId);
    }

    @GetMapping("/{id}")
    public LearningMaterial getLearningMaterialById(@PathVariable Long id) {
        return learningMaterialService.getLearningMaterialById(id);
    }

    @PutMapping("/{id}")
    public LearningMaterial updateLearningMaterial(@PathVariable Long id, @RequestBody LearningMaterial updatedLearningMaterial) {
        return learningMaterialService.updateLearningMaterial(id, updatedLearningMaterial);
    }

    @DeleteMapping("/{id}")
    public void deleteLearningMaterial(@PathVariable Long id) {
        learningMaterialService.deleteLearningMaterial(id);
    }
}
