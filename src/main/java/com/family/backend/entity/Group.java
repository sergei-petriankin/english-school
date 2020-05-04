package com.family.backend.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.Set;

@Entity
public class Group extends AbstractEntity {

    private String name;

    @ManyToOne
    private Teacher teacher;

    @ManyToMany
    private Set<Student> students;
}
