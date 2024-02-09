package io.menglibay.realestateproject.service;

import io.menglibay.realestateproject.entity.Request;
import io.menglibay.realestateproject.repository.RequestRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RequestService {

    private final RequestRepository requestRepository;

    @Autowired
    public RequestService(RequestRepository requestRepository){
        this.requestRepository = requestRepository;
    }

    public List<Request> getAllRequests(){
        return requestRepository.findAll();
    }

    public Request getRequestById(int id) {
        return requestRepository.findById(id).orElse(null);
    }

    @Transactional
    public Request saveRequest(Request request){
        try{
            Request save = requestRepository.save(request);
            return save;
        } catch (Exception e){
            System.out.println("Request saved successfully");
            throw e;
        }
    }

    public void deleteRequest(int id){
        requestRepository.deleteById(id);
    }

    public List<Request> getRequestByName(String name){
        return requestRepository.findRequestByName(name);
    }

}
