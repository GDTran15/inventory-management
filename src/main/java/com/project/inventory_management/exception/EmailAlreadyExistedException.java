package com.project.inventory_management.exception;

public class EmailAlreadyExistedException extends RuntimeException {
    public EmailAlreadyExistedException() {
        super("Email already existed");
    }
}
