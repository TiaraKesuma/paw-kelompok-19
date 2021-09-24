package com.pihda.paw19.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    @GetMapping("/students")
    public String sayHello() {
        return "Hello World";
    }
}
