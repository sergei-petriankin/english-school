package com.family.backend.service.impl;

import com.family.backend.dto.TaskDto;
import com.family.backend.entity.Task;
import com.family.backend.repository.TaskRepository;
import com.family.backend.service.TaskService;
import com.family.backend.service.mapper.TaskMapper;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    @Override
    public Task save(TaskDto taskDto) {
        return taskRepository.save(taskMapper.toEntity(taskDto));
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task findById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("No task with id %s was found", id)));
    }

    @Override
    public Task update(Long id, TaskDto taskDto) {
        Task newTask = taskMapper.toEntity(taskDto);
        newTask.setId(id);
        return taskRepository.save(newTask);
    }

    @Override
    public void delete(Long id) {
        taskRepository.deleteById(id);
    }
}
