package com.example.reversegeocoding.service;

import com.example.reversegeocoding.model.GeoCodeResponse;
import com.example.reversegeocoding.model.Request;
import com.example.reversegeocoding.repository.GeoCodeRepository;
import org.springframework.http.ResponseEntity;

public interface GeoCodeResponseService {

    ResponseEntity<GeoCodeResponse>  save(Request request,String adress) throws Exception;

    ResponseEntity<GeoCodeResponse> get(Request request) throws Exception;
}
