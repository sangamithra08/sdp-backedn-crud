package com.example.newelearn.service;

import com.example.newelearn.model.LearningMaterial;
import com.example.newelearn.model.SubModule;
import com.example.newelearn.repo.LearningMaterialRepo;
import com.example.newelearn.repo.SubModuleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LearningMaterialService {

    @Autowired
    private LearningMaterialRepo learningMaterialRepo;

    @Autowired
    private SubModuleRepo subModuleRepo;

    public LearningMaterial createLearningMaterial(Long submoduleId, LearningMaterial learningMaterial) {
        SubModule submodule = subModuleRepo.findById(submoduleId).orElseThrow(() -> new RuntimeException("Submodule not found"));
        learningMaterial.setSubmodule(submodule);
        return learningMaterialRepo.save(learningMaterial);
    }

    public List<LearningMaterial> getLearningMaterialsBySubmodule(Long submoduleId) {
        SubModule subModule = subModuleRepo.findById(submoduleId).orElseThrow(() -> new RuntimeException("Submodule not found"));
        return subModule.getLearningMaterials();
    }

    public LearningMaterial getLearningMaterialById(Long id) {
        return learningMaterialRepo.findById(id).orElseThrow(() -> new RuntimeException("Learning Material not found"));
    }

    public LearningMaterial updateLearningMaterial(Long id, LearningMaterial updatedLearningMaterial) {
        LearningMaterial learningMaterial = getLearningMaterialById(id);
        learningMaterial.setTitle(updatedLearningMaterial.getTitle());
        learningMaterial.setContent(updatedLearningMaterial.getContent());
        return learningMaterialRepo.save(learningMaterial);
    }

    public void deleteLearningMaterial(Long id) {
        LearningMaterial learningMaterial = getLearningMaterialById(id);
        learningMaterialRepo.delete(learningMaterial);
    }
}
