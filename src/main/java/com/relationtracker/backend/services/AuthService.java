package com.relationtracker.backend.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relationtracker.backend.models.User;
import com.relationtracker.backend.repositories.AuthRepository;

@Service
public class AuthService {
    private final AuthRepository authRepository;

    @Autowired
    public AuthService(AuthRepository authRepository){
        this.authRepository=authRepository;
    }


    public String userSignup(User user ){


        authRepository.save(user);
        return "signedup successfully !";
    }
}
