package com.project.inventory_management.dto;


import com.project.inventory_management.model.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public record CreateAccountRequestDTO(
        @Size(min = 6, message = "Username must be at least 6 characters")
        String username,
        @Size(min = 6, message = "Password must be at least 6 characters")
        String password,
        @Email(message = "Invalid email format")
        String email,
        @Size(min = 10, message = "Phone number must be at least 10 digits")
        String phone,
        Role role
) {


}
