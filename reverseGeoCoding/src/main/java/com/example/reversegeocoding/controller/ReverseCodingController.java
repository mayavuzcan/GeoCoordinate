package com.example.reversegeocoding.controller;


import com.example.reversegeocoding.model.Request;
import com.example.reversegeocoding.service.RequestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ReverseCodingController {

    private final RequestService requestService;

    public ReverseCodingController(RequestService requestService) {
        this.requestService = requestService;
    }

    @GetMapping("/getGeoCode")
    public Request getGeoCoding(Request request){
        return requestService.getRequest(request);
    }
}
