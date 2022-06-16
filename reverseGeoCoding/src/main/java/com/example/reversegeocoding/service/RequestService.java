package com.example.reversegeocoding.service;

import com.example.reversegeocoding.model.Request;

public interface RequestService {
    Request saveRequest(Request request);
    Request getRequest(Request request);
}
