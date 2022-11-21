package com.example.studenteacherdemo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Teacher implements validateGeters{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private int age;
    private String eMail;
    private String subject;
    @ManyToMany
    private List<Student> studentList;

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String geteMail() {
        return eMail;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", eMail='" + eMail + '\'' +
                ", subject='" + subject + '\'' +
                ", students='" + studentList.size() + '\'' +
                '}';
    }

    public void addStudent(Student student){
        studentList.add(student);
    }

    public void removeStudent(Student student){
        studentList.remove(student);
    }
}
