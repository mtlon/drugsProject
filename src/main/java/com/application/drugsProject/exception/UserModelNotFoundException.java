package com.application.drugsProject.exception;

public class UserModelNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1;

    public UserModelNotFoundException(String message) {
        super(message);
    }
}
