package io.menglibay.realestateproject.controller;

import io.menglibay.realestateproject.model.Request;
import io.menglibay.realestateproject.model.User;
import io.menglibay.realestateproject.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/request")
public class RequestController {

    private final RequestService service;


    @Autowired
    public RequestController(RequestService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Request>> getAllRequests() {
        List<Request> requests = service.getAllRequests();
        return ResponseEntity.ok(requests);
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Request getRequestById(@PathVariable int id) {
        return service.getRequestById(id);
    }


    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Request> createMultipleUsers(@RequestBody List<Request> requests) {
        List<Request> savedRequests = new ArrayList<>();
        for (Request req : requests) {
            savedRequests.add(service.saveRequest(req));
        }

        return savedRequests;
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Request updateRequest(@PathVariable int id, @RequestBody Request updateReq) {
        Optional<Request> existingReq = Optional.ofNullable(service.getRequestById(id));

        return existingReq.map(req -> {
            req.setName(updateReq.getName());
            req.setIin(updateReq.getIin());
            req.setNumber(updateReq.getNumber());
            req.setStatus(updateReq.getStatus());
            return service.saveRequest(req);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRequest(@PathVariable int id) {
        service.deleteRequest(id);
    }


}
