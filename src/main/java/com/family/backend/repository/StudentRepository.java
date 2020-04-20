package com.family.backend.repository;

import com.family.backend.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("select s from Student s " +
            "where lower(s.firstName) like lower(concat('%', :searchTerm, '%')) " +
            "or lower(s.lastName) like lower(concat('%', :searchTerm, '%'))")
    List<Student> search(@Param("searchTerm") String searchTerm);

}
