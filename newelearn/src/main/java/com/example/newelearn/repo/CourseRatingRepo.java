package com.example.newelearn.repo;

import com.example.newelearn.model.CourseRating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRatingRepo extends JpaRepository<CourseRating,Long> {
}
