package com.example.dudarev.dto;

import com.example.dudarev.validation.annotation.PasswordMatches;
import com.example.dudarev.validation.annotation.ValidEmail;
import com.example.dudarev.validation.constants.ErrorMessage;
import jakarta.validation.constraints.NotBlank;

import lombok.Data;

@Data
@PasswordMatches
public class UserRegistrationDto {
    @NotBlank(message = ErrorMessage.NOT_BLANK)
    private String firstName;

    @NotBlank(message = ErrorMessage.NOT_BLANK)
    private String lastName;

    @NotBlank(message = ErrorMessage.NOT_BLANK)
    private String password;
    private String matchingPassword;

    @NotBlank(message = ErrorMessage.NOT_BLANK)
    @ValidEmail()
    private String email;
}
