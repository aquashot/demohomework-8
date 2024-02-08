package com.exampleskypro.demohomework8.exception;

public class EmployeeStorageIsFullException extends RuntimeException{
    public EmployeeStorageIsFullException() {
        super("Превышен лимит сотрудников");
    }
}
