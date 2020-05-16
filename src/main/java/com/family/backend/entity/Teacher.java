package com.family.backend.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Teacher extends AbstractEntity {

    @Embedded
    private PersonData personData;

    @ManyToMany
    private Set<Language> languages;

    @OneToMany
    private Set<Group> groups;

    public String getFullName() {
        return personData.getFullName();
    }
}