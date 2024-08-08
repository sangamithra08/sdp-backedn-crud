package com.example.newelearn.repo;

import com.example.newelearn.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
}
