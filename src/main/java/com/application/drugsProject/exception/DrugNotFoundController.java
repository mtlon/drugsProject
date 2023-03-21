package com.application.drugsProject.exception;

public class DrugNotFoundController extends RuntimeException{
    private static final long serialVersionUID = 1;

    public DrugNotFoundController(String message) {
        super(message);
    }
}
