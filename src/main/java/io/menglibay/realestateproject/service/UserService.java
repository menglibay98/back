package io.menglibay.realestateproject.service;

import io.menglibay.realestateproject.entity.User;
import io.menglibay.realestateproject.entity.UserRole;
import io.menglibay.realestateproject.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(int id){
        return userRepository.findById(id).orElse(null);
    }

    @Transactional
    public User saveUser(User user){
        try{
            User savedUser = userRepository.save(user);
            return savedUser;
        } catch (Exception e){
            System.out.println("User saved succesfully");
            throw e;
        }

    }

    public void deleteUser(int id){
        userRepository.deleteById(id);
    }
    public List<User> getUserByName(String name) {
        return userRepository.findUserByName(name);
    }

    public List<User> getUserBySurname(String surname){
        return userRepository.findUserBySurname(surname);
    }


    public List<User> getUserByRating(String rating){
        return userRepository.findUserByRating(rating);
    }

    public List<User> getUsersByRole(UserRole role){
        return userRepository.findUsersByRole(role);
    }

}
