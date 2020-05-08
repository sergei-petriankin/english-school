package com.family.backend.dto;

import com.family.backend.enums.Priority;
import com.family.backend.enums.TaskStatus;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TaskDto {

    private String name;

    private String description;

    private LocalDate dueDate;

    private Priority priority;

    private IdNameLookup responsibleEmployee;

    private TaskStatus status;
}
