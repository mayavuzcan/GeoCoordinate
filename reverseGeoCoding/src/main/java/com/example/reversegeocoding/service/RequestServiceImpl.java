package com.example.reversegeocoding.service;

import com.example.reversegeocoding.model.Request;
import com.example.reversegeocoding.repository.RequestRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

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
    public ResponseEntity<Request> getRequest(Request request) {
        Request optionalRequest =
                repository.findByLongitudeAndLatitude(request.getLongitude(), request.getLatitude());

        return new ResponseEntity<>(optionalRequest, HttpStatus.OK);

    }

    @Override
    public ResponseEntity<String> saveAndGetRequest(Request request) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        final String uri = "https://maps.googleapis.com/maps/api/geocode/json?latlng="+request.getLatitude()+","+request.getLongitude()+"&key=AIzaSyC5__ph5uSMinywCZ2HQELkQKN7XexMzEs";
        try {


            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            Object result = restTemplate.getForObject(uri, Object.class);
            String json = ow.writeValueAsString(result);
            ObjectMapper mapper = new ObjectMapper();
            assert result != null;
            JsonNode array =  mapper.readValue(json, JsonNode.class);
            JsonNode object = array.get("results").get(0);
            if (object != null){
                saveRequest(request);
                return new ResponseEntity<>(object.get("formatted_address").textValue(), HttpStatus.OK);
            }else {
                throw new Exception("İstek Boş Döndü");
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
