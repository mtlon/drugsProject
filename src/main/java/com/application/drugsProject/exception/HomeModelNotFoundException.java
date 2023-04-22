package com.application.drugsProject.exception;

public class HomeModelNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1;

    public HomeModelNotFoundException(String message) {
        super(message);
    }
}
