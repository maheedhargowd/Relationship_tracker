package com.relationtracker.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.relationtracker.backend.models.User;
import com.relationtracker.backend.models.UserUpdateRequest;
import com.relationtracker.backend.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    
    
    @GetMapping("/getallusers")
    public ResponseEntity<?> getallusers(){
       
        List<User> list = userService.getAllUsers();
        if(list.isEmpty()){
            return new ResponseEntity<>("no users found !", HttpStatus.NOT_FOUND);
        }else return new ResponseEntity<>(list,HttpStatus.OK);
        
       
    }

    @PutMapping("/updateuser/{userid}")
    public ResponseEntity<?> updateUser(@PathVariable Long userid , @RequestBody UserUpdateRequest request){

        String result = userService.updateUser(request,userid);
        if(result.equals("user updated successfully !")){
            return new  ResponseEntity<>(result , HttpStatus.OK);
        }else if(result.equals("User not found")){
            return new ResponseEntity<>(result,HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>("something went wrong !",HttpStatus.SERVICE_UNAVAILABLE);
        }
        
    }


}
