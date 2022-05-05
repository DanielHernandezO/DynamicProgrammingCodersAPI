package com.example.DynamicProgrammingCoders.exception;

public class UserDoesntExist extends RuntimeException{
    public UserDoesntExist() {
        super();
    }

    public UserDoesntExist(String message) {
        super(message);
    }
}
