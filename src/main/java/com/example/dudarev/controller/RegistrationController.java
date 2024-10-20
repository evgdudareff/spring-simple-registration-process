package com.example.dudarev.controller;

import com.example.dudarev.dto.UserRegistrationDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class RegistrationController {

    @PostMapping("/register")
    public String registerUser(@Valid @RequestBody UserRegistrationDto registrationDto) {
        // Логика обработки регистрации
        System.out.println("First Name: " + registrationDto.getFirstName());
        System.out.println("Last Name: " + registrationDto.getLastName());
        System.out.println("Password: " + registrationDto.getPassword());
        System.out.println("Matching Password: " + registrationDto.getMatchingPassword());

        // Вернуть ответ
        return "User registered successfully!";
    }

}
