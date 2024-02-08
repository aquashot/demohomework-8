package com.exampleskypro.demohomework8.controller;

import com.exampleskypro.demohomework8.model.Employee;
import com.exampleskypro.demohomework8.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;
@Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String firstName,@RequestParam String lastName) {
        return employeeService.findWorker(firstName, lastName);


    }
}
