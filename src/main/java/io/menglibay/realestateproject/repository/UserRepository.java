package io.menglibay.realestateproject.repository;

import io.menglibay.realestateproject.model.User;
import io.menglibay.realestateproject.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {

    List<User> findUserByName(String name);

    List<User> findUserBySurname(String surname);


    List<User> findUserByRating(String rating);

    List<User> findUsersByRole(UserRole role);

}
