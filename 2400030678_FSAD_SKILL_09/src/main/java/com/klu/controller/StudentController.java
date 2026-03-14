package com.klu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.klu.exception.InvalidInputException;
import com.klu.exception.StudentNotFoundException;
import com.klu.model.Student;

@RestController
@RequestMapping("/students")
public class StudentController {

    List<Student> students = new ArrayList<>();

    public StudentController() {

        students.add(new Student(1,"Yaswanth","CSE"));
        students.add(new Student(2,"Rahul","AI"));

    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable String id) {

        int studentId;

        try {
            studentId = Integer.parseInt(id);
        }
        catch(NumberFormatException e) {
            throw new InvalidInputException("Student ID must be a number");
        }

        for(Student s : students) {
            if(s.getId() == studentId) {
                return s;
            }
        }

        throw new StudentNotFoundException("Student not found with ID " + studentId);
    }
}