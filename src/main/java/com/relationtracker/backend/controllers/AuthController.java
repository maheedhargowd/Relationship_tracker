package com.relationtracker.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.relationtracker.backend.models.User;
import com.relationtracker.backend.services.AuthService;


@RestController
@RequestMapping("/api")
public class AuthController {
    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService){
        this.authService=authService;
    }
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody User user) {
        //TODO: process POST request
        String result = authService.userSignup(user);
        if (result.equals("signedup successfully !")){
            return new ResponseEntity<>("signedup successfully !",HttpStatus.OK) ;
        }else {
            return new ResponseEntity<>("Failed to create an account !!",HttpStatus.BAD_REQUEST);
        }
        
    }
    
}
 