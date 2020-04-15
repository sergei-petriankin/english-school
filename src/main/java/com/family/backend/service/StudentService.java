package com.family.backend.service;

import com.family.backend.entity.Student;
import com.family.backend.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    StudentRepository studentRepository;

    public List<Student> findAll() {
        return studentRepository.findAll();
    }
}
