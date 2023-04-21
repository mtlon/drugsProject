package com.application.drugsProject.api.exception;

public class DrugNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1;

    public DrugNotFoundException(String message) {
        super(message);
    }
}
