package io.menglibay.realestateproject.controller;

import io.menglibay.realestateproject.model.User;
import io.menglibay.realestateproject.model.UserRole;
import io.menglibay.realestateproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    private final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User getUserById(@PathVariable int id) {
        User user = userService.getUserById(id);
        if (user != null) {
            return user;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with ID: " + id);
        }
    }


    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public List<User> createMultipleUsers(@RequestBody List<User> users) {
        List<User> savedUsers = new ArrayList<>();

        for (User user : users) {
            savedUsers.add(userService.saveUser(user));
        }

        return savedUsers;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User updateUser(@PathVariable int id, @RequestBody User updatedUserData) {
        Optional<User> existingUser = Optional.ofNullable(userService.getUserById(id));

        return existingUser.map(user -> {
            // Обновить данные пользователя
            user.setName(updatedUserData.getName());
            user.setSurname(updatedUserData.getSurname());
            user.setIin(updatedUserData.getIin());
            user.setNumber(updatedUserData.getNumber());
            user.setRating(updatedUserData.getRating());
            user.setAdditional(updatedUserData.getAdditional());
            // Другие обновления данных пользователя

            // Сохранить обновленного пользователя
            return userService.saveUser(user);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with ID: " + id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }

    @GetMapping("/byName/{name}")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getUserByName(@PathVariable String name) {
        return userService.getUserByName(name);
    }

    @GetMapping("/bySurname/{surname}")
    public ResponseEntity<List<User>> findUsersBySurname(@PathVariable String surname) {
        List<User> users = userService.getUserBySurname(surname);

        if (users.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No users found with surname: " + surname);
        } else {
            return new ResponseEntity<>(users, HttpStatus.OK);
        }
    }

    @GetMapping("/byRating/{rating}")
    public ResponseEntity<List<User>> findUserByRating(@PathVariable String rating) {
        List<User> users = userService.getUserByRating(rating);

        if (users.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No users found with rating: " + rating);
        } else {
            return new ResponseEntity<>(users, HttpStatus.OK);
        }
    }

    @GetMapping("/byRole/{role}")
    public ResponseEntity<List<User>> findUsersByRole(@PathVariable UserRole userRole){
        List<User> users = userService.getUsersByRole(userRole);

        if(users.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No users found with role: " + userRole);
        } else {
            return new ResponseEntity<>(users,HttpStatus.OK);
        }
    }

}
