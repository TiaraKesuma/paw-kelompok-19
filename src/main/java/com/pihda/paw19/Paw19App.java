package com.pihda.paw19;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.pihda.paw19.entity.Employee;

import java.io.File;

public class Paw19App {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Employee employee = objectMapper.readValue(new File("data/sample-full.json"), Employee.class);
            System.out.println("First name: " + employee.getFirstName());
            System.out.println("Last name: " + employee.getLastName());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
