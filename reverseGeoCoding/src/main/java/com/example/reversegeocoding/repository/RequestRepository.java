package com.example.reversegeocoding.repository;

import com.example.reversegeocoding.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RequestRepository extends JpaRepository<Request,Long> {

    Request findByLongitudeAndLatitude(String longitude, String latitude);

}
