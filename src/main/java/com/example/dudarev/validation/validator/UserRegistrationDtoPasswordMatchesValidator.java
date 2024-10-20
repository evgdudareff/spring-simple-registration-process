package com.example.dudarev.validation.validator;

import com.example.dudarev.dto.UserRegistrationDto;
import com.example.dudarev.validation.annotation.PasswordMatches;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UserRegistrationDtoPasswordMatchesValidator
        implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context){
        UserRegistrationDto user = (UserRegistrationDto) obj;
        return user.getPassword().equals(user.getMatchingPassword());
    }
}
