package io.menglibay.realestateproject.controller;

import io.menglibay.realestateproject.entity.Request;
import io.menglibay.realestateproject.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
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
        return ResponseEntity.ok().body(requests);
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Request getRequestById(@PathVariable int id) {
        return service.getRequestById(id);
    }


//    @PostMapping("/create")
//    @ResponseStatus(HttpStatus.CREATED)
//    public List<Request> createMultipleRequests(@RequestBody List<Request> requests) {
//        List<Request> savedRequests = new ArrayList<>();
//        for (Request req : requests) {
//            savedRequests.add(service.saveRequest(req));
//        }
//
//        return savedRequests;
//    }
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Request createRequest(@RequestBody Request request) {
        // Save the request using the service
        return service.saveRequest(request);
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Request updateRequest(@PathVariable int id, @RequestBody Request updateReq) {
        if (updateReq == null || updateReq.getName() == null || updateReq.getIin() == null || updateReq.getNumber() == null || updateReq.getStatus() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Request body is null or contains invalid data");
        }

        Request existingReq = service.getRequestById(id);
        if (existingReq == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Request not found with id: " + id);
        }

        existingReq.setName(updateReq.getName());
        existingReq.setIin(updateReq.getIin());
        existingReq.setNumber(updateReq.getNumber());
        existingReq.setStatus(updateReq.getStatus());

        return service.saveRequest(existingReq);
    }



    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRequest(@PathVariable int id) {
        service.deleteRequest(id);
    }


}
