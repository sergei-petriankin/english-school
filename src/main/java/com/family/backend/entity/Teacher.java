package com.family.backend.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Teacher extends AbstractEntity {

    private String firstName;

    private String middleName;

    private String lastName;

    private String phoneNumber;

    @ManyToMany
    private Set<Language> languages;

    @OneToMany
    private Set<Group> groups;
}