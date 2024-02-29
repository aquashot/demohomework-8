package com.exampleskypro.demohomework8.service;

import com.exampleskypro.demohomework8.exception.EmployeeNotFoundException;
import com.exampleskypro.demohomework8.exception.EmployeeStorageIsFullException;
import com.exampleskypro.demohomework8.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service
public class EmployeeService {
    private final Map<String, Employee> employees = new TreeMap<>();
    private static final int MAX_WORKERS = 100;

    public void addWorker(String firstName, String lastName,Double salary,int department) {
        Employee addWorker = new Employee(firstName, lastName,salary,department);
        if (employees.size() > MAX_WORKERS) {
            throw new EmployeeStorageIsFullException();
        }
        if (employees.containsKey(addWorker.toString())) {
            throw new EmployeeNotFoundException();
        }
        employees.put(addWorker.toString(), addWorker);
    }

    public void deleteWorker(String firstName, String lastName,Double salary,int department) {
        Employee delWorker = new Employee(firstName, lastName,salary,department);
        if (employees.containsKey(delWorker.toString())) {
            employees.remove(delWorker.toString());
        } else {
            throw new EmployeeNotFoundException();
        }

    }

    public Employee findWorker(String firstName, String lastName,Double salary,int department) {
        Employee findWorker = new Employee(firstName, lastName,salary,department);
        if (employees.containsKey(findWorker.toString())) {
            return employees.get(findWorker.toString());
        } else {
            throw new EmployeeNotFoundException();
        }


    }

    public List<Employee> allWorkers() {
        return (List<Employee>) employees.values();
    }


}
