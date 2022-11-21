package com.example.studenteacherdemo;

import lombok.extern.apachecommons.CommonsLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

@Slf4j
@Component
public class StudentTeacherExample extends Validator implements CommandLineRunner {

    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;

    public StudentTeacherExample(StudentRepository studentRepository, TeacherRepository teacherRepository) {
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Student studentOne = Student.builder()
                .name("John")
                .lastName("Milton")
                .age(20)
                .eMail("jMilton@gmail.com")
                .teacherList(new ArrayList<>())
                .fieldOfStudy("Informatics")
                .build();

        validation(studentOne);

        Student studentTwo = new Student.StudentBuilder()
                .name("Tom")
                .lastName("Horwat")
                .age(19)
                .eMail("tomy197264@gmail.com")
                .teacherList(new ArrayList<>())
                .fieldOfStudy("Informatics")
                .build();

        validation(studentTwo);

        Student studentThree = new Student.StudentBuilder()
                .name("Adam")
                .lastName("Tery")
                .age(20)
                .eMail("tery11221121@gmail")
                .teacherList(new ArrayList<>())
                .fieldOfStudy("Informatics")
                .build();

        validation(studentThree);

        Teacher teacherOne = Teacher.builder()
                .name("Frank")
                .lastName("Colton")
                .age(34)
                .eMail("frank.contan@lerningPlatform.com")
                .studentList(new ArrayList<>())
                .subject("Informatics")
                .build();

        validation(teacherOne);

        Teacher teacherTwo = Teacher.builder()
                .name("Tim")
                .lastName("Marey")
                .age(44)
                .eMail("tim.marly@lerningPlatform.com")
                .studentList(new ArrayList<>())
                .subject("Informatics")
                .build();

        validation(teacherTwo);

        teacherOne.addStudent(studentOne);
        studentOne.addTeacher(teacherOne);

        teacherOne.addStudent(studentTwo);
        studentTwo.addTeacher(teacherOne);

        teacherTwo.addStudent(studentTwo);
        studentTwo.addTeacher(teacherTwo);

        System.out.println("Students:");
        System.out.println(studentOne);
        System.out.println(studentTwo);

        System.out.println("Teachers:");
        System.out.println(teacherOne);
        System.out.println(teacherTwo);

    }

    private void validation(validateGeters object) {
        if (validateEmail(object.geteMail())) {
            if (validateNameAndLastNameLong(object.getName(), object.getLastName())) {
                if (validateAge(object.getAge())) {
                    if(object instanceof Student){
                        saveStudent(object);
                    }else{
                        saveTeacher(object);
                    }
                } else {
                    log.warn("Can't create student with age below 18 years old:" + object.getAge());
                }
            } else {
                log.warn("Can't create student with name or lastName shorter than two characters: " + object.getName() + ", " + object.getLastName());
            }
        } else {
            log.warn("Can't create student with wrong E-mail address: " + object.geteMail());
        }
    }

    private void saveStudent(validateGeters student) {
        studentRepository.save((Student)student);
    }

    private void saveTeacher(validateGeters teacher) {
        teacherRepository.save((Teacher)teacher);
    }
}
