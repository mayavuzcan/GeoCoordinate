package com.example.reversegeocoding.service;


import com.example.reversegeocoding.model.GeoCodeResponse;
import com.example.reversegeocoding.model.Request;
import com.example.reversegeocoding.repository.GeoCodeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GeoCodeResponseServiceImpl implements GeoCodeResponseService{
    private final GeoCodeRepository geoCodeRepository;

    public GeoCodeResponseServiceImpl(GeoCodeRepository geoCodeRepository) {
        this.geoCodeRepository = geoCodeRepository;
    }

    @Override
    public ResponseEntity<GeoCodeResponse> save(Request request, String adress) throws Exception {

        try {
            GeoCodeResponse geoCodeResponse = new GeoCodeResponse();
            geoCodeResponse.setLatitude(request.getLatitude());
            geoCodeResponse.setLongitude(request.getLongitude());
            geoCodeResponse.setAddress(adress);
            geoCodeRepository.save(geoCodeResponse);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            throw new Exception(e);
        }

    }

    @Override
    public ResponseEntity<GeoCodeResponse> get(Request request) throws Exception {

        Optional<GeoCodeResponse> geoCodeResponse =
                geoCodeRepository.findByLongitudeAndLatitude(request.getLongitude(), request.getLatitude());
        if (geoCodeResponse.isPresent())
            return new ResponseEntity<>(geoCodeResponse.get(), HttpStatus.OK);
        else
            throw new Exception("Hata");
    }
}
