package com.example.reversegeocoding.model;


import lombok.Data;
import org.hibernate.annotations.AccessType;

import javax.persistence.*;

@Data
@Entity
@Table(name = "REQUEST")
public class Request extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;

    @Column(name = "longitude", nullable = false)
    private String longitude;

    @Column(name = "latitude", nullable = false)
    private String latitude;

    @Column(name = "radius", nullable = false)
    private String radius;


    @Override
    public Long getId() {
        return null;
    }
}
