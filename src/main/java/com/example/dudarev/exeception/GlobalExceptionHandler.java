package com.example.dudarev.exeception;

import com.example.dudarev.dto.UserRegistrationDto;
import com.example.dudarev.validation.constants.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.*;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<Map<String, List<Map<String, String>>>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<Map<String, String>> errors = new ArrayList<>();
        Map<String, List<Map<String, String>>> responseData = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            Map<String, String> errorShape = new HashMap<>();
            String errorMessage = error.getDefaultMessage();

            if (error instanceof FieldError) {
                String fieldName = ((FieldError) error).getField();
                errorShape.put("key", fieldName);
            }

            else if (error instanceof ObjectError) {
                String objectName = error.getObjectName();

                if (objectName.equalsIgnoreCase(UserRegistrationDto.class.getSimpleName())
                        && Objects.equals(errorMessage, ErrorMessage.PASSWORD_MISMATCH)) {
                    errorShape.put("key", "password");
                }

            }

            errorShape.put("reason", errorMessage);
            errors.add(errorShape);
        });

        responseData.put("errors", errors);

        return new ResponseEntity<>(responseData, HttpStatus.BAD_REQUEST);
    }



}
