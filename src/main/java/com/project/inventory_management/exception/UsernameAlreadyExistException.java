package com.project.inventory_management.exception;

public class UsernameAlreadyExistException extends RuntimeException{

    public UsernameAlreadyExistException(){
        super("Username already exist");
    }

}
