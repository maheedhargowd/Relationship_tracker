package com.relationtracker.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity; // CORRECT IMPORT
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.relationtracker.backend.models.Relationship;
import com.relationtracker.backend.models.RelationshipRequest;
import com.relationtracker.backend.models.User;
import com.relationtracker.backend.repositories.UserRepository;
import com.relationtracker.backend.services.RelationshipService;

@RestController
@RequestMapping("/api")
public class RelationshipController {

    private final RelationshipService relationshipService;
    private final UserRepository userRepository;

    @Autowired
    public RelationshipController(RelationshipService relationshipService, UserRepository userRepository){
        this.relationshipService = relationshipService;
        this.userRepository = userRepository;
    }

    @PostMapping("/createrelationship")
    public ResponseEntity<?> createRelationship(@RequestBody RelationshipRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Relationship relationship = new Relationship();
        relationship.setRelationshipType(request.getRelationshipType());
        relationship.setRelationshipName(request.getRelationshipName());
        relationship.setRelationshipAge(request.getRelationshipAge());
        relationship.setUser(user);

        String result = relationshipService.createUserRelationship(relationship);
        if(result.equals("Relationship saved successfully !")){
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("error creating user relationship !", HttpStatus.BAD_REQUEST);
        }
    }

}
