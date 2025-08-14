package com.project.inventory_management.controller;

import com.project.inventory_management.dto.ApiResponse;
import com.project.inventory_management.dto.CreateAccountRequestDTO;
import com.project.inventory_management.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserAccessController {

    private final UserService userService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("register")
    public ResponseEntity<ApiResponse<String>> createAccount(@Valid @RequestBody CreateAccountRequestDTO createAccountRequestDTO){
        userService.createUser(createAccountRequestDTO);
        return ResponseEntity.ok(ApiResponse.success("Register successfully"));
    }


    @PostMapping("login")
    public ResponseEntity<String> login(){
        return new ResponseEntity<>("done", HttpStatus.OK);
    }

}
