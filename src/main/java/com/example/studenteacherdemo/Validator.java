package com.example.studenteacherdemo;

import com.example.studenteacherdemo.entity.Student;
import com.example.studenteacherdemo.entity.Teacher;
import com.example.studenteacherdemo.service.StudentService;
import lombok.extern.slf4j.Slf4j;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class Validator {

    protected boolean validation(validateGeters object) {
        if (validateEmail(object.geteMail())) {
            if (validateNameAndLastNameLong(object.getName(), object.getLastName())) {
                if (validateAge(object.getAge())) {
                    return true;
                } else {
                    log.warn("Can't create student with age below 18 years old:" + object.getAge());
                }
            } else {
                log.warn("Can't create student with name or lastName shorter than two characters: " + object.getName() + ", " + object.getLastName());
            }
        } else {
            log.warn("Can't create student with wrong E-mail address: " + object.geteMail());
        }
        return false;
    }

    protected boolean validateAge(int age) {
        boolean validate = age > 18;
        return validate;
    }

    protected boolean validateNameAndLastNameLong(String name, String lastName) {
        boolean validate = name.length() > 2 && lastName.length() > 2;
        return validate;
    }

    protected boolean validateEmail(String eMail) {
        String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher;

        matcher = pattern.matcher(eMail);
        return matcher.matches();
    }


}
