package com.project.inventory_management.controller;

import com.project.inventory_management.dto.ApiResponse;
import com.project.inventory_management.dto.CreateAccountRequestDTO;
import com.project.inventory_management.dto.LoginDTORequest;
import com.project.inventory_management.dto.LoginDTOResponse;
import com.project.inventory_management.model.User;
import com.project.inventory_management.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserAccessController {

    private final UserService userService;

   @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("users")
    public ResponseEntity<ApiResponse<String>> createAccount(@Valid @RequestBody CreateAccountRequestDTO createAccountRequestDTO){
        System.out.println("controller");
        userService.createUser(createAccountRequestDTO);
        return ResponseEntity.ok(ApiResponse.success("Register successfully"));
    }


    @PostMapping("login")
    public ResponseEntity<ApiResponse<LoginDTOResponse>> login(@Valid @RequestBody LoginDTORequest loginDTORequest){
        LoginDTOResponse loginDTOResponse = userService.loginUser(loginDTORequest);
        if (loginDTOResponse == null){
            return ResponseEntity.ok(ApiResponse.error("Login failed"));
        }
        return ResponseEntity.ok(ApiResponse.success(loginDTOResponse));
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("users")
    public ResponseEntity<ApiResponse<List<User>>> getAllAccount(){
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(ApiResponse.success(users));
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("users/{userId}")
    public ResponseEntity<ApiResponse<String>> deleteAccount(@PathVariable Long userId){
       userService.deleteUser(userId);
       return ResponseEntity.ok(ApiResponse.success("Account was deleted"));
    }


}
