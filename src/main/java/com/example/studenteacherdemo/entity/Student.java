package com.example.studenteacherdemo.entity;

import com.example.studenteacherdemo.validateGeters;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@ToString
@AllArgsConstructor
@Builder
@Setter
@NoArgsConstructor
public class Student implements validateGeters {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private int age;
    private String eMail;
    private String fieldOfStudy;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Teacher> teacherList;
    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public String geteMail() {
        return eMail;
    }

    public List<Teacher> getAllTeachers(){
        return teacherList;
    }

    public String getFieldOfStudy(){
        return fieldOfStudy;
    }

    public void addTeacher(Teacher teacher) {
        teacherList.add(teacher);
    }

    public void removeTeacher(Teacher teacher) {
        teacherList.remove(teacher);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", eMail='" + eMail + '\'' +
                ", fieldOfStudy='" + fieldOfStudy + '\'' +
                ", teachers='" + teacherList.size() + '\'' +
                '}';
    }
}
