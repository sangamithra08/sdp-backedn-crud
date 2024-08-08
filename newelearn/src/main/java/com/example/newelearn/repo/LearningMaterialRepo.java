package com.example.newelearn.repo;

import com.example.newelearn.model.LearningMaterial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LearningMaterialRepo extends JpaRepository<LearningMaterial, Long> {
}
