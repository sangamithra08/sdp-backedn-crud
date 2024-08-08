package com.example.newelearn.repo;

import com.example.newelearn.model.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentRepo extends JpaRepository<Assignment,Long> {
}
