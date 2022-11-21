package com.example.studenteacherdemo;

import org.apache.commons.validator.routines.EmailValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    boolean validateAge(int age) {
        boolean validate = age > 18;
        return validate;
    }

    boolean validateNameAndLastNameLong(String name, String lastName) {
        boolean validate = name.length() > 2 && lastName.length() > 2;
        return validate;
    }

    boolean validateEmail(String eMail) {
        String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher;

        matcher = pattern.matcher(eMail);
        return matcher.matches();
    }

}
