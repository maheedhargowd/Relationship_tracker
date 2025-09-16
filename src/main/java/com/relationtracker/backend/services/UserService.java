package com.relationtracker.backend.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relationtracker.backend.models.User;
import com.relationtracker.backend.models.UserUpdateRequest;
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
    public String updateUser(UserUpdateRequest user , Long userid){


        
            Optional<User> userInDb  = userRepository.findById(userid);
            if(userInDb.isPresent()){
                String userName = user.getUserName();
                Double age = user.getAge();
                String email = user.getMailId();

                User existingUser = userInDb.get();
                if(!(userName == null)){existingUser.setUserName(userName);}
                if(!(age == null)){existingUser.setAge(age);}
                if(!(email == null)){existingUser.setMailId(email);}
                
                userRepository.save(existingUser);
                return "user updated successfully !";
            }else{
                return "User not found";
            }
        
        
    }
}
