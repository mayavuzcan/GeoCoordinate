package com.example.reversegeocoding.model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.AccessType;

import javax.persistence.*;


@Entity
@Table(name = "REQUEST")
@Getter
@Setter
@ToString
public class Request extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Column(name = "longitude", nullable = false)
    private String longitude;

    @Column(name = "latitude", nullable = false)
    private String latitude;

    @Column(name = "radius")
    private String radius;


    @Override
    public Long getId() {
        return null;
    }
}
