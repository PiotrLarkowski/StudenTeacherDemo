package com.example.studenteacherdemo.exceptions.repositeories;

import com.example.studenteacherdemo.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
}
