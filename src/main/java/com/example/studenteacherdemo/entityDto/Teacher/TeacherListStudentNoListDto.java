package com.example.studenteacherdemo.entityDto.Teacher;

import com.example.studenteacherdemo.entityDto.Student.StudentListDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class TeacherListStudentNoListDto {

    private String name;
    private String lastName;
    private int age;
    private String eMail;
    private String subject;
    private List<StudentListDto> studentList;

}
