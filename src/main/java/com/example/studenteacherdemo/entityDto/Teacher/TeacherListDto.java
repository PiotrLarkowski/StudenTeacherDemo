package com.example.studenteacherdemo.entityDto.Teacher;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TeacherListDto {
    private String name;
    private String lastName;
    private int age;
    private String eMail;
    private String subject;
    private int studentListSize;
}
