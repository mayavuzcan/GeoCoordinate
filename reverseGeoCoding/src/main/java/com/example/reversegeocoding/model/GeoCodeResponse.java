package com.example.reversegeocoding.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "GEO_CODE_RESPONSE")
public class GeoCodeResponse extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;

    @Override
    public Long getId() {
        return null;
    }
}
