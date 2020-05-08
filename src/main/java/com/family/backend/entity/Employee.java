package com.family.backend.entity;

import com.family.backend.dto.IdNameLookup;

import javax.persistence.Entity;

@Entity
public class Employee extends AbstractEntity {

    private String firstName;

    private String middleName;

    private String lastName;

    public IdNameLookup toIdName() {
        return IdNameLookup.of(this.getId(), String.format("%s %s %s", firstName, middleName, lastName));
    }
}
