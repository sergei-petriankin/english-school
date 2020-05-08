package com.family.backend.service.mapper;

import com.family.backend.dto.TaskDto;
import com.family.backend.entity.Task;
import org.assertj.core.api.Assertions;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

class TaskMapperTest {
    EasyRandom generator = new EasyRandom();
    TaskMapper mapper = Mappers.getMapper(TaskMapper.class);

    @Test
    void shouldMapToDto() {
        Task task = generator.nextObject(Task.class);
        TaskDto taskDto = mapper.toDto(task);

        Assertions.assertThat(taskDto).hasNoNullFieldsOrProperties();
    }

    @Test
    void shouldMapToEntity() {
        TaskDto taskDto = generator.nextObject(TaskDto.class);
        Task task = mapper.toEntity(taskDto);

        Assertions.assertThat(task).hasNoNullFieldsOrPropertiesExcept("id");
    }
}