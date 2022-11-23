package com.example.studenteacherdemo.exceptions.repositeories;

import com.example.studenteacherdemo.entity.Teacher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher, Long> {
}