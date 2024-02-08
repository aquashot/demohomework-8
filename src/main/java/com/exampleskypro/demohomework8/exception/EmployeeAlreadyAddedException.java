package com.exampleskypro.demohomework8.exception;

public class EmployeeAlreadyAddedException extends RuntimeException{
    public EmployeeAlreadyAddedException() {
        super("Есть такой сотрудник");
    }
}
