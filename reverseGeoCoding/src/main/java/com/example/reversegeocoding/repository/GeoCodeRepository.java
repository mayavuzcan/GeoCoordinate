package com.example.reversegeocoding.repository;

import com.example.reversegeocoding.model.GeoCodeResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface GeoCodeRepository extends JpaRepository<GeoCodeResponse,Long> {

    Optional<GeoCodeResponse> findByLongitudeAndLatitude(String longitude, String latitude);

}
