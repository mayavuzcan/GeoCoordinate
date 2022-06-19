package com.example.reversegeocoding.model;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public abstract class IdBasedEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    public abstract Long getId();


}
