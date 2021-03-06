package com.family.backend.service;

import com.family.backend.entity.Student;
import com.family.backend.enums.EducationType;
import com.family.backend.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> findAll(String stringFilter) {
        if (stringFilter == null || stringFilter.isEmpty()) {
            return studentRepository.findAll();
        } else {
            return studentRepository.search(stringFilter);
        }
    }

    public void delete(Student student) {
        studentRepository.delete(student);
    }

    @PostConstruct
    public void populateTestData() {
        if (studentRepository.count() == 0) {
            Random r = new Random(0);
            studentRepository.saveAll(
                    Stream.of("Ivan Ivanov", "Petr Petrov", "Sidor Sidorov",
                            "John Doe", "Jane Doe", "Lorem Ipsum")
                            .map(name -> {
                                String[] split = name.split(" ");
                                Student student = new Student();
                                student.setFirstName(split[0]);
                                student.setLastName(split[1]);
                                student.setEducationType(EducationType.values()[r.nextInt(EducationType.values().length)]);
                                return student;
                            }).collect(Collectors.toList()));
        }
    }
}
