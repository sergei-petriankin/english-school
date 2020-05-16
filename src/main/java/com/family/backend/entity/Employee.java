package com.family.backend.entity;

import lombok.Data;

import javax.persistence.Embedded;
import javax.persistence.Entity;

@Data
@Entity
public class Employee extends AbstractEntity {

    @Embedded
    private PersonData personData;

    public String getFullName() {
        return personData.getFullName();
    }
}
