package com.project.inventory_management.dto;

import jakarta.validation.constraints.NotBlank;

public record LoginDTORequest(
        @NotBlank()
        String username,
        @NotBlank()
        String password
) {
}
