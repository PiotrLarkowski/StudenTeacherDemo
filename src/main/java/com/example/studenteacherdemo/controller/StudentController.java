package com.example.studenteacherdemo.controller;

import com.example.studenteacherdemo.entity.Student;
import com.example.studenteacherdemo.entity.Teacher;
import com.example.studenteacherdemo.entityDto.Student.StudentDto;
import com.example.studenteacherdemo.entityDto.Student.StudentListDto;
import com.example.studenteacherdemo.entityDto.Student.StudentListTeacherNoListDto;
import com.example.studenteacherdemo.entityDto.Teacher.TeacherListDto;
import com.example.studenteacherdemo.exceptions.StudentException;
import com.example.studenteacherdemo.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody StudentDto studentDto){
        return studentService.createStudent(studentDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<StudentListDto> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping(path = "/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public List<StudentListDto> getStudentByName(@PathVariable String name) throws StudentException {
        return studentService.getStudentByName(name);
    }

    @GetMapping(path = "/lastname/{name}")
    @ResponseStatus(HttpStatus.OK)
    public List<StudentListDto> getStudentByLastName(@PathVariable String name) throws StudentException {
        return studentService.getStudentByLastName(name);
    }
    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StudentListTeacherNoListDto getStudent(@PathVariable Long id) throws StudentException {
        return studentService.getStudentListTeacherWithNoList(id);
    }

    @GetMapping(path = "/teacherfromstudent/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Teacher> getAllTeachers(@PathVariable Long id) throws StudentException {
        return studentService.getAllTeachersFromStudentByName(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Student updateStudent(@PathVariable Long id, @RequestBody StudentDto studentDto) throws StudentException {
        return studentService.updateStudent(id, studentDto);
    }

    @DeleteMapping(path = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudent(@PathVariable Long id) throws StudentException {
        studentService.deleterStudent(id);
    }
}
