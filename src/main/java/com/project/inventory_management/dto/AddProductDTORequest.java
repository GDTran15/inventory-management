package com.project.inventory_management.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AddProductDTORequest(
        @NotBlank
        String productName,
        @NotNull
        double price,
        @NotBlank
        String description
) {
}
