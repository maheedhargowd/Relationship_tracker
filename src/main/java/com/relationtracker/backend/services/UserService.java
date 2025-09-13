package com.relationtracker.backend.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relationtracker.backend.models.User;
import com.relationtracker.backend.repositories.UserRepository;
@Service
public class UserService {
    private final UserRepository userRepository;

    // Use constructor injection to provide the repository dependency
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<User> getAllUsers(){

        List<User> list = userRepository.findAllByOrderByIdAsc();
        return list;
    }
}
