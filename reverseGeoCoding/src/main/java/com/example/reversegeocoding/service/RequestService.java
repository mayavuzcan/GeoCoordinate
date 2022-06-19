package com.example.reversegeocoding.service;

import com.example.reversegeocoding.model.Request;
import org.springframework.http.ResponseEntity;

public interface RequestService {
    Request saveRequest(Request request);
    ResponseEntity<Request> getRequest(Request request) throws Exception;

    ResponseEntity<String> saveAndGetRequest(Request request) throws Exception;
}
