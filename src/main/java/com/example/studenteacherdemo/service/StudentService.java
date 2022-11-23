package com.example.studenteacherdemo.service;

import com.example.studenteacherdemo.Validator;
import com.example.studenteacherdemo.entity.Student;
import com.example.studenteacherdemo.entity.Teacher;
import com.example.studenteacherdemo.entityDto.Student.StudentDto;
import com.example.studenteacherdemo.entityDto.Student.StudentListDto;
import com.example.studenteacherdemo.entityDto.Student.StudentListTeacherNoListDto;
import com.example.studenteacherdemo.entityDto.Teacher.TeacherListDto;
import com.example.studenteacherdemo.exceptions.StudentException;
import com.example.studenteacherdemo.exceptions.repositeories.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class StudentService extends Validator {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(StudentDto studentDto) {
        Student student = Student.builder()
                .name(studentDto.getName())
                .lastName(studentDto.getLastName())
                .age(studentDto.getAge())
                .eMail(studentDto.getEMail())
                .teacherList(studentDto.getTeacherList())
                .fieldOfStudy(studentDto.getFieldOfStudy())
                .build();
        if (validation(student)) {
            studentRepository.save(student);
        }
        return student;
    }

    public Student getStudent(Long id) throws StudentException {
        return studentRepository.findById(id).orElseThrow(() -> new StudentException("Student with id: " + id + " not found"));
    }

    public StudentListTeacherNoListDto getStudentListTeacherWithNoList(Long id) throws StudentException {
        Student student = studentRepository.findById(id).orElseThrow(() -> new StudentException("Student with id: " + id + " not found"));
        ArrayList<TeacherListDto> teachersList = new ArrayList<>();
        for (int i = 0; i < student.getAllTeachers().size(); i++) {
            Teacher teacher = student.getAllTeachers().get(i);
            teachersList.add(new TeacherListDto(teacher.getName(),teacher.getLastName(),teacher.getAge(),
                    teacher.geteMail(),teacher.getSubject(),teacher.getStudentList().size()));
        }
        StudentListTeacherNoListDto studentListTeacherNoListDto = new StudentListTeacherNoListDto(student.getName(),
                student.getLastName(),student.getAge(),student.geteMail(),student.getFieldOfStudy(),teachersList);

        return studentListTeacherNoListDto;
    }

    public ArrayList<StudentListDto> getAllStudents() {
        ArrayList<Student> studentsWithList = new ArrayList();
        ArrayList<StudentListDto> studentsWithoutList = new ArrayList();
        studentRepository.findAll().forEach(studentsWithList::add);
        for (int i = 0; i < studentsWithList.size(); i++) {
            studentsWithoutList.add(new StudentListDto(studentsWithList.get(i).getName(), studentsWithList.get(i).getLastName(),
                    studentsWithList.get(i).getAge(),studentsWithList.get(i).geteMail(),studentsWithList.get(i).getFieldOfStudy(),
                    studentsWithList.get(i).getAllTeachers().size()));
        }
        return studentsWithoutList;
    }

    public Student updateStudent(Long id, StudentDto studentDto) throws StudentException {
        Student student = getStudent(id);
        student.setName(studentDto.getName());
        student.setLastName(studentDto.getLastName());
        student.setAge(studentDto.getAge());
        student.setEMail(studentDto.getEMail());
        student.setTeacherList(studentDto.getTeacherList());
        student.setFieldOfStudy(studentDto.getFieldOfStudy());
        studentRepository.save(student);
        return student;
    }

    public void deleterStudent(Long id) throws StudentException {
        Student student = getStudent(id);
        studentRepository.delete(student);
    }

    public Student saveStudent(Student student){
        studentRepository.save(student);
        return student;
    }
    public List<Teacher> getAllTeachersFromStudentByName(Long id) throws StudentException {
        Student student = getStudent(id);
        student.getAllTeachers().stream()
                .sorted(Comparator.comparing(Teacher::getName))
                .collect(Collectors.toList());
        return student.getAllTeachers();
    }
}
