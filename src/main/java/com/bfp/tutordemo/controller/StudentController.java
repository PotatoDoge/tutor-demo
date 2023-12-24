package com.bfp.tutordemo.controller;

import com.bfp.tutordemo.entity.dto.StudentDTO;
import com.bfp.tutordemo.response.HttpResponse;
import com.bfp.tutordemo.service.impl.StudentService;
import jakarta.validation.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static java.time.LocalTime.now;
import static java.util.Map.of;

@RestController
@RequestMapping("students")
@AllArgsConstructor
@CrossOrigin("http://localhost:4200")
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public HttpResponse getStudents(){
        return HttpResponse
                .builder()
                .timestamp(now().toString())
                .data(of("students",studentService.findAll()))
                .message("Students retrieved!")
                .status(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .build();
    }
    @GetMapping("{id}")
    public HttpResponse getStudentById(@PathVariable("id") Long id){
        return HttpResponse
                .builder()
                .timestamp(now().toString())
                .data(of("student",studentService.findById(id)))
                .message("Student retrieved!")
                .status(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .build();
    }

    @PostMapping
    public HttpResponse createStudent(@Valid @RequestBody StudentDTO student){
        return HttpResponse
                .builder()
                .timestamp(now().toString())
                .data(of("student",studentService.save(student)))
                .message("Student created!")
                .status(HttpStatus.CREATED)
                .statusCode(HttpStatus.CREATED.value())
                .build();
    }

    @PutMapping("{id}")
    public HttpResponse updateStudent(@PathVariable("id")Long id, @Valid @RequestBody StudentDTO studentDTO){
        return HttpResponse
                .builder()
                .timestamp(now().toString())
                .data(of("student",studentService.update(id,studentDTO)))
                .message("Student updated!")
                .status(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .build();
    }

    @DeleteMapping("{id}")
    public HttpResponse deleteStudentById(@PathVariable("id")Long id){
        studentService.delete(id);
        return HttpResponse
                .builder()
                .timestamp(now().toString())
                .message("Student deleted!")
                .status(HttpStatus.NO_CONTENT)
                .statusCode(HttpStatus.NO_CONTENT.value())
                .build();
    }
}
