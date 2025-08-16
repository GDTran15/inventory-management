package com.project.inventory_management.dto;



public record AddProductResponseDTO(
    Integer productId,
    String productName,
    double price,
    String description
    ){
}
