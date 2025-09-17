package com.relationtracker.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.relationtracker.backend.models.Relationship;
import com.relationtracker.backend.models.RelationshipRequest;
import com.relationtracker.backend.models.User;
import com.relationtracker.backend.repositories.RelationshipRepository;
import com.relationtracker.backend.repositories.UserRepository;



@Service
public class RelationshipService {
    
    private final RelationshipRepository relationshipRepository;
    private final UserRepository userRepository;
    
    public RelationshipService(RelationshipRepository relationshipRepository,UserRepository userRepository){
        this.relationshipRepository = relationshipRepository;
         this.userRepository = userRepository;
    }


    public String createUserRelationship(Relationship relationship){

        relationshipRepository.save(relationship);
        return "Relationship saved successfully !";
    }

    public Optional<List<Relationship>> getUserRelationshipList(Long id){
        Optional<List<Relationship>> result =  relationshipRepository.findByUserIdOrderByIdAsc(id);
        return result;
    }
    public String updateRelationship(Long userid , Long relationshipid , RelationshipRequest request){
        Optional<Relationship> optionalRelationship = relationshipRepository.findById(relationshipid);
            
        Relationship existingRelationship = optionalRelationship.get();
        User existingUser = existingRelationship.getUser();
        Long existingUserId = existingUser.getId();
        if(userid == existingUserId){
            String type=request.getRelationshipType();
            String name=request.getRelationshipName();
            Double age=request.getRelationshipAge();
            
            
            if (type != null) existingRelationship.setRelationshipType(type);
            if (name != null) existingRelationship.setRelationshipName(name);
            if (age != null) existingRelationship.setRelationshipAge(age);

            
            relationshipRepository.save(existingRelationship);
            return "Relationship updated successfully !";
        }else{
            return "given userid doesn't have any relationships !";
        }
    }
}
