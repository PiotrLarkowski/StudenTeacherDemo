package com.example.studenteacherdemo.entityDto.Student;
import com.example.studenteacherdemo.entity.Teacher;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
@Getter
@AllArgsConstructor
public class StudentDto {
        private String name;
        private String lastName;
        private int age;
        private String eMail;
        private String fieldOfStudy;

        private List<Teacher> teacherList;

    @Override
    public String toString() {
        return "StudentDto{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", eMail='" + eMail + '\'' +
                ", fieldOfStudy='" + fieldOfStudy + '\'' +
                ", teacherList=" + teacherList +
                '}';
    }
}
