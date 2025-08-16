package com.project.inventory_management.dto;


import com.project.inventory_management.model.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UpdateAccountDTORequest(
        @NotBlank
        String password,
        @Email
        String email,
        @NotBlank
        String phone,
        @NotBlank
        Role role
) {
}
