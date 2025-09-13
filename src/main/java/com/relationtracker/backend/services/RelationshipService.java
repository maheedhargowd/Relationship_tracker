package com.relationtracker.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.relationtracker.backend.models.Relationship;
import com.relationtracker.backend.repositories.RelationshipRepository;



@Service
public class RelationshipService {
    
    private final RelationshipRepository relationshipRepository;

    
    public RelationshipService(RelationshipRepository relationshipRepository){
        this.relationshipRepository = relationshipRepository;
    }

    public String createUserRelationship(Relationship relationship){

        relationshipRepository.save(relationship);
        return "Relationship saved successfully !";
    }

    public Optional<List<Relationship>> getUserRelationshipList(Long id){
        Optional<List<Relationship>> result =  relationshipRepository.findByUserIdOrderByIdAsc(id);
        return result;
    }
}
