package com.pihda.paw19.rest;

import com.pihda.paw19.entity.Employee;
import com.pihda.paw19.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    //    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();

    }

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        System.out.println(employeeService);
        this.employeeService = employeeService;
    }
}
