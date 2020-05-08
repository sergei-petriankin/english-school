package com.family.backend.service;

import com.family.backend.dto.TaskDto;
import com.family.backend.entity.Task;

import java.util.List;

public interface TaskService {

    Task save(TaskDto task);

    List<Task> findAll();

    Task findById(Long id);

    Task update(Long id, TaskDto taskDto);

    void delete(Long id);

}
