package com.example.DynamicProgrammingCoders.exception;

public class UserAlreadyExist extends RuntimeException{
    public UserAlreadyExist() {
        super();
    }

    public UserAlreadyExist(String message) {
        super(message);
    }
}
