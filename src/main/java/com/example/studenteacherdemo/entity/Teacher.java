package com.example.studenteacherdemo.entity;

import com.example.studenteacherdemo.validateGeters;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@ToString
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Teacher implements validateGeters {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private int age;
    private String eMail;
    private String subject;
    @ManyToMany(fetch = FetchType.EAGER)
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

    public String getSubject(){
        return subject;
    }
    public List<Student> getStudentList(){
        return studentList;
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
