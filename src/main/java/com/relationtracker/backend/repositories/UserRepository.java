package com.relationtracker.backend.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.relationtracker.backend.models.User;

public interface  UserRepository extends JpaRepository<User, Long> {
    public Optional<User> findById(Long Id);
    public List<User> findAll();
    
}
