package com.family.backend.entity;

import com.family.backend.enums.Language;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Teacher extends AbstractEntity {

    private String firstName;

    private String middleName;

    private String lastName;

    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private Set<Language> languages;

    @OneToMany
    private Set<Group> groups;
}