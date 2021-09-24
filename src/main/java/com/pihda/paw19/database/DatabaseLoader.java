//package com.pihda.paw19.database;
//
//import com.pihda.paw19.entity.Employee;
//import com.pihda.paw19.entity.EmployeeRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//@Component
//public class DatabaseLoader implements CommandLineRunner {
//
//    private final EmployeeRepository repository;
//
//    @Autowired
//    public DatabaseLoader(EmployeeRepository repository) {
//        this.repository = repository;
//    }
//
//    @Override
//    public void run(String... strings) {
//        this.repository.save(new Employee("Frodo", "Baggins", Employee.Role.JANITOR));
//    }
//}