package com.revature.dndmonstercreator.util.exceptions;

public class InvalidUserInputException extends RuntimeException{

    public InvalidUserInputException() {
    }

    public InvalidUserInputException(String message) { super(message); }
}
