package com.family.backend.entity;

import com.family.backend.enums.Priority;
import com.family.backend.enums.TaskStatus;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class Task extends AbstractEntity {

    private String name;

    private String description;

    private LocalDate dueDate;

    private Priority priority;

    @ManyToOne
    private Employee responsibleEmployee;

    private TaskStatus status;
}
