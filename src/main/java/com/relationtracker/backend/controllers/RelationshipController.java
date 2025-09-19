package com.relationtracker.backend.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping; // CORRECT IMPORT
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.relationtracker.backend.models.Relationship;
import com.relationtracker.backend.models.RelationshipRequest;
import com.relationtracker.backend.models.User;
import com.relationtracker.backend.repositories.UserRepository;
import com.relationtracker.backend.services.RelationshipService;
import com.relationtracker.exception.RelationshipNotFoundException;
import com.relationtracker.exception.UnauthorizedRelationshipAccessException;

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



    @GetMapping("/users/{userId}/relationships")
    public ResponseEntity<?> getUserRelarionships(@PathVariable Long userId){
        Optional<List<Relationship>> result = relationshipService.getUserRelationshipList(userId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/users/{userid}/updaterelationship/{relationshipid}")
    public ResponseEntity<?> updateUserRelationship(@PathVariable Long userid , @PathVariable Long relationshipid , @RequestBody RelationshipRequest request){
        String result = relationshipService.updateRelationship(userid,relationshipid,request);
        if(result.equals("Relationship updated successfully !")){
            return new ResponseEntity<>(result,HttpStatus.OK);
        }else if (result.equals("given userid doesn't have any relationships !")){
            return new ResponseEntity<>(result,HttpStatus.FORBIDDEN);
        }else{
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        
    }

   @DeleteMapping("/users/{userid}/relationship/{relationshipid}")
public ResponseEntity<?> deleteUserRelationship(
    @PathVariable Long userid, 
    @PathVariable Long relationshipid) {
    
    try {
        relationshipService.deleteRelationship(userid, relationshipid);
        return ResponseEntity.noContent().build(); // 204 No Content
    } catch (RelationshipNotFoundException e) {
        return ResponseEntity.notFound().build(); // 404 Not Found
    } catch (UnauthorizedRelationshipAccessException e) {
        return ResponseEntity.badRequest().body(e.getMessage()); // 400 Bad Request
    } catch (Exception e) {
        return ResponseEntity.internalServerError()
            .body("An unexpected error occurred"); // 500 Internal Server Error
    }
}



}

