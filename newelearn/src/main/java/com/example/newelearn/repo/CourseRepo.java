package com.example.newelearn.repo;

import com.example.newelearn.model.Course;
import com.example.newelearn.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepo extends JpaRepository<Course, Long> {
    List<Course> findByUser(User user);
}
