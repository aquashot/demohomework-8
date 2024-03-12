package com.exampleskypro.demohomework8.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeBadRequest extends  RuntimeException{
    public EmployeeBadRequest () {super ("Error 404");}
}
