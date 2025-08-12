package com.project.inventory_management.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAccessController {

    @PostMapping
    public ResponseEntity<String> login(){

        return new ResponseEntity<>("done", HttpStatus.OK);
    }

}
