package com.example.studenteacherdemo;

import com.example.studenteacherdemo.entity.Student;
import com.example.studenteacherdemo.entity.Teacher;
import com.example.studenteacherdemo.entityDto.Student.StudentDto;
import com.example.studenteacherdemo.entityDto.Teacher.TeacherDto;
import com.example.studenteacherdemo.service.StudentService;
import com.example.studenteacherdemo.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Slf4j
@Component
public class InputExampleData extends Validator implements CommandLineRunner {

    private final StudentService studentService;
    private final TeacherService teacherService;

    public InputExampleData(StudentService studentService, TeacherService teacherService) {
        this.studentService = studentService;
        this.teacherService = teacherService;
    }

    @Override
    public void run(String... args) throws Exception {

        studentService.createStudent(new StudentDto("John","Milton",20,
                "jMilton@gmail.com","Informatics",new ArrayList<>()));

        studentService.createStudent(new StudentDto("Tom","Horwat",19,
                "tomy197264@gmail.com","Informatics",new ArrayList<>()));

        studentService.createStudent(new StudentDto("Adam","Tery",25,
                "tery11221121@gmail","Informatics",new ArrayList<>()));

        teacherService.createTeacher(new TeacherDto("Frank","Colton",34,
                "frank.contan@lerningPlatform.com","Informatics",new ArrayList<>()));

        teacherService.createTeacher(new TeacherDto("Tim","Marey",44,
                "tim.marly@lerningPlatform.com","Engineering",new ArrayList<>()));

        Student student = studentService.getStudent(1l);
        Student student1 = studentService.getStudent(2l);
        Teacher teacher = teacherService.getTeacher(1l);
        Teacher teacher1 = teacherService.getTeacher(2l);

        teacher.addStudent(student);
        student.addTeacher(teacher);

        teacher.addStudent(student1);
        student1.addTeacher(teacher);

        teacher1.addStudent(student1);
        student1.addTeacher(teacher1);

        studentService.saveStudent(student);
        studentService.saveStudent(student1);

        teacherService.saveTeacher(teacher);
        teacherService.saveTeacher(teacher1);

        System.out.println("Students:");
        System.out.println(student);
        System.out.println(student1);

        System.out.println("Teachers:");
        System.out.println(teacher);
        System.out.println(teacher1);

    }
}
