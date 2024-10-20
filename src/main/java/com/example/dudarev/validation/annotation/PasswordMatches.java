package com.example.dudarev.validation.annotation;

import com.example.dudarev.validation.constants.ErrorMessage;
import com.example.dudarev.validation.validator.UserRegistrationDtoPasswordMatchesValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE,ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = UserRegistrationDtoPasswordMatchesValidator.class)
@Documented
public @interface PasswordMatches {
    String message() default ErrorMessage.PASSWORD_MISMATCH;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
