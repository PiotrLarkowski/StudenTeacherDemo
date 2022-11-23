package com.example.studenteacherdemo.entityDto.Student;

import com.example.studenteacherdemo.entity.Teacher;
import com.example.studenteacherdemo.entityDto.Teacher.TeacherListDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class StudentListTeacherNoListDto {
    private String name;
    private String lastName;
    private int age;
    private String eMail;
    private String fieldOfStudy;
    private List<TeacherListDto> teacherList;

}
