package com.family.backend.entity;

import com.family.backend.enums.TaskStatus;

import javax.persistence.Entity;

@Entity
public class Task extends AbstractEntity {
    private String name;
    private String description;
    private TaskStatus status;
}
