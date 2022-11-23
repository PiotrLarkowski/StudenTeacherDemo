package com.example.studenteacherdemo.entityDto.Teacher;

import com.example.studenteacherdemo.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class TeacherDto {
    private String name;
    private String lastName;
    private int age;
    private String eMail;
    private String subject;
    private List<Student> studentList;

}
