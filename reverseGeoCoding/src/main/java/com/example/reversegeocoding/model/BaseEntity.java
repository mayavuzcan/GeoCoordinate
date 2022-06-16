package com.example.reversegeocoding.model;

import com.example.reversegeocoding.type.Status;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public abstract class BaseEntity extends IdBasedEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Version
    @Column(nullable = false)
    private Integer version;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status = Status.ACTIVE;


    @Transient
    private Boolean selected = false;


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {//NOSONAR

        if (this == obj)
            return true;
        if (obj == null)
            return false;

        BaseEntity other = (BaseEntity) obj;

        if (getId() == null) {
            return super.equals(obj);
        }
        return getId().equals(other.getId());
    }


    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        throw new RuntimeException(
                "you are not allowed to use this method. It is internally used by persistence api.");
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


    public Boolean getSelected() {
        return selected;
    }


    public void setSelected(Boolean selected) {
        this.selected = selected;
    }
}