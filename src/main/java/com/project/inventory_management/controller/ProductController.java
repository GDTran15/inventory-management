package com.project.inventory_management.controller;

import com.project.inventory_management.dto.ApiResponse;
import com.project.inventory_management.model.Product;
import com.project.inventory_management.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("products")
public class ProductController {

    private final ProductService productService;

    @GetMapping()
    public ResponseEntity<ApiResponse<List<Product>>> viewAllProduct(){
        List<Product> products =  productService.getAllProduct();
        return ResponseEntity.ok(ApiResponse.success(products));
    }

    @PostMapping()
    public ResponseEntity<ApiResponse<List<Product>>> addNewProduct(@Valid @RequestBody   ){
        productService.
    }





}
