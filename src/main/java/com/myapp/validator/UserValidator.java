package com.myapp.validator;

import com.myapp.model.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.*;

@Component
public class UserValidator implements Validator {


    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        User u = (User)o;
        String username= u.getUsername();
        if (username.length()<5){
            FieldError userError = new FieldError("username", "username", "User Should be more than 5 char");
            ((BindingResult)errors).addError(userError);
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "error.username", "Username is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.password", "Password  is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", "error.firstName", "First name is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastname", "error.lastName", "Last name is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "error.email", "Email is required.");

    }
}

