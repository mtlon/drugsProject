package com.application.drugsProject.cms.exception;

public class DrugNotFoundControllerCms extends RuntimeException{
    private static final long serialVersionUID = 1;

    public DrugNotFoundControllerCms(String message) {
        super(message);
    }
}
