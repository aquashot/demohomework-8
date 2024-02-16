package com.exampleskypro.demohomework8.service;

import com.exampleskypro.demohomework8.exception.EmployeeAlreadyAddedException;
import com.exampleskypro.demohomework8.exception.EmployeeNotFoundException;
import com.exampleskypro.demohomework8.exception.EmployeeStorageIsFullException;
import com.exampleskypro.demohomework8.model.Employee;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService {
    private final List<Employee> employees = new ArrayList<>();
    private static final int MAX_WORKERS = 100;

    public void addWorker(String firstName, String lastName) {
        Employee worker = new Employee(firstName, lastName);
        if (employees.size() >= MAX_WORKERS) {
            throw new EmployeeStorageIsFullException();
        } else if (employees.contains(worker)) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.add(worker);
    }

    public void deleteWorker(String firstName, String lastName) {
        Employee delWorker = new Employee(firstName, lastName);
        if (employees.contains(delWorker)) {
            employees.remove(delWorker);
        } else {
            throw new EmployeeNotFoundException();
        }

    }

    public Employee findWorker(String firstName, String lastName) {
        System.out.println(firstName + lastName);
        for (Employee employee : employees) {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
                return employee;

            }
        }

        throw new EmployeeNotFoundException();

    }

    public List<Employee> allWorkers() {
        return employees;
    }



}
