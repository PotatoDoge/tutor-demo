package com.bfp.tutordemo.controller;

import com.bfp.tutordemo.entity.dto.StudentDTO;
import com.bfp.tutordemo.response.HttpResponse;
import jakarta.validation.*;
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
    public HttpResponse createStudent(@Valid @RequestBody StudentDTO student){
        return HttpResponse.builder().message(student.toString()).build();
    }

    @PutMapping("{id}")
    public HttpResponse updateStudent(@PathVariable("id")Long id, @Valid @RequestBody StudentDTO student){
        return HttpResponse.builder().message(student.toString()).build();
    }

    @DeleteMapping("{id}")
    public String deleteStudentById(@PathVariable("id")Long id){
        return "delete student";
    }
}
