package com.project.inventory_management.dto;

public record LoginDTOResponse(
        Long userId,
        String token
) {
}
