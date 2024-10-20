package com.example.dudarev.validation.annotation;

import com.example.dudarev.validation.constants.ErrorMessage;
import com.example.dudarev.validation.validator.EmailValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;


@Retention(RetentionPolicy.RUNTIME)
@Target({ANNOTATION_TYPE, TYPE, FIELD})
@Constraint(validatedBy = EmailValidator.class)
@Documented
public @interface ValidEmail {
    String message() default ErrorMessage.INVALID_EMAIL;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
