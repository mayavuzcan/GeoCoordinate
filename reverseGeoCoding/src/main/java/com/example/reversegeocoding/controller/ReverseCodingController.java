package com.example.reversegeocoding.controller;


import com.example.reversegeocoding.model.GeoCodeResponse;
import com.example.reversegeocoding.model.Request;
import com.example.reversegeocoding.service.GeoCodeResponseService;
import com.example.reversegeocoding.service.RequestService;
import com.fasterxml.jackson.core.JsonProcessingException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@CrossOrigin(origins = "http://localhost:8080/geo")
@RestController
@RequestMapping("/api")
public class ReverseCodingController {

    private final RequestService requestService;
    private final GeoCodeResponseService geoCodeResponseService;

    public ReverseCodingController(RequestService requestService, GeoCodeResponseService geoCodeResponseService) {
        this.requestService = requestService;
        this.geoCodeResponseService = geoCodeResponseService;
    }

    @PostMapping("/getGeoCode")
    public ResponseEntity<String> getGeoCoding(@RequestBody Request request) throws Exception {
        ResponseEntity<Request> req = requestService.getRequest(request);
        if (req.getBody() == null)
             return requestService.saveAndGetRequest(request);
        else
            return new ResponseEntity<>(
                    Objects.requireNonNull(geoCodeResponseService.get(request).getBody()).getAddress(), HttpStatus.OK);

    }
}
