package com.family.backend.service.mapper;

import com.family.backend.dto.IdNameLookup;
import com.family.backend.dto.TaskDto;
import com.family.backend.entity.Employee;
import com.family.backend.entity.Task;
import org.mapstruct.Mapper;

@Mapper
public interface TaskMapper {

    TaskDto toDto(Task entity);

    Task toEntity(TaskDto dto);

    default IdNameLookup mapEmployee(Employee employee) {
        return employee.toIdName();
    }

    default Employee mapEmployee(IdNameLookup idNameLookup) {
        Employee employee = new Employee();
        employee.setId(idNameLookup.getId());
        return employee;
    }
}
