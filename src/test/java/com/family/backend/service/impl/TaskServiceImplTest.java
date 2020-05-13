package com.family.backend.service.impl;

import com.family.Application;
import com.family.backend.dto.IdNameLookup;
import com.family.backend.dto.TaskDto;
import com.family.backend.entity.Employee;
import com.family.backend.repository.EmployeeRepository;
import com.family.backend.repository.TaskRepository;
import com.family.backend.service.TaskService;
import com.family.backend.service.TestPostgresqlContainer;
import com.family.backend.service.mapper.TaskMapper;
import org.jeasy.random.EasyRandom;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.PostgreSQLContainer;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TaskServiceImplTest {

    EasyRandom generator = new EasyRandom();
    @Autowired
    TaskService taskService;
    @Autowired
    TaskRepository taskRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    TaskMapper taskMapper;

    @ClassRule
    public static PostgreSQLContainer postgreSQLContainer = TestPostgresqlContainer.getInstance();

    @Test
    public void when_saveAndGetTask_then_savedSuccessfully() {
        Employee employee = employeeRepository.save(generator.nextObject(Employee.class));
        TaskDto taskDtoToSave = generator.nextObject(TaskDto.class);
        taskDtoToSave.setResponsibleEmployee(IdNameLookup.of(employee.getId(), employee.getFullName()));

        TaskDto savedTaskDto = taskService.save(taskDtoToSave);

        assertThat(savedTaskDto).hasNoNullFieldsOrProperties();
        assertThat(savedTaskDto).isEqualToIgnoringGivenFields(taskDtoToSave, "id");
    }
}