package com.example.reversegeocoding.service;

import com.example.reversegeocoding.model.Request;
import com.example.reversegeocoding.repository.RequestRepository;
import org.springframework.stereotype.Service;

@Service
public class RequestServiceImpl implements RequestService {

    private final RequestRepository repository;

    public RequestServiceImpl(RequestRepository repository) {
        this.repository = repository;
    }


    @Override
    public Request saveRequest(Request request) {
        return repository.save(request);
    }

    @Override
    public Request getRequest(Request request) {
        return null;
    }
}
