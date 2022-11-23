package com.example.studenteacherdemo.entityDto.Student;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StudentListDto {
    private String name;
    private String lastName;
    private int age;
    private String eMail;
    private String fieldOfStudy;
    private int TeacherListDtoSize;
}
