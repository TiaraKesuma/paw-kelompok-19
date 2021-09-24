package com.pihda.paw19.rest;

import com.pihda.paw19.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    List<Student> students;

    @PostConstruct
    public void loadData() {
        students = new ArrayList<>();
        students.add(new Student("Ahmad", "Zidan"));
        students.add(new Student("Afrizal", "Fayiz"));
        students.add(new Student("Firas", "Sadad"));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        if (studentId >= students.size() || studentId < 0)
            throw new StudentNotFoundException("Student with id : " + studentId + " not found.");
        return students.get(studentId);
    }


}
