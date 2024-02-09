package io.menglibay.realestateproject.repository;

import io.menglibay.realestateproject.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequestRepository extends JpaRepository<Request,Integer> {

    List<Request> findRequestByName(String name);
}
