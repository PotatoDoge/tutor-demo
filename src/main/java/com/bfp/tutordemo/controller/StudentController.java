package com.bfp.tutordemo.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("students")
@AllArgsConstructor
public class StudentController {

    @GetMapping
    public String getStudents(){
        return "Students";
    }
    @GetMapping("{id}")
    public String getStudentById(@PathVariable("id") Long id){
        return "Students by id";
    }

    @PostMapping
    public String createStudent(){
        return "create student";
    }

    @PutMapping("{id}")
    public String updateStudent(@PathVariable("id")Long id){
        return "update student";
    }

    @DeleteMapping("{id}")
    public String deleteStudentById(@PathVariable("id")Long id){
        return "delete student";
    }
}
