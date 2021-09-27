package com.pihda.paw19.rest;

import com.pihda.paw19.entity.Employee;
import com.pihda.paw19.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        this.employeeService = employeeService;
    }

    // add mapping for GET /employees/{employeeId}

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {

        Employee theEmployee = employeeService.getEmployee(employeeId);

        if (theEmployee == null) {
//            throw new EmployeeNotFoundException("Employee id not found - " + employeeId);
        }

        return theEmployee;
    }

    // add mapping for POST /employees  - add new employee

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee) {

        // also just in case the pass an id in JSON ... set id to 0
        // this is force a save of new item ... instead of update

        theEmployee.setId(0);

        employeeService.saveEmployee(theEmployee);

        return theEmployee;
    }

    // add mapping for PUT /employees - update existing employee

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee) {

        employeeService.saveEmployee(theEmployee);

        return theEmployee;

    }

    // add mapping for DELETE /employees/{employeeId} - delete employee

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {

        Employee tempEmployee = employeeService.getEmployee(employeeId);

        // throw exception if null

        if (tempEmployee == null) {
//            throw new EmployeeNotFoundException("Employee id not found - " + employeeId);
        }

        employeeService.deleteEmployee(employeeId);

        return "Deleted employee id - " + employeeId;
    }
}
