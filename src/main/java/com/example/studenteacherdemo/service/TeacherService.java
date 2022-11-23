package com.example.studenteacherdemo.service;

import com.example.studenteacherdemo.Validator;
import com.example.studenteacherdemo.entity.Student;
import com.example.studenteacherdemo.entity.Teacher;
import com.example.studenteacherdemo.entityDto.Student.StudentListDto;
import com.example.studenteacherdemo.entityDto.Student.StudentListTeacherNoListDto;
import com.example.studenteacherdemo.entityDto.Teacher.TeacherDto;
import com.example.studenteacherdemo.entityDto.Teacher.TeacherListDto;
import com.example.studenteacherdemo.entityDto.Teacher.TeacherListStudentNoListDto;
import com.example.studenteacherdemo.exceptions.StudentException;
import com.example.studenteacherdemo.exceptions.repositeories.TeacherRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class TeacherService extends Validator {

    private final TeacherRepository teacherRepository;
    private final StudentService studentService;

    public TeacherService(StudentService studentService, TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
        this.studentService = studentService;
    }

    public Teacher createTeacher(TeacherDto teacherDto) {
        Teacher teacher = Teacher.builder()
                .name(teacherDto.getName())
                .lastName(teacherDto.getLastName())
                .age(teacherDto.getAge())
                .eMail(teacherDto.getEMail())
                .studentList(teacherDto.getStudentList())
                .subject(teacherDto.getSubject())
                .build();

        if(validation(teacher)){
            teacherRepository.save(teacher);
        }
        return teacher;
    }

    public Teacher saveTeacher(Teacher teacher){
        teacherRepository.save(teacher);
        return teacher;
    }

    public Teacher getTeacher(Long id) throws StudentException {
        return teacherRepository.findById(id).orElseThrow(() -> new StudentException("Teacher with id: " + id + " not found"));
    }

    public ArrayList<TeacherListDto> getAllTeachers() {
        ArrayList<Teacher> teachersWithList = new ArrayList();
        ArrayList<TeacherListDto> teachersWithoutList = new ArrayList();
        teacherRepository.findAll().forEach(teachersWithList::add);
        for (int i = 0; i < teachersWithList.size(); i++) {
            teachersWithoutList.add(new TeacherListDto(teachersWithList.get(i).getName(), teachersWithList.get(i).getLastName(),
                    teachersWithList.get(i).getAge(),teachersWithList.get(i).geteMail(),teachersWithList.get(i).getSubject(),
                    teachersWithList.get(i).getStudentList().size()));
        }
        return teachersWithoutList;
    }

    public TeacherListStudentNoListDto getTeacherListStudentsWithNoList(Long id) throws StudentException {
        Teacher teacher = teacherRepository.findById(id).orElseThrow(() -> new StudentException("Teacher with id: " + id + " not found"));
        ArrayList<StudentListDto> studentList = new ArrayList<>();
        for (int i = 0; i < teacher.getStudentList().size(); i++) {
            Student student = teacher.getStudentList().get(i);
            studentList.add(new StudentListDto(student.getName(),student.getLastName(),student.getAge(),
                    student.geteMail(),student.getFieldOfStudy(),student.getAllTeachers().size()));
        }
        TeacherListStudentNoListDto teacherListStudentNoListDto = new TeacherListStudentNoListDto(teacher.getName(),
                teacher.getLastName(),teacher.getAge(),teacher.geteMail(),teacher.getSubject(),studentList);

        return teacherListStudentNoListDto;
    }

    public Teacher updateTeacher(Long id, TeacherDto teacherDto) throws StudentException {
        Teacher teacher = getTeacher(id);
        teacher.setName(teacherDto.getName());
        teacher.setLastName(teacherDto.getLastName());
        teacher.setAge(teacherDto.getAge());
        teacher.setEMail(teacherDto.getEMail());
        teacher.setStudentList(teacherDto.getStudentList());
        teacher.setSubject(teacherDto.getSubject());
        return teacher;
    }

    public void deleteTeacher(Long id) throws StudentException {
        Teacher teacher = getTeacher(id);
        teacherRepository.delete(teacher);
    }

    public List<Student> getAllStudentFromTeacher(Long id) throws StudentException {
        Teacher teacher = getTeacher(id);
        return teacher.getStudentList();
    }
}
