package com.exampleskypro.demohomework8.service;

import com.exampleskypro.demohomework8.model.Employee;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private final EmployeeService employeeService;


    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Employee getEmployeeWithMaxSalary(int departmentId){
        return employeeService.allWorkers().stream()
                .filter(e->e.getDepartment()==departmentId)
                .max(Comparator.comparingDouble(u->u.getSalary()))
                .orElse(null);
    }
    public Employee getEmployeeWithMinSalary(int departmentId){
        return employeeService.allWorkers().stream()
                .filter(e->e.getDepartment()==departmentId)
                .min(Comparator.comparingDouble(u->u.getSalary()))
                .orElse(null);
    }
    public List<Employee> getEmployeesByDepartment(int departmentId){
        return employeeService.allWorkers().stream()
                .filter(e->e.getDepartment()==departmentId)
                .collect(Collectors.toList());
    }
    public Map<Integer,List<Employee>> getEmployeesGrouped(){
       return employeeService.allWorkers().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}


