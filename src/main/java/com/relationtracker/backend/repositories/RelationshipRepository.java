package com.relationtracker.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.relationtracker.backend.models.Relationship;


public interface  RelationshipRepository extends JpaRepository<Relationship,Long> {
}
