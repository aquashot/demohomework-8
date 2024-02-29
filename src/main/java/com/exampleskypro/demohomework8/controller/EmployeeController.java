package com.exampleskypro.demohomework8.controller;

import com.exampleskypro.demohomework8.model.Employee;
import com.exampleskypro.demohomework8.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

      @GetMapping(path = "/find")
     public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName, @RequestParam Double salary, @RequestParam int department) {
          return employeeService.findWorker(firstName, lastName,salary,department);
     }
    @PostMapping(path = "/add")
    public void addEmployee(@RequestParam String firstName, @RequestParam String lastName, @RequestParam Double salary, @RequestParam int department) {
         employeeService.addWorker(firstName, lastName,salary,department);
   }


  @DeleteMapping("/delete")
  public void deleteEmployee(@RequestParam String firstName, @RequestParam String lastName, @RequestParam Double salary, @RequestParam int department) {
      employeeService.deleteWorker(firstName, lastName,salary,department);
  }
   @GetMapping(path = "/all")
   public List<Employee> allWorkers() {
    return employeeService.allWorkers();
   }
}
