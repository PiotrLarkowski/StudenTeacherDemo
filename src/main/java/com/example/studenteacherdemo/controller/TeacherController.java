package com.example.studenteacherdemo.controller;

import com.example.studenteacherdemo.entity.Student;
import com.example.studenteacherdemo.entity.Teacher;
import com.example.studenteacherdemo.entityDto.Teacher.TeacherDto;
import com.example.studenteacherdemo.entityDto.Teacher.TeacherListDto;
import com.example.studenteacherdemo.entityDto.Teacher.TeacherListStudentNoListDto;
import com.example.studenteacherdemo.exceptions.StudentException;
import com.example.studenteacherdemo.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Teacher createTeacher(@RequestBody TeacherDto teacherDto){
        return teacherService.createTeacher(teacherDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TeacherListDto> getAllTeacher(){
        return teacherService.getAllTeachers();
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TeacherListStudentNoListDto getTeacherById(@PathVariable Long id) throws StudentException {
        return teacherService.getTeacherListStudentsWithNoList(id);
    }

    @GetMapping(path = "/studentformteacher/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Student> getAllStudentsFromTeacher(@PathVariable Long id) throws StudentException {
        return teacherService.getAllStudentFromTeacher(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Teacher updateTeacher(@PathVariable Long id, TeacherDto teacherDto) throws StudentException {
        return teacherService.updateTeacher(id,teacherDto);
    }

    @DeleteMapping(path="{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteTeacher(@PathVariable Long id) throws StudentException {
        teacherService.deleteTeacher(id);
    }


}
