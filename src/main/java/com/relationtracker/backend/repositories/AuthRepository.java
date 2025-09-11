package com.relationtracker.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.relationtracker.backend.models.User;

public interface  AuthRepository extends JpaRepository<User, Long>{
    
}
