package com.project.inventory_management.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<String> createAccount(){

        return new ResponseEntity<>("done", HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<String> login(){

        return new ResponseEntity<>("done", HttpStatus.OK);
    }

}
