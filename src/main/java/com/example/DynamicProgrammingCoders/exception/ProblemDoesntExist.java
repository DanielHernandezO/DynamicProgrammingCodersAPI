package com.example.DynamicProgrammingCoders.exception;

public class ProblemDoesntExist extends RuntimeException{
    public ProblemDoesntExist() {
        super();
    }

    public ProblemDoesntExist(String message) {
        super(message);
    }
}
