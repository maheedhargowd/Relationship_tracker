package com.relationtracker.backend.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.relationtracker.backend.models.Relationship;



public interface  RelationshipRepository extends JpaRepository<Relationship,Long> {

    public  Optional<List<Relationship>> findByUserIdOrderByIdAsc(Long Id);
}
