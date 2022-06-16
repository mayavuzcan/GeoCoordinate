package com.example.reversegeocoding.repository;

import com.example.reversegeocoding.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Request,Long> {

}
